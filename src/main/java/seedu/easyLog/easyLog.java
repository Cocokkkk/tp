package seedu.easyLog;

import java.util.Scanner;
import seedu.easyLog.ui.Ui;


public class easyLog {

    private static Ui ui = new Ui();

    /**
     * Main entry-point for the easyLog application.
     */
    public static void main(String[] args) {
        ui.showGreeting();

        ui.showGoodbye();
    }

}
