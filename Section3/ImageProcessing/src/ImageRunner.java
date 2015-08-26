import imagereader.Runner;
//import imagereader.IImageIO;
//import imagereader.IImageProcessor;

public final class ImageRunner {

	private ImageRunner() {}
	 public static void main(String[] args) {
	        myImageIO imageioer = new myImageIO();  
	        ImageProcessor processor = new ImageProcessor();  
	        Runner.run(imageioer, processor);  
	 } 
}
