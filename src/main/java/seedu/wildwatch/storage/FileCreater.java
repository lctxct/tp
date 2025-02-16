//@@woodenclock
package seedu.wildwatch.storage;

import java.io.File;
import java.io.IOException;

import seedu.wildwatch.ui.FilePrinter;

public class FileCreater {
    /**
     * Creates new file with filename specified by {@code FILE_PATH}.
     */
    public static File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.createNewFile()) {
            FilePrinter.createNewFileMessagePrinter();
            return file;
        } else {
            throw new IOException();
        }
    }
}
