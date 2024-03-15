package cmd;

/**
 * Class used for applying the Gaussian smoothing convolution mask on a bmp image
 */
public class Smoothing extends Convolution {

    /**
     * Smoothing Kernel matrix
     */
    private final ImageMatrix KERNEL = new ImageMatrix(new int[]
            {1, 4, 7, 4, 1,
             4, 16, 26, 16, 4,
             7, 26, 41, 26, 7,
             4, 16, 26, 16, 4,
             1, 4, 7, 4, 1},
             5, 5);

    /**
     * Smoothing Kernel Divisor
     */
    private final int KERNEL_DIVISOR = 273;

    /**
     * Get the smoothing kernel.
     * 
     * @return Smoothing kernel matrix
     */
    public ImageMatrix getKernel() {
        return KERNEL;
    }

    /**
     * Set the smoothing kernel (Unsupported operation for Gaussian smoothing convolution).
     * 
     * @param kernel Smoothing kernel matrix
     * @throws UnsupportedOperationException Always thrown since the kernel cannot be set for Gaussian smoothing convolution
     */
    public void setKernel(ImageMatrix kernel) {
        throw new UnsupportedOperationException("Kernel cannot be set for GaussianSmoothingConvolution");
    }

    /**
     * Get the smoothing kernel divisor.
     * 
     * @return Smoothing kernel divisor
     */
    public float getKernelDivisor() {
        return KERNEL_DIVISOR;
    }

    /**
     * Set the smoothing kernel divisor (Unsupported operation for Gaussian smoothing convolution).
     * 
     * @param kernelDivisor Smoothing kernel divisor
     * @throws UnsupportedOperationException Always thrown since the kernel divisor cannot be set for Gaussian smoothing convolution
     */
    public void setKernelDivisor(int kernelDivisor) {
        throw new UnsupportedOperationException("Kernel Divisor cannot be set for GaussianSmoothingConvolution");
    }
}
