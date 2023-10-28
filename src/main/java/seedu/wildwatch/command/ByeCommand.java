package seedu.wildwatch.command;

import seedu.wildwatch.operation.EntryHandler;
import seedu.wildwatch.operation.ShutDown;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    private static final Logger LOGGER = Logger.getLogger(EntryHandler.class.getName());

    public void execute() {
        LOGGER.log(Level.INFO, "Initiating shutdown procedures.");
        ShutDown.shutDown();
    }
}
