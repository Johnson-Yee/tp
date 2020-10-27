package seedu.duke.model.favorite;

import seedu.duke.exceptions.CustomException;
import seedu.duke.exceptions.ExceptionType;

import java.util.ArrayList;

import static seedu.duke.ui.Ui.printClearFavMessage;
import static seedu.duke.ui.Ui.printFavList;

public class FavList {
    private static ArrayList<Fav> favList;

    public FavList() {
        favList = new ArrayList<>();
    }

    public static void addFav(Fav fav) {
        favList.add(fav);
    }

    public static void deleteFav(int index) {
        favList.remove(index - 1);
    }

    public static void listFav() throws CustomException {
        if (favList.size() == 0) {
            throw new CustomException(ExceptionType.EMPTY_FAVLIST);
        }
        printFavList(favList);
    }

    public static void clearFav() {
        favList.clear();
        printClearFavMessage();
    }

    public static String changeDesc(int index, String newDesc) throws CustomException {
        String oldDesc = checkIndexAndDesc(index, newDesc);
        favList.get(index - 1).changeDesc(newDesc);
        return oldDesc;
    }

    private static String checkIndexAndDesc(int index, String newDesc) throws CustomException {
        if (index == 0 || index > favList.size()) {
            throw new CustomException(ExceptionType.INVALID_INDEX);
        }
        assert index > 0 && index <= FavList.getList().size() : "Index out of bounds.";
        String oldDesc = favList.get(index - 1).getDesc();
        if (oldDesc.equals(newDesc)) {
            throw new CustomException(ExceptionType.SAME_DESCRIPTION);
        }
        assert !oldDesc.equals(newDesc) : "description is the same as before.";
        return oldDesc;
    }

    public static ArrayList<Fav> getList() {
        return favList;
    }

    public static int getSize() {
        return favList.size();
    }

    public static boolean contains(Fav item) {
        int count = 0;
        for (Fav fav : favList) {
            count++;
            if (fav.equals(item, count)) {
                return true;
            }
        }
        return false;
    }

}