package cmd;

import java.util.Date;

/**
 * Util Timer class used for determining the elapsed time between triggered start and stop
 */
public class Tmr {

    // Variable to store the start time
    private static long startTimeInMillis;

    /**
     * Start the timer by recording the current time.
     */
    public static void startTimer() {
        startTimeInMillis = (new Date()).getTime();
    }

    /**
     * Stop the timer and return the elapsed time in milliseconds.
     * 
     * @return Elapsed time in milliseconds
     */
    public static long stopAndGetTime() {
        return (new Date()).getTime() - startTimeInMillis;
    }
}
