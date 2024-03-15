package cmd;

/**
 * Class that encapsulates all of the needed parameters
 */
public class Parameter {

    // Path to the input image
    private String pathOfInputImage;

    // Path to the output image
    private String pathOfOutputImage;

    /**
     * Get the path to the input image.
     * 
     * @return Path to the input image
     */
    public String getPathInput() {
        return pathOfInputImage;
    }

    /**
     * Set the path to the input image.
     * 
     * @param pathOfInputImage Path to the input image
     */
    public void setPathInput(String pathOfInputImage) {
        this.pathOfInputImage = pathOfInputImage;
    }

    /**
     * Get the path to the output image.
     * 
     * @return Path to the output image
     */
    public String getPathOutput() {
        return pathOfOutputImage;
    }

    /**
     * Set the path to the output image.
     * 
     * @param pathOfOutputImage Path to the output image
     */
    public void setPathOutput(String pathOfOutputImage) {
        this.pathOfOutputImage = pathOfOutputImage;
    }
}
