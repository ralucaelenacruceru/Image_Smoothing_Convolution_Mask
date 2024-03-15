package cmd;

/**
 * Exception class thrown during file operations on images.
 */
public class BmpException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new BmpException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public BmpException(String message) {
        super(message);
    }

    /**
     * Constructs a new BmpException with the specified detail message and cause.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause   The cause (which is saved for later retrieval by the getCause() method).
     */
    public BmpException(String message, Throwable cause) {
        super(message, cause);
    }
}
