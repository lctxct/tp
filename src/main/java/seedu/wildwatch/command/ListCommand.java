package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for listing all entries in EntryList
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    private boolean isFromFile = false;

    @Override
    public void setIsFromFile() {
        isFromFile = true;
    }

    /**
     * Lists out all entry in EntryList
     */
    public void execute() {
        if (!isFromFile) {
            Ui.listMessagePrinter();
        }
        int arraySize = EntryList.getArraySize();
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + 1 + ".");
            Ui.printEntry(i);
        }
        Ui.entryCountPrinter();
    }
}

