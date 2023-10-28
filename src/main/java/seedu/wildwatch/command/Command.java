package seedu.wildwatch.command;

import seedu.wildwatch.exception.IncorrectInputException;

/**
 * Command class for manipulating EntryList
 */
public abstract class Command {

    public Command() {}

    public void setIsFromFile() {
    }

    public abstract void execute() throws IncorrectInputException;
}
