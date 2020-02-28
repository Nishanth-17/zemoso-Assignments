
    /**
     * Create a gray scale version of an image by setting all color components of each pixel to the same value.
     *
     * @author Duke Software Team
     */
import edu.duke.*;
import java.io.*;
     class GrayScaleImage {
         public ImageResource makeGray(ImageResource inImage) {
             ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
             for (Pixel pixel : outImage.pixels()) {
                 Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                 int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
                 pixel.setRed(average);
                 pixel.setGreen(average);
                 pixel.setBlue(average);
             }
             return outImage;
         }
         public ImageResource makeInverted(ImageResource inImage) {
             ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
             for (Pixel pixel : outImage.pixels()) {
                 Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                 int average = ((255-inPixel.getRed()) + (255-inPixel.getBlue()) + (255-inPixel.getGreen())) / 3;
                 pixel.setRed(average);
                 pixel.setGreen(average);
                 pixel.setBlue(average);
             }
             return outImage;
         }
         public void testGray() {
             DirectoryResource dr = new DirectoryResource();
             for (File f : dr.selectedFiles()) {
                 ImageResource ir = new ImageResource(f);
                 String FileName = ir.getFileName();
                 String NewName = "gray-" + FileName;
                 ImageResource gray = makeGray(ir);
                 gray.setFileName(NewName);
                 gray.draw();
                 gray.save();
             }
         }
         public void testInverted() {
             DirectoryResource dr = new DirectoryResource();
             for (File f : dr.selectedFiles()) {
                 ImageResource ir = new ImageResource(f);
                 String FileName = ir.getFileName();
                 String NewName = "inverted-" + FileName;
                 ImageResource inverted = makeInverted(ir);
                 inverted.setFileName(NewName);
                 inverted.draw();
                 inverted.save();
             }
         }
     }
    public class GrayScale{
         public static void main(String args[]){
             GrayScaleImage im=new GrayScaleImage();
             //im.testGray();
             im.testInverted();
         }
    }

