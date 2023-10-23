package seedu.wildwatch.operation.parser;

import seedu.wildwatch.command.Command;

public interface Parser<T extends Command> {

    /**
     * Parses user input into a {@code Command}.
     *
     * @param input Input from user
     * @return Command
     */
    T parse(String input);
}
