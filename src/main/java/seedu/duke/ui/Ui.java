package seedu.duke.ui;

import java.util.Scanner;

public class Ui {

    public static String getCommand() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public static void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("How can I help?");
    }

    public static void showError(Exception error) {
        System.out.println(error);
    }

    public static void printExitMessage() {
        System.out.println("So long buddy!");
    }
}
