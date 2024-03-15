package cmd;

/**
 * 
 * Class used for applying the convolution mask for smoothing a bmp image
 */
public class Convolution extends AbstractConvolution{

	private ImageMatrix kernel;
    // The divisor used for normalization after convolution
    private float kernelDivisor;

    /**
     * Get the convolution kernel.
     *
     * @return The convolution kernel.
     */
    public ImageMatrix getKernel() {
        return kernel;
    }

    /**
     * Set the convolution kernel.
     *
     * @param kernel The convolution kernel to set.
     */
    public void setKernel(ImageMatrix kernel) {
        this.kernel = kernel;
    }

    /**
     * Get the kernel divisor.
     *
     * @return The kernel divisor.
     */
    public float getKernelDivisor() {
        return kernelDivisor;
    }

    /**
     * Set the kernel divisor as an integer.
     *
     * @param kernelDivisor The integer value to set as the kernel divisor.
     */
    public void setKernelDivisor(int kernelDivisor) {
        this.kernelDivisor = kernelDivisor;
    }

    /**
     * Set the kernel divisor as a float.
     *
     * @param kernelDivisor The float value to set as the kernel divisor.
     */
    public void setKernelDivisor(float kernelDivisor) {
        this.kernelDivisor = kernelDivisor;
    }

    /**
     * Apply convolution to an array of ImageMatrix.
     *
     * @param inputData Array of ImageMatrix representing the input color components.
     * @return Array of ImageMatrix representing the convoluted color components.
     */
    public ImageMatrix[] convolute(ImageMatrix[] inputData) {
        ImageMatrix[] convolutedArrayData = new ImageMatrix[inputData.length];
        for (int i = 0; i < inputData.length; i++) {
            convolutedArrayData[i] = convolute(inputData[i]);
        }
        return convolutedArrayData;
    }

    /**
     * Apply convolution to a single ImageMatrix.
     *
     * @param inputData Input ImageMatrix representing a single color component.
     * @return Convoluted color component as ImageMatrix.
     */
    private ImageMatrix convolute(ImageMatrix inputData) {
        int inputWidth = inputData.width;
        int inputHeight = inputData.height;
        int kernelWidth = getKernel().width;
        int kernelHeight = getKernel().height;

        // Check if the kernel dimensions are odd
        if ((kernelWidth <= 0) || ((kernelWidth & 1) != 1)) {
            throw new IllegalArgumentException("Kernel must have odd width");
        }
        if ((kernelHeight <= 0) || ((kernelHeight & 1) != 1)) {
            throw new IllegalArgumentException("Kernel must have odd height");
        }

        int kernelWidthRadius = kernelWidth >>> 1;
        int kernelHeightRadius = kernelHeight >>> 1;

        ImageMatrix outputData = new ImageMatrix(inputWidth, inputHeight);

        // Iterate over the input matrix
        for (int i = inputWidth - 1; i >= 0; i--) {
            for (int j = inputHeight - 1; j >= 0; j--) {
                double newValue = 0.0;

                // Apply convolution with the kernel
                for (int kw = kernelWidth - 1; kw >= 0; kw--)
                    for (int kh = kernelHeight - 1; kh >= 0; kh--)
                        newValue += getKernel().get(kw, kh) * inputData.get(
                                bound(i + kw - kernelWidthRadius, inputWidth),
                                bound(j + kh - kernelHeightRadius, inputHeight));

                // Set the convoluted value in the output matrix
                outputData.set(i, j, (int) Math.round(newValue / getKernelDivisor()));
            }
        }

        return outputData;
    }
}
