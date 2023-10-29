package seedu.wildwatch.operation;

import java.util.regex.Pattern;
public class DateHandler {
    private static final Pattern DATE_PATTERN = Pattern.compile(
            "(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-\\d{2}"   // dd-mm-yy
    );

    public static boolean isDateValid(String date) {
        if (DATE_PATTERN.matcher(date).matches()) {
            return true;
        }

        return false;
    }
}
