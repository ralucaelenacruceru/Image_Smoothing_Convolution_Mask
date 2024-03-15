package cmd;

import org.apache.commons.cli.HelpFormatter;

import java.util.Scanner;

/**
 * Class used for managing the Command Line
 */
public class Handler {

    /**
     * Handles command-line input, prompting the user to enter paths for input and output images.
     * @return Extracted parameters from the user input
     * @throws ExceptionLine When wrong parameters are provided
     */
    public Parameter handle() throws ExceptionLine {
        // Create an instance to store the command-line parameters
        Parameter commandLineParameters = new Parameter();

        // Set up the formatter for displaying help messages
        HelpFormatter formatter = new HelpFormatter();
        formatter.setWidth(90);
        formatter.setOptionComparator(null);

        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user to enter the path to the input image file
            System.out.print("Enter the path to the input image file: ");
            String inputPath = scanner.nextLine();
            commandLineParameters.setPathInput(inputPath);

            // Prompt the user to enter the path to the output image file
            System.out.print("Enter the path to the output image file: ");
            String outputPath = scanner.nextLine();
            commandLineParameters.setPathOutput(outputPath);

            // Additional validation logic can be added here if needed

        } catch (Exception e) {
            // Display an error message if input validation fails
            System.err.println("Input validation failed.  Reason: " + e.getMessage());
            throw new ExceptionLine("Input validation failed.  Reason: " + e.getMessage());
        } finally {
            // Close the scanner to avoid resource leaks
            scanner.close();
        }

        return commandLineParameters;
    }
}
