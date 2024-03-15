package cmd;

/**
 * 
 * Interface used by all types of image readers
 */
public interface ImageGet {

    /**
     * Reads an image file and returns an array of ImageMatrix for each color component.
     * 
     * @param filename
     *        Path to the image file.
     * @return An array of ImageMatrix representing each color component of the image.
     * @throws BmpException 
     *         When there is an issue reading the input image.
     */
    public ImageMatrix[] getArrayDatasFromImage(String filename)
            throws BmpException;

}
