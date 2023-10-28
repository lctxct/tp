package seedu.wildwatch.command;

public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    /**
     * Requires UPDATE
     */
    private static final String helpCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "1.  Get help - show the list of commands available for this app\n" +
                    "     Format: help\n" +
                    "     Examples: \n" +
                    "       help\n";
    private static final String addCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "2.  To add a new wildlife\n" +
                    "     Format: add D/DATE S/SPECIES N/NAME R/REMARKS\n" +
                    "       DATE should be in the format DD-MM-YY\n" +
                    "     Examples: \n" +
                    "       add D/02-03-23 S/Annam Leaf Turtle N/Ariel R/Injured left flipper\n";

    private static final String listCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "3.  To list all wildlife,\n" +
                    "     Format: list\n" +
                    "     Examples: \n" +
                    "       list\n";

    private static final String deleteCommandMessage =
            "\n" +
                    "_________________________________________________________________\n" +
                    "4.  To delete a wildlife\n" +
                    "     Format: delete INDEX\n" +
                    "       The index refers to the index number shown in the displayed observation list.\n" +
                    "       Note:\n" +
                    "           - The index must be a positive integer:\n" +
                    "           - Deleted items may not be recoverable:\n" +
                    "     Examples: \n" +
                    "       delete 1\n" +
                    "_________________________________________________________________\n";

    private static final String helpPage =
                    "\n" +
                    "---------------------------HELP PAGE-----------------------------\n"+
                    helpCommandMessage +
                    addCommandMessage +
                    listCommandMessage +
                    deleteCommandMessage +
                    "\n" +
                    "-------------------------HELP PAGE END---------------------------\n";

    private static final String needHelpPage =
            "\n" +
            "Please type \"help\" if you need help" +
            "\n";

    public static void printNeedHelpMessage() {
        System.out.println(needHelpPage);
    }

    /**
     * Prints out help page
     */
    public void execute() {
        System.out.println(helpPage);
    }


}
