package seedu.wildwatch.operation.parser;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.command.AddCommand;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.exception.UnknownDateFormatException;
import seedu.wildwatch.operation.DateHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddCommandParser implements Parser<AddCommand> {

    private static final String[] COMPULSORY_PREFIXES = {"D/", "S/", "N/"};

    private static final String[] PREFIXES = {"D/", "S/", "N/", "R/"};

    public AddCommand parse(String input) throws IncorrectInputException, UnknownDateFormatException {
        ArrayList<String> keys = extractKeys(input);

        // Check that input contains D/, S/ and N/
        for (String prefix : COMPULSORY_PREFIXES) {
            if (!keys.contains(prefix)) {
                throw new IncorrectInputException("Missing prefix! Check that D/, S/ and N/ are defined.");
            }
        }

        // Check that each prefix is only defined once
        for (String prefix : PREFIXES) {
            if (Collections.frequency(keys, prefix) > 1) {
                throw new IncorrectInputException("Each prefix can only be defined once.");
            }
        }

        // Check that there are no illegal prefixes
        boolean illegal = true;
        for (String foundKey : keys) {
            illegal = true;
            for (String prefix : PREFIXES) {
                if (foundKey.equals(prefix)) {
                    illegal = false;
                }
            }

            if (illegal) {
                throw new IncorrectInputException("Unrecognized prefix.");
            }
        }

        final Matcher matcher = AddCommand.ADD_ENTRY_COMMAND_FORMAT.matcher(input);

        if (!matcher.matches()) {
            throw new IncorrectInputException();
        }

        final String date = matcher.group("date").trim();
        final String species = matcher.group("species").trim();
        final String name = matcher.group("name").trim();
        final String remark = matcher.group("remark");

        // Check date format
        if (!DateHandler.isDateValid(date)) {
            throw new UnknownDateFormatException();
        }

        Entry newEntry = new Entry(date, species, name, remark);

        return new AddCommand(newEntry);
    };

    private static ArrayList<String> extractKeys(String input) {
        ArrayList<String> keys = new ArrayList<>();

        String regex = "(\\b\\w+/)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String key = matcher.group();
            keys.add(key);
        }

        return keys;
    }

}
