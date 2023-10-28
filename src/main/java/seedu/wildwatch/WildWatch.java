package seedu.wildwatch;

import seedu.wildwatch.operation.EntryHandler;
import seedu.wildwatch.operation.LogHandler;
import seedu.wildwatch.operation.BootUp;
import seedu.wildwatch.operation.FileHandler;


public class WildWatch {
    /**
     * Main entry-point for the java.wildwatch.WildWatch application.
     */
    public static void main(String[] args) {
        LogHandler.configure(); //Configure Log
        BootUp.bootUpOne();
        FileHandler.handleFile(); //FileHandler takes on
        EntryHandler.handleManualInput();
    }
}
