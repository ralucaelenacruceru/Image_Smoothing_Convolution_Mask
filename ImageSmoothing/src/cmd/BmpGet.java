package cmd;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Class used for reading BMP images.
 */
public class BmpGet implements ImageGet {

    /**
     * Reads a BMP image file and returns an array of ImageMatrix objects representing its color channels.
     *
     * @param filename The path to the BMP image file.
     * @return An array of ImageMatrix objects representing the red, green, and blue color channels.
     * @throws BmpException If an error occurs during the reading process.
     */
    public ImageMatrix[] getArrayDatasFromImage(String filename) throws BmpException {
        try {
            // Create a File object for the specified filename
            File file = new File(filename);

            // Check if the file exists and is a valid file
            if (!file.exists() || !file.isFile()) {
                throw new BmpException("The specified file does not exist or is not a valid file: " + filename);
            }

            // Read the BMP image into a BufferedImage
            BufferedImage inputImage = ImageIO.read(file);
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();

            // Get the RGB data from the image
            int[] rgbData = inputImage.getRGB(0, 0, width, height, null, 0, width);

            // Separate the RGB data into reds, greens, and blues ImageMatrix objects
            ImageMatrix reds = new ImageMatrix(width, height);
            ImageMatrix greens = new ImageMatrix(width, height);
            ImageMatrix blues = new ImageMatrix(width, height);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgbValue = rgbData[y * width + x];
                    reds.set(x, y, (rgbValue >>> 16) & 0xFF);
                    greens.set(x, y, (rgbValue >>> 8) & 0xFF);
                    blues.set(x, y, rgbValue & 0xFF);
                }
            }

            // Return the array of ImageMatrix objects
            return new ImageMatrix[] {reds, greens, blues};
        } catch (Exception e) {
            // If an error occurs during the reading process, throw a BmpException
            throw new BmpException("Error reading input file: " + e.getMessage());
        }
    }
}
