package seedu.wildwatch.command;

import seedu.wildwatch.operation.EntryHandler;
import seedu.wildwatch.operation.ShutDown;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ByeCommand {
    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public static void exitProgram() {
        LOGGER.log(Level.INFO, "Initiating shutdown procedures.");
        ShutDown.shutDown();
    }
}