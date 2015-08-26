import imagereader.IImageProcessor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;


public class ImageProcessor implements IImageProcessor {

    class RedSwapFilter extends RGBImageFilter {
        public int filterRGB(int x, int y, int rgb) {
            return rgb & 0xffff0000;
        }
    }

	public Image showChanelR(Image image) {
        RedSwapFilter red = new RedSwapFilter();
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(),red));
	}

    class GreenSwapFilter extends RGBImageFilter {
        public int filterRGB(int x, int y, int rgb) {
            return rgb & 0xff00ff00;
        }
    }

	public Image showChanelG(Image image) {
        GreenSwapFilter green = new GreenSwapFilter();
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(),green));
	}

    class BlueSwapFilter extends RGBImageFilter {
        public int filterRGB(int x, int y, int rgb) {
            return rgb & 0xff0000ff;
        }
    }

	public Image showChanelB(Image image) {
        BlueSwapFilter blue = new BlueSwapFilter();
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(),blue));
	}

    class GraySwapFilter extends RGBImageFilter {
        public int filterRGB(int x, int y, int rgb) {
            int red = (rgb & 0x00ff0000) >> 16;
            int green = (rgb & 0x0000ff00) >> 8;
            int blue = (rgb & 0x000000ff);
            int gray = (int)(0.299 * red + 0.587 * green + 0.114 * blue);
            return (rgb & 0xff000000)+(gray << 16)+(gray << 8) + gray;
        }
    }

	public Image showGray(Image image) {
        GraySwapFilter gray = new GraySwapFilter();
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(),gray));
	}
}
