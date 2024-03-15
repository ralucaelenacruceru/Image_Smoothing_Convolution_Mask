package cmd;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Class used for writing BMP images.
 */
public class BmpSet implements ImageSet {

    /**
     * Ensures that the given value is within the specified bounds.
     *
     * @param value The value to be checked.
     * @param endIndex The upper limit of the bound.
     * @return The initial value if included in the interval [0, endIndex - 1],
     *         0 if the value is lower than the interval, or endIndex -1 if the
     *         value is higher than the interval.
     */
    private int bound(int value, int endIndex) {
        if (value < 0) {
            return 0;
        }
        if (value < endIndex) {
            return value;
        }
        return endIndex - 1;
    }

    /**
     * Writes a BMP image file based on the provided ImageMatrix objects.
     *
     * @param filename The path to the BMP image file to be created.
     * @param redGreenBlue An array of ImageMatrix objects representing the red, green, and blue color channels.
     * @throws BmpException If an error occurs during the writing process.
     */
    public void writeOutputImage(String filename, ImageMatrix[] redGreenBlue) throws BmpException {
        ImageMatrix reds = redGreenBlue[0];
        ImageMatrix greens = redGreenBlue[1];
        ImageMatrix blues = redGreenBlue[2];
        BufferedImage outputImage = new BufferedImage(reds.width, reds.height, BufferedImage.TYPE_3BYTE_BGR);

        // Iterate through each pixel and set the RGB values in the output image
        for (int y = 0; y < reds.height; y++) {
            for (int x = 0; x < reds.width; x++) {
                int red = bound(reds.get(x, y), 256);
                int green = bound(greens.get(x, y), 256);
                int blue = bound(blues.get(x, y), 256);
                outputImage.setRGB(x, y, (red << 16) | (green << 8) | blue | -0x01000000);
            }
        }

        try {
            // Write the output image to the specified file
            ImageIO.write(outputImage, "BMP", new File(filename));
        } catch (Exception e) {
            // If an error occurs during the writing process, throw a BmpException
            throw new BmpException(e.getMessage());
        }
    }
}
