package seedu.duke.logic.parser;

import seedu.duke.exceptions.CustomException;
import seedu.duke.exceptions.ExceptionType;
import seedu.duke.logic.commands.*;
import seedu.duke.ui.Ui;


public class Parser {

    private String userInput;
    private Command com;

    public Parser(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Split sentence to derive command and rest of the user input.
     *
     * @return String Array with two element: Command and the rest of the user input
     */
    String[] splitCommands(int length, String delimiter) {
        final String[] split = userInput.trim().split(delimiter, length);
        return split.length == length ? split : new String[]{split[0], " "};
    }

    public boolean extractType() throws CustomException {


        String[] parts = splitCommands(2, "\\s+");
        String command = parts[0];


        switch (command) {
        case "/route":
            com = new RouteCommand(parts[1]);
            break;
        case "/routemap":
            com = new RouteMapCommand();
            break;
        case "/bus":
            com = new BusCommand(parts[1]);
            break;
        case "/allbus":
            com = new AllBusCommand();
            break;
        //        case "/liststops":
        //
        //            break;
        case "/help":
            Ui.printHelp();
            break;
        case "/exit":
            com = new ExitCommand();
            break;
        default:
            throw new CustomException(ExceptionType.INVALID_COMMAND);
        }
        com.executeCommand();
        return com.isOngoing();

    }

    public String getUserInput() {
        return userInput;
    }
}
