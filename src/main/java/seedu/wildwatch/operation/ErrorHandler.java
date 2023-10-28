package seedu.wildwatch.operation;

import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;

import seedu.wildwatch.command.HelpCommand;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.EmptyAddException;
import seedu.wildwatch.exception.EmptyDeleteException;
import seedu.wildwatch.exception.EmptyListException;
import seedu.wildwatch.exception.EmptyInputException;
import seedu.wildwatch.exception.EntryNotFoundException;
import seedu.wildwatch.exception.UnknownInputException;
import seedu.wildwatch.exception.UnknownDateFormatException;
import seedu.wildwatch.exception.IncorrectInputException;

public class ErrorHandler {
    private static final int DEFAULT_NUMBER_INPUT = -3710; //Number never input during normal use of WildWatch
    private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class.getName());
    
    public static void handleError(String inputBuffer) {
        boolean validInput = false;
        try {
            checkError(inputBuffer);
            EntryHandler.handleEntry(inputBuffer, false);
            validInput = true;
        } catch (EmptyInputException exception) {
            LOGGER.warning("Received an empty input.");
            Ui.emptyDescriptionMessagePrinter(null);
        } catch (EmptyAddException exception){
            LOGGER.warning("Received an empty add input.");
            Ui.emptyDescriptionMessagePrinter("add");
        } catch (EmptyDeleteException exception) {
            LOGGER.warning("Received an empty delete input.");
            Ui.emptyDescriptionMessagePrinter("delete");
        } catch (EmptyListException exception) {
            LOGGER.info("List is empty.");
            Ui.emptyListMessagePrinter();
            validInput = true;
        } catch (EntryNotFoundException exception) {
            LOGGER.warning("Queried entry not found.");
            Ui.entryNotFoundMessagePrinter();
            validInput = true;
        } catch (UnknownInputException exception) {
            LOGGER.warning("Unknown input received.");
            Ui.unknownInputMessagePrinter();
        } catch (UnknownDateFormatException | DateTimeParseException exception) {
            LOGGER.warning("Date is invalid.");
            Ui.invalidDateMessagePrinter();
        } catch (IncorrectInputException exception) {
            LOGGER.warning("Command is invalid.");
            Ui.incorrectInputMessagePrinter();
        } finally {
            if (!validInput) {
                Ui.printHorizontalLines();
                HelpCommand.printNeedHelpMessage();
            }
        }
    }

    public static void checkError(String inputBuffer) throws EmptyInputException, EmptyAddException,
            EmptyListException, EmptyDeleteException, EntryNotFoundException {

        assert inputBuffer != null : "Input buffer should not be null.";

        Scanner bufferScanner = new Scanner(inputBuffer);   //Scanner for the buffer
        String firstWord;                                   //First word of input

        int numberInput = DEFAULT_NUMBER_INPUT;
        if (!bufferScanner.hasNext()) {                     //Checks for the case when there is no input
            throw new EmptyInputException();
        } else {
            firstWord = bufferScanner.next();
        }
        if (bufferScanner.hasNextInt()) {
            numberInput = bufferScanner.nextInt();
        }

        if (firstWord.equals("delete") && numberInput == DEFAULT_NUMBER_INPUT) {
            throw new EmptyDeleteException();
        } else if (firstWord.equals("delete") && (numberInput < 1 || numberInput > EntryList.getArraySize())) {
            throw new EntryNotFoundException();
        } else if (firstWord.equals("list") && EntryList.isArrayEmpty()) {
            throw new EmptyListException();
        }
    }
}
