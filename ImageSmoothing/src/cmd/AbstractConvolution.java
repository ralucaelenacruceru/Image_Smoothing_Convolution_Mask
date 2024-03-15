package cmd;
/**
 * Abstract base class for image convolution operations.
 */
public abstract class AbstractConvolution {

    /**
     * Applies convolution to the input image data and produces convoluted image data.
     *
     * @param inputData Input image represented as an array of ImageMatrix objects, each containing RGB colors.
     * @return Convoluted image data as an array of ImageMatrix objects.
     */
    public abstract ImageMatrix[] convolute(ImageMatrix[] inputData);

    /**
     * Ensures that the given value is within a valid range [0, endIndex - 1].
     * If the value is outside this range, it is adjusted to the nearest boundary.
     *
     * @param value    The value to be checked and adjusted if necessary.
     * @param endIndex The upper limit of the valid range.
     * @return Adjusted value within the valid range.
     */
    protected int bound(int value, int endIndex) {
        // Ensure value is not negative
        if (value < 0) {
            return 0;
        }
        // Adjust value to the nearest boundary if it exceeds endIndex
        if (value < endIndex) {
            return value;
        }
        return endIndex - 1;
    }
}
