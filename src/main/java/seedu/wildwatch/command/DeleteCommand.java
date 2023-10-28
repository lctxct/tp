package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for deleting entry in EntryList
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    private final int deleteIdx;

    public DeleteCommand(int numberInput) {
        deleteIdx = numberInput;
    }

    /**
     * Deletes entry in the EntryList
     */
    public void execute() {
        Ui.entryRemovedMessagePrinter();
        EntryList.deleteEntry(deleteIdx);
        Ui.entryCountPrinter();
    }
}
