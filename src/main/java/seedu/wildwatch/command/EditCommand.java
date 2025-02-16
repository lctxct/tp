package seedu.wildwatch.command;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.InvalidInputException;
import seedu.wildwatch.ui.EditCommandPrinter;
import seedu.wildwatch.ui.EntryPrinter;
import seedu.wildwatch.error.InvalidInputErrorType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";

    public static final Pattern EDIT_ENTRY_COMMAND_FORMAT =
            Pattern.compile("edit"
                    + " I/(?<index>[^/]+)"
                    + "( D/(?<date>[^/]+))?"
                    + "( S/(?<species>[^/]+))?"
                    + "( N/(?<name>[^/]+))?"
                    + "(?: R/(?<remark>[^/]*))?");
    private String input;

    public EditCommand(String input) {
        this.input = input;
    }

    public Entry checkAndUpdateEntry(Entry entry, String date, String species, String name, String remark) {
        if( date != null && !date.isEmpty() ) {
            date = date.trim();
            entry.setDate(date);
        }
        if( species != null && !species.isEmpty() ) {
            species = species.trim();
            entry.setSpecies(species);
        }
        if( name != null && !name.isEmpty() ) {
            name = name.trim();
            entry.setName(name);
        }
        if( remark != null && !remark.isEmpty() ) {
            remark = remark.trim();
            entry.setRemark(remark);
        }
        return entry;
    }

    public void execute() throws InvalidInputException {
        final Matcher matcher = EDIT_ENTRY_COMMAND_FORMAT.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidInputException(InvalidInputErrorType.INVALID_INPUT);
        }

        final String indexStr = matcher.group("index").trim();
        final String date = matcher.group("date");
        final String species = matcher.group("species");
        final String name = matcher.group("name");
        final String remark = matcher.group("remark");
        int index = Integer.parseInt(indexStr);
        if( index <= 0 || index > EntryList.getArraySize()) {
            throw new InvalidInputException(InvalidInputErrorType.ENTRY_NOT_FOUND);
        }
        index -= 1; // EntryList is 0 based.
        //System.out.println(indexStr + " " + date + " " + species + " " + name + " " + remark);
        Entry currentEntry = EntryList.getEntry(index);
        Entry updatedEntry = checkAndUpdateEntry(currentEntry, date, species, name, remark);
        EntryList.editEntry(index, updatedEntry);

        EditCommandPrinter.entryEditedMessagePrinter();
        EntryPrinter.printEntry(index);
    }
}
