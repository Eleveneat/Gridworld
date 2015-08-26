import java.awt.Image;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO; 

import imagereader.IImageIO;

public class myImageIO implements IImageIO{
    private final static int BF_HEAD_BYTE = 14;
    private final static int BF_INFO_BYTE = 40;
    private final static int FOUR_BYTE = 4;
    private final static int MULTICOLOUR = 24;
    private final static int GRAY = 8;
    private int bitCount;

	public Image myRead(String arg0) throws IOException {
        FileInputStream file = new FileInputStream(arg0);
        byte bHead[] = new byte[BF_HEAD_BYTE];
        byte bInfo[] = new byte[BF_INFO_BYTE];
        byte originalRGB[];
        int width, height, imageSize, npad, pixelSize, offset;
        int RGBDate[];
        Image image = null;

        try {
            file.read(bHead, 0, BF_HEAD_BYTE);
            file.read(bInfo, 0, BF_INFO_BYTE);

            // 偏移量
            offset = ( ( (int) bHead[13] & 0xff) << 24)
                | ( ( (int) bHead[12] & 0xff) << 16)
                | ( ( (int) bHead[11] & 0xff) << 8)
                | (int) bHead[10] & 0xff;

            offset -= 54;

            // 图像宽度
            width = ( ( (int) bInfo[7] & 0xff) << 24)
                | ( ( (int) bInfo[6] & 0xff) << 16)
                | ( ( (int) bInfo[5] & 0xff) << 8)
                | (int) bInfo[4] & 0xff;

            // 图像高度
            height = ( ( (int) bInfo[11] & 0xff) << 24)
                | ( ( (int) bInfo[10] & 0xff) << 16)
                | ( ( (int) bInfo[9] & 0xff) << 8)
                | (int) bInfo[8] & 0xff;
            
            // 图像位数
            bitCount = ( ( (int) bInfo[15] & 0xff) << 8) | (int) bInfo[14] & 0xff;

            // 图像大小。原始（:en:raw）位图数据的大小，不要与文件大小混淆
            imageSize = ( ( (int) bInfo[23] & 0xff) << 24)
                | ( ( (int) bInfo[22] & 0xff) << 16)
                | ( ( (int) bInfo[21] & 0xff) << 8)
                | (int) bInfo[20] & 0xff;


            if (bitCount == MULTICOLOUR) {
                // 计算空字节
                npad = (imageSize / height) - width * 3;
                if (npad == FOUR_BYTE) {
                    npad = 0;
                }
                
                // 计算 pixel 大小
                pixelSize = (width + npad) * 3 * height;

                if (npad != 0) {
                    originalRGB = new byte[pixelSize];
                } else {
                    originalRGB = new byte[imageSize];
                }

                // 读取所有RGB数据
                file.read(originalRGB, 0, pixelSize);
                RGBDate = new int[height * width];

                int index = 0;
                for (int j = 0; j < height; j++) {
                    for (int i = 0; i < width; i++) {
                        RGBDate[width * (height - j - 1) + i] =
                            (255 & 0xff) << 24  
                            | (((int)originalRGB[index + 2] & 0xff) << 16)  
                            | (((int)originalRGB[index + 1] & 0xff) << 8)  
                            | (int)originalRGB[index] & 0xff;
                        index += 3;
                    }
                    index += npad;
                }

                image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(width, height, RGBDate, 0, width));
            }

            if (bitCount == GRAY) {
                // 计算空字节
                npad = (imageSize / height) - width;
                if (npad == FOUR_BYTE) {
                    npad = 0;
                }
                
                // 计算 pixel 大小
                pixelSize = (width + npad) * height;

                if (npad != 0) {
                    originalRGB = new byte[pixelSize];
                } else {
                    originalRGB = new byte[imageSize];
                }

            	originalRGB = new byte[pixelSize];
            	
                // 读取所有RGB数据
                file.read(originalRGB, 0, pixelSize);
                RGBDate = new int[height * width];

                int index = offset;
                for (int j = 0; j < height; j++) {
                    for (int i = 0; i < width; i++) {
                        if (index >= pixelSize)
                            index = 0;
                        RGBDate[width * (height - j - 1) + i] =
                            (255 & 0xff) << 24  
                            | (((int)originalRGB[index] & 0xff) << 16)  
                            | (((int)originalRGB[index] & 0xff) << 8)  
                            | (int)originalRGB[index] & 0xff;
                        index += 1;
                    }
                    index += npad;
                }

                image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(width, height, RGBDate, 0, width));
            }
            
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

		return image;
	}

	public Image myWrite(Image image, String file) throws IOException {
        try {
            int height = image.getHeight(null);
            int width = image.getWidth(null);
            int fileType;

            if (bitCount == MULTICOLOUR)
                fileType = BufferedImage.TYPE_3BYTE_BGR;
            else
                fileType = BufferedImage.TYPE_BYTE_GRAY;

            // 创建图片
            BufferedImage bi = new BufferedImage(width, height, fileType);
            bi.getGraphics().drawImage(image, 0, 0, null);
            // 打开文件
            File iFile= new File(file + ".bmp");
            ImageIO.write(bi, "bmp", iFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

		return image;
	}
}
