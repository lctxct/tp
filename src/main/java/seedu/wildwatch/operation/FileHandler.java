package seedu.wildwatch.operation;

import seedu.wildwatch.entry.Entry;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static final String FILE_PATH = "./WildWatch.txt";
    private static final DateTimeFormatter STD_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yy");
    private static File openedFile; //File to save the entries

    public static void handleFile() {
        boolean hasFile = checkFileExistence();
        loadFile();
        if (hasFile) {
            Ui.taskLoadedMessagePrinter();
            EntryHandler.handleFileInput("list");
        }
        BootUp.bootUpTwo();
    }

    public static boolean checkFileExistence() {
        System.out.print(System.lineSeparator());
        Ui.checkingIfFileExistsMessagePrinter();
        File file = new File(FILE_PATH);

        if (!file.exists()) {   //File doesn't exist, so create it
            try {
                if (file.createNewFile()) { //Returns true if successfully created
                    openedFile = file;      //File used to save tasks
                    Ui.noFileMessagePrinter();
                } else {
                    Ui.fileCreationFailMessagePrinter();
                }
            } catch (IOException exception) {
                Ui.errorMessagePrinter(exception);
            }
            return false;
        } else {
            Ui.fileExistMessagePrinter();
            openedFile = file;      //File used to save tasks
            return true;
        }
    }

    /**
     * Loads tasks from file into the TaskList
     */
    public static void loadFile() {
        try {
            Scanner fileReader = new Scanner(openedFile); // create a Scanner using the File as the source
            while (fileReader.hasNext()) {
                String lineOfFile = fileReader.nextLine();
                EntryHandler.handleFileInput(lineOfFile); // Parse each line into the entry ArrayList
            }
        } catch (FileNotFoundException exception) {
            Ui.fileNotFoundMessagePrinter();
        }
    }

    /**
     * Manages the storage of tasks in a file.
     * Write each task in the desired format to the file
     */
    public static void saver(ArrayList<Entry> entries) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            for (Entry entry : entries) {
                writer.write(toFileString(entry) + "\n");
            }
            writer.close();
        } catch (IOException exception) {
            Ui.errorMessagePrinter(exception);
        }
    }

    /**
     * Returns String that is in the format to be written to file
     *
     * @param entry
     * @return String
     * @throws IOException when there is problem with formatting the task
     */
    public static String toFileString(Entry entry) throws IOException {
        String date = entry.getDate().format(STD_FORMAT);
        String species = entry.getSpecies();
        String name = entry.getName();
        String remark = entry.getRemark();
        return String.format("add D/%s S/%s N/%s R/%s", date, species, name, remark);
    }
}
