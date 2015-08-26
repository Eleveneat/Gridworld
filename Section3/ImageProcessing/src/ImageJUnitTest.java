import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.FileInputStream;
import java.awt.image.BufferedImage;
import java.awt.Image;

import javax.imageio.ImageIO;

public class ImageJUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBlue1() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/1.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image blue = processor.showChanelB(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/1_blue_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = blue.getWidth(null);
		int d = blue.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(blue, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(blue.getWidth(null), testImage.getWidth(null));
		assertEquals(blue.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testBlue2() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/2.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image blue = processor.showChanelB(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/2_blue_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = blue.getWidth(null);
		int d = blue.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(blue, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(blue.getWidth(null), testImage.getWidth(null));
		assertEquals(blue.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testGreen1() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/1.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image green = processor.showChanelG(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/1_green_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = green.getWidth(null);
		int d = green.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(green, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(green.getWidth(null), testImage.getWidth(null));
		assertEquals(green.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testGreen2() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/2.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image green = processor.showChanelG(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/2_green_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = green.getWidth(null);
		int d = green.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(green, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(green.getWidth(null), testImage.getWidth(null));
		assertEquals(green.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testRed1() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/1.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image red = processor.showChanelR(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/1_red_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = red.getWidth(null);
		int d = red.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(red, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(red.getWidth(null), testImage.getWidth(null));
		assertEquals(red.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testRed2() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/2.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image red = processor.showChanelR(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/2_red_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = red.getWidth(null);
		int d = red.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(red, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(red.getWidth(null), testImage.getWidth(null));
		assertEquals(red.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testGray1() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/1.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image gray = processor.showGray(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/1_gray_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = gray.getWidth(null);
		int d = gray.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(gray, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(gray.getWidth(null), testImage.getWidth(null));
		assertEquals(gray.getHeight(null), testImage.getHeight(null));
	}

	@Test
	public void testGray2() throws IOException {
		myImageIO myImage = new myImageIO();
		Image image= myImage.myRead("/Users/eleven/Documents/workspace/ImageProcessing/goal/2.bmp");

		ImageProcessor processor = new ImageProcessor(); 
		Image gray = processor.showGray(image);

		FileInputStream testFile = new FileInputStream("/Users/eleven/Documents/workspace/ImageProcessing/goal/2_gray_goal.bmp");
		BufferedImage testImage = ImageIO.read(testFile);

		int w = gray.getWidth(null);
		int d = gray.getHeight(null);
		BufferedImage myTestImage = new BufferedImage(w, d, BufferedImage.TYPE_INT_BGR);
        myTestImage.getGraphics().drawImage(gray, 0, 0, w, d, null);   
		
		for (int i = 0; i < testImage.getWidth(null); i++)
			for (int j = 0; j < testImage.getHeight(null); j++)
				assertEquals(testImage.getRGB(i, j), myTestImage.getRGB(i, j));

		assertEquals(gray.getWidth(null), testImage.getWidth(null));
		assertEquals(gray.getHeight(null), testImage.getHeight(null));
	}

}
