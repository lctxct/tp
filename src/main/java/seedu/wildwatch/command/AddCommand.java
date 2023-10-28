package seedu.wildwatch.command;

import java.util.regex.Pattern;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for adding entry to EntryList
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final Pattern ADD_ENTRY_COMMAND_FORMAT =
            Pattern.compile("add"
                    + " D/(?<date>[^/]+)"
                    + " S/(?<species>[^/]+)"
                    + " N/(?<name>[^/]+)"
                    + "(?: R/(?<remark>[^/]+))?");

    private final Entry newEntry;
    private boolean isFromFile = false;

    public AddCommand(Entry entry) {
        newEntry = entry;
    }

    public void setIsFromFile() {
        isFromFile = true;
    }

    public void execute() throws IncorrectInputException {
        EntryList.addEntry(newEntry);

        if (!isFromFile) {
            Ui.entryAddedMessagePrinter();
            Ui.printEntry(EntryList.getArraySize() - 1);
            Ui.entryCountPrinter();
        }
    }
}

