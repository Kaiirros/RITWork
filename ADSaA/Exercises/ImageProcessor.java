import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; 

public class ImageProcessor {
   static int processPixel(int p, String type) {
      // add your code here

      int a = 0xFF;
      // unpack values from the pixel
      int red = ( p >> 16 ) & a;
      int green = ( p >> 8 ) & a;
      int blue = (p & a );
      int newRed = 0;
      int newGreen = 0;
      int newBlue = 0;
      

      // process pixel based on type
      if (type.equals("grayscale")){
         int average = (red + green + blue)/3;
         newRed = average;
         newGreen = average;
         newBlue = average;
      }
      if (type.equals("sepia")){

      }
      if (type.equals("negative")){

      }

      // pack values back into the pixel
      p = 0;
      p |= newRed << 16;
      p |= newGreen << 8;
      p |= newBlue;

      return p;
   }
   
   static void processImage(String inFilename, String outFilename, String type) {
      BufferedImage img = null;
      File f = null;
      
      // load image
      try {
         f = new File(inFilename);
         img = ImageIO.read(f);
      }
      catch(IOException e) {
         System.out.println(e);
      }
      
      // get image width and height
      int width = img.getWidth();
      int height = img.getHeight();
      
      // process all pixels in the image
      for(int x = 0; x < width; x++) {
         for(int y = 0; y < height; y++) {
            int p = img.getRGB(x,y);
            p = processPixel(p, type);
            img.setRGB(x, y, p);
         }
      }
      
      // write image to file
      try {
         f = new File(outFilename);
         ImageIO.write(img, "jpg", f);
      }
      catch(IOException e) {
         System.out.println(e);
      }
   }

   public static void main(String args[]) {
      processImage("ADSaA\\Exercises\\Taj.jpg", "ADSaA\\Exercises\\Taj_negative.jpg", "negative");
      processImage("ADSaA\\Exercises\\Taj.jpg", "ADSaA\\Exercises\\Taj_sepia.jpg", "sepia");
      processImage("ADSaA\\Exercises\\Taj.jpg", "ADSaA\\Exercises\\Taj_grayscale.jpg", "grayscale");
   }
}
