package seedu.wildwatch.exception;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(String message) {
        super(message);
    }

    public IncorrectInputException() {
        this("");
    }
}
