//Required imports for this lab.  Do not remove.
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.util.Iterator;

/**
 * Class to manipulate images as 2D arrays of pixels
 * I approached this lab by ignoring the idea of pixels and doing the task on any 2d array.
 * A challenge that I faced was getting the crop function to have negative starting pixel values. For me, I emphasied making my code more readable
 * @author Divya Subramanian
 * @version 2.0
 */
public class Lab2
{
  /**
   * main method for your application
   * @param args for main method
   */
  public static void main(String[] args)
  {
    //List of images that need to be processed
    String[] imageName = {"beach", "blueMotorcycle", "butterfly",  "flower", "koala", "marilyn", "redMotorcycle", "swan"};

    //THE FOLLOWING LOOPS TEST ALL THE FUNCTIONS WITH ALL IMAGES

    // loops through all images and calls negate function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      negate(image);
      writeImage(image, "ResultImages/" + imageName[n] + "-negate.png");
    }

    // loops through all images and calls mirror function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      mirror(image);
      writeImage(image, "ResultImages/" + imageName[n] + "-mirror.png");
    }

    // loops through all images and calls edgeDetection function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      Pixel[][] edgeImage = edgeDetection(image);
      writeImage(edgeImage, "ResultImages/" + imageName[n] + "-edgeDetection.png");
    }

    // loops through all images and calls blur function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      //prior to submission multiple variables were tested
      Pixel[][] blurImage = blur(image, 5);
      writeImage(blurImage, "ResultImages/" + imageName[n] + "-blur.png");
    }

    // loops through all images and calls crop function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      //prior to submission, multiple inputs were tested - this is the same inputs used in example
      Pixel[][] cropImage = crop(image, 30, 40, 500, 250);
      writeImage(cropImage, "ResultImages/" + imageName[n] + "-crop.png");
    }

    // loops through all images and calls popArt function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      Pixel[][] popArtImage = popArt(image);
      writeImage(popArtImage, "ResultImages/" + imageName[n] + "-popArt.png");
    }

    // loops through all images and calls compress function
    for (int n = 0; n < imageName.length; n++)
    {
      Pixel[][] image = readImage("InputImages/" + imageName[n] + ".png");
      compress(image);
      writeImage(image, "ResultImages/" + imageName[n] + "-compress.png");
    }

  } //end method

  /**
   * Method to read an image from a png file and store into a 2D array of pixels
   * @param filename The file that contains the image
   * @return 2D array of pixels
   */
  public static Pixel[][] readImage(String filename)
  {
    // Read the image as a buffered image
    BufferedImage img = null;
    try
    {
      File infile = new File(filename);
      img = ImageIO.read(infile);
    }
    catch(IOException e)
    {
      System.out.println("Cannot read file " + filename);
      System.exit(1);
    }
    // Create a 2D array of pixels with the same size as the buffered image
    int width = img.getWidth();
    int height = img.getHeight();
    Pixel[][] image = new Pixel[height][width];
    for(int i = 0; i < height; i++)
      for(int j = 0; j < width; j++)
      {
        int[] RGB = Pixel.ValueToRGB(img.getRGB(j, i));
        image[i][j] = new Pixel(RGB[0], RGB[1], RGB[2]);
      }
    // Return the 2D array of pixels
    return image;
  }

  /**
   * Method to write an image stored in a 2D array of pixels to a jpg file
   * @param image The 2D array of pixels
   * @param filename The file that contains the image
   */
  public static void writeImage(Pixel[][] image, String filename)
  {
    // Create a buffered image of the same size as the 2D array of pixels
    int height = image.length;
    int width = image[0].length;
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // Scan all the pixels in the image and set the color value
    for(int i = 0; i < height; i++)
      for(int j = 0; j < width ; j++)
      {
        int red = image[i][j].getRed();
        int green = image[i][j].getGreen();
        int blue = image[i][j].getBlue();
        int value = Pixel.RGBToValue(red, green, blue);
        img.setRGB(j, i, value);
      }
    // Write the buffered image
    try
    {
      File outfile = new File(filename);
      ImageIO.write(img, "png", outfile);
    }
    catch(IOException e)
    {
      System.out.println("Cannot write file " + filename);
      System.exit(1);
    }
  }

  /**
  * Method to invert an image by subtracting the r, g, and b values from 255
  * @param image The 2D array of pixels
  */
  public static void negate(Pixel[][] image)
  {
    //goes through every pixel in the 2d array
    for (int x = 0; x <= image.length - 1; x++)
    {
      for (int y = 0; y <= image[x].length - 1; y++)
      {
        //the new RGB values are 255 - the original value
        int newRed = 255 - image[x][y].getRed();
        int newGreen = 255 - image[x][y].getGreen();
        int newBlue = 255 - image[x][y].getBlue();

        //the pixel in the original image is set to the new values
        image[x][y].setRGB(newRed, newGreen, newBlue);
      }
    }
  }

  /**
  * Method to have the right half of a picture mirror the left half. The pixels in the original image are changed.
  * This is done by looping through the left half of the image and setting the corresponding right half (width of image - yval and same xval) to the left value.
  * @param image The 2D array of pixels
  */
  public static void mirror(Pixel[][] image)
  {
    int middleOfImage = image[0].length / 2;
    int widthOfImage = image[0].length - 1;
    int heightOfImage = image.length - 1;

    //loops through left half of image
    for (int x = 0; x <= heightOfImage; x++)
    {
      for (int y = 0; y < middleOfImage; y++)
      {
        //sets right counterpart of image with left image values
        image[x][widthOfImage - y] = image[x][y];
      }
    }
  }

  /**
  * A new Pixel array is created in which each pixel is compared with the left and above pixel (if applicable).
  * If the colod difference is greater than 30, the pixel in the new pixel array is colored black, otherwise colored white
  * @param image The 2D array of pixels
  * @return Pixel[][] Array contains edges that were detected
  */
  public static Pixel[][] edgeDetection(Pixel[][] image)
  {
    //new pixel array is created to store edges
    Pixel[][] edgeImage = new Pixel[image.length][image[0].length];

    //loops through all pixels in image
    for (int x = 0; x <= image.length - 1; x++)
    {
      for (int y = 0; y <= image[x].length - 1; y++)
      {
        // comparing current pixel with pixel above
        // makes sure the x value is greater than 0 which means there is a pixel above
        // calculates colorDistance with above pixel, and makes the pixel black if the difference > 30
        if (x >= 1 && colorDistance(image[x][y], image[x - 1][y]) > 30)
        {
          edgeImage[x][y] = new Pixel(0, 0, 0);
        }
        // comparing current pixel with pixel to the left;
        // makes sure the y value is greater than 0 which means there is a pixel to the left
        // calculates colorDistance with left pixel, and makes the pixel black if the difference > 30
        else if (y >= 1 && colorDistance(image[x][y], image[x][y - 1]) > 30)
        {
          edgeImage[x][y] = new Pixel(0, 0, 0);
        }
        // no significant color difference with left or top pixel
        else
        {
          edgeImage[x][y] = new Pixel(255, 255, 255);
        }
      }
    }

    return edgeImage;
  }

  /**
  * Method to calculate the color difference between two pixels by squaring the difference in R, G, and B values, then adding and taking the square root
  * @param p1 the Pixel compared with p2
  * @param p2 the Pixel compared with p1
  * @return double the distance between both pixels
  */
  public static double colorDistance(Pixel p1, Pixel p2)
  {
    //getting and storing the RGB values of both p1 and p2
    int r1 = p1.getRed();
    int g1 = p1.getGreen();
    int b1 = p1.getBlue();

    int r2 = p2.getRed();
    int g2 = p2.getGreen();
    int b2 = p2.getBlue();

    //calculating distance using formula received
    double distance = Math.sqrt((r1 - r2) * (r1 - r2) + (g1 - g2) * (g1 - g2) + (b1 - b2) * (b1 - b2));

    //returns the distance between pixels which is a double
    return distance;
  }

  /**
  * Method to blur an image by taking the average of all the pixels which are size/2 distance away
  * @param image The 2D array of pixels
  * @param size the block of pixels used to calculate average is size x size
  * @return Pixel[][] array of pixels which contains the blurred version of the image
  */
  public static Pixel[][] blur(Pixel[][] image, int size)
  {
    // creating new pixell array for blurred image
    Pixel[][] blurredImage = new Pixel[image.length][image[0].length];

    //loops through all pixels in original image
    for (int x = 0; x <= image.length - 1; x++)
    {
      for (int y = 0; y <= image[0].length - 1; y++)
      {
        //calls the getAverage function
        blurredImage[x][y] = getAverage(image, x, y, size);
      }
    }

    return blurredImage;
  }

  /**
  * Method to blur an image by taking the average of all the pixels which are size/2 distance away
  * @param image The 2D array of pixels
  * @param currentX the x value of the pixel whose surrounding average is being calculated
  * @param currentY the y value of the pixel whose surrounding average is being calculated
  * @param size the block of pixels used to calculate average is size x size
  * @return Pixel which has the RGB values of the average of the surrounding pixels
  */
  public static Pixel getAverage(Pixel[][] image, int currentX, int currentY, int size)
  {
    //initalizing variables that will store the sum of the R, G, or B values of surrounding pixels
    int redSum = 0;
    int greenSum = 0;
    int blueSum = 0;

    //keep track of how many pixels are being averaged
    int count = 0;

    //loops through the pixels that are size/2 pixels away from main pixel
    for (int row = currentX - size/2; row <= currentX + size/2; row++)
    {
      for (int col = currentY - size/2; col <= currentY + size/2; col++)
      {
        //makes sure that the pixel is within the image
        if (row >= 0 && row < image.length && col >= 0 && col < image[0].length)
        {
          //adds the RGB values to the sum
          redSum += image[row][col].getRed();
          greenSum += image[row][col].getGreen();
          blueSum += image[row][col].getBlue();

          //adds to the count of how many pixels are being averaged
          count++;
        }
      }
    }

    // calculating average my diving the RGB vals by the count
    Pixel average = new Pixel(redSum / count, greenSum / count, blueSum / count);
    return average;
  }

  /**
  * Method to crop the inputted image with the given inputs. This is done by starting at the starting point and looping through the inputted dimensions. If the pixel is out of the image, it is turned black
  * @param image The 2D array of pixels
  * @param startRow the row which the new image should start at
  * @param startColumn the column which the cropped image should start at
  * @param height Height of the cropped image
  * @param width Width of the cropped image
  * @return Pixel[][] which stores the cropped image
  */
  public static Pixel[][] crop(Pixel[][] image, int startRow, int startColumn, int height, int width)
  {
    //new pixel array created that is the dimensions which are inputted
    Pixel[][] croppedImage = new Pixel[height][width];

    //loops through original image starting at (startRow, startColumn) and loops to the dimensions inputted
    for (int x = startRow; x < height + startRow; x++)
    {
      for (int y = startColumn; y < width + startColumn; y++)
      {
        // if the pixel is within the range of the original image
        // then the pixel starting from inputted row and column is changed to that pixel from image
        if (x < image.length && x >= 0 && y < image[0].length && y >= 0)
        {
          croppedImage[x - startRow][y - startColumn] = image[x][y];
        }
        // if the pixel is not in bounds of the original image, the pixel is black
        else
        {
          croppedImage[x - startRow][y - startColumn] = new Pixel(0, 0, 0);
        }
      }
    }

    return croppedImage;
  }

  /**
  * Method to make a popArt of an imputted image in which there are grey, red, green, or blue versions of the image
  * @param image The 2D array of pixels
  * @return Pixel[][] array of pixels which contains the popArt version of the image
  */
  public static Pixel[][] popArt(Pixel[][] image)
  {
    // a new pixel array is created which has length and width which are doubled
    Pixel[][] popArtImage = new Pixel[image.length * 2][image[0].length * 2];

    // loops through the original image
    for (int x = 0; x < image.length; x++)
    {
      for (int y = 0; y < image[0].length; y++)
      {
        //GREY
        //makes the first quarter/top left of the popArtImage grey by taking the average of the pixel's R, G, and B values
        int averageRGB = (image[x][y].getRed() + image[x][y].getGreen() + image[x][y].getBlue()) / 3;
        // each of the RGB values are set to the average
        popArtImage[x][y] = new Pixel(averageRGB, averageRGB, averageRGB);

        //RED
        //the red face is in the top right of the new image so I add half the width of the original image to the y val
        //in the popArtImage, the green and blue values are set to 0 and the pixel has the same R value as that of the original image
        popArtImage[x][y + image[0].length] = new Pixel(image[x][y].getRed(), 0, 0);

        //GREEN
        //the green face is in the bottom left of the new image so I add half the length of the original image to the x val
        //in the popArtImage, the red and blue values are set to 0 and the pixel has the same G value as that of the original image
        popArtImage[x + image.length][y] = new Pixel(0, image[x][y].getGreen(), 0);

        //BLUE
        //the blue face is in the bottom right right of the new image so I add half the width of the original image to the y val
        //in the popArtImage, the green and blue values are set to 0 and the pixel has the same R value as that of the original image
        popArtImage[x + image.length][y + image[0].length] = new Pixel(0, 0, image[x][y].getBlue());
      }
    }

    return popArtImage;
  }

  /**
  * Method to discretize the colors of an image so there are only 64 color options by a sequence of if/else if statements
  * @param image The 2D array of pixels
  */
  public static void compress(Pixel[][] image)
  {
    //loops through all the pixels in image
    for (int x = 0; x <= image.length - 1; x++)
    {
      for (int y = 0; y <= image[x].length - 1; y++)
      {
        //calls discretizedNum which returns the new R, G, or B value
        int newRed = discretizedNum(image[x][y].getRed());
        int newGreen = discretizedNum(image[x][y].getGreen());
        int newBlue = discretizedNum(image[x][y].getBlue());

        //sets the pixel to have the new discretized values
        image[x][y].setRGB(newRed, newGreen, newBlue);
      }
    }
  }

  /**
  * Method to calculate the compressed num given an input. This is done by using a series of if statements which return a certain value depending on the input
  * @param num Int from (0 to 255) whose compressed number will be returned
  * @return int Compressed number of input
  */
  public static int discretizedNum(int num)
  {
    // series of if statements to return the nearest multiple of 64 that is lower than the input
    if ( num >= 0 && num < 64)
    {
      return 0;
    }
    else if ( num >= 64 && num < 128)
    {
      return 64;
    }
    else if ( num >= 128 && num < 192)
    {
      return 128;
    }
    else
    {
      return 192;
    }
  }


}
