package seedu.wildwatch.command;

import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for listing all entries in EntryList
 */
public class ListCommand extends Command {
    /**
     * Lists out all entry in EntryList
     *
     * @param isFromFile
     */
    public static void listEntry(boolean isFromFile) {
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

