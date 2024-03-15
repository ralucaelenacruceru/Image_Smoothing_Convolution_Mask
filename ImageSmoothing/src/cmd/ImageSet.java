package cmd;

/**
 * 
 * Interface used by all types of image writers
 */
public interface ImageSet {

    /**
     * Writes the output image to the specified file.
     * 
     * @param filename
     *        The path to the output image file.
     * @param redGreenBlue
     *        An array of ImageMatrix, each representing a color component.
     * @throws BmpImageIOException
     *         When an error occurs during writing the output image file.
     */
    public void writeOutputImage(String filename,
            ImageMatrix[] redGreenBlue) throws BmpException;

}
