package seedu.duke.logic.commands.favcommand;

import seedu.duke.exceptions.CustomException;
import seedu.duke.exceptions.ExceptionType;
import seedu.duke.model.favorite.FavList;
import seedu.duke.logic.commands.commons.Command;
import seedu.duke.ui.Ui;

/**
 * Represents the command to delete a user-specified favourite command from the favourite list.
 */
public class DeleteFavCommand extends Command {
    public int index;

    public DeleteFavCommand(String index) throws CustomException {
        if (index.isBlank()) {
            throw new CustomException(ExceptionType.NO_INDEX);
        }
        int indexNum = 0;
        try {
            indexNum = Integer.parseInt(index.trim());
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionType.NOT_A_NUMBER);
        }
        this.index = indexNum;
        super.isValid = false;
    }

    @Override
    public void executeCommand() throws CustomException {
        int sizeOfArray = FavList.getSize();
        if (index <= 0 || index > sizeOfArray) {
            throw new CustomException(ExceptionType.INVALID_INDEX);
        } else {
            Ui.printDeleteFavMessage(index);
            FavList.deleteFav(index);
        }
    }
}
