package main;

import cmd.*;

import java.io.IOException;


public class ImageProcessingMain {

    public static void main(String[] args) throws IOException {
        // Create an instance of the command line handler
        Handler commandLineHandler = new Handler();
        // Store the command line parameters
        Parameter commandLineParameter;

        try {
            // Use the modified handle method that prompts for user input
            commandLineParameter = commandLineHandler.handle();
        } catch (ExceptionLine e) {
            System.err.println(e.getMessage());
            return;
        }

        // Start timer to measure execution time
        Tmr.startTimer();

        // Create an image reader instance for BMP format
        ImageGet bmpReader = new BmpGet();
        // Array to store image data
        ImageMatrix[] arrayData;

        try {
            // Read image data from the specified input path
            arrayData = bmpReader.getArrayDatasFromImage(commandLineParameter.getPathInput());
        } catch (BmpException e) {
            // Handle exception if there's an error reading input image
            System.err.println("Error reading input image: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        System.out.println("Read input image in " + Tmr.stopAndGetTime() / 1000.0);

        // Start timer for convolution operation
        Tmr.startTimer();
        // Create an instance of the Gaussian smoothing convolution
        Convolution imageConvolution = new Smoothing();
        // Array to store convoluted image data
        ImageMatrix[] convolutedArrayData = imageConvolution.convolute(arrayData);
        System.out.println("Processed image in " + Tmr.stopAndGetTime() / 1000.0);

        // Start timer for writing the output image
        Tmr.startTimer();
        // Create an image writer instance for BMP format
        ImageSet bmpWriter = new BmpSet();
        try {
            // Write the convoluted image data to the specified output path
            bmpWriter.writeOutputImage(commandLineParameter.getPathOutput(), convolutedArrayData);
        } catch (BmpException e) {
            // Handle exception if there's an error writing the output image
            System.err.println("Error writing output image: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Wrote output image in " + Tmr.stopAndGetTime() / 1000.0);
    }
}
