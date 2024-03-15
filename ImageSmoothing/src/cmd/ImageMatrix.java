package cmd;

/**
 * 
 * Class that represents an image as a linearized matrix
 */
public class ImageMatrix {

    public final int[] dataArray;
    public final int width;
    public final int height;

    /**
     * Constructs an ImageMatrix with the given dataArray, width, and height.
     * 
     * @param dataArray
     *        The linearized matrix representing the image.
     * @param width
     *        The width of the image.
     * @param height
     *        The height of the image.
     */
    public ImageMatrix(int[] dataArray, int width, int height) {
        this.dataArray = dataArray;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs an ImageMatrix with a new dataArray of size width * height, with the given width and height.
     * 
     * @param width
     *        The width of the image.
     * @param height
     *        The height of the image.
     */
    public ImageMatrix(int width, int height) {
        this(new int[width * height], width, height);
    }

    /**
     * Gets the value at the specified position (x, y) in the image matrix.
     * 
     * @param x
     *        The x-coordinate.
     * @param y
     *        The y-coordinate.
     * @return The value at position (x, y).
     */
    public int get(int x, int y) {  
        return dataArray[y * width + x];
    }

    /**
     * Sets the value at the specified position (x, y) in the image matrix.
     * 
     * @param x
     *        The x-coordinate.
     * @param y
     *        The y-coordinate.
     * @param value
     *        The new value to set.
     */
    public void set(int x, int y, int value) {  
        dataArray[y * width + x] = value;  
    }
}
