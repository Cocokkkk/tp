package seedu.easyLog.ui;

public class Ui {

    public void showGreeting() {
        String greeting = "Hello! I'm easyLog!\n" + "What can I do for you? Enter help to view commands.";
        System.out.println(greeting);
    }

    public void showGoodbye() {
        String goodbye = "Bye. Thanks for using easyLog!";
        System.out.println(goodbye);
    }
}
