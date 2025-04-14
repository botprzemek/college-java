package pl.wsti.edu.no_1;

import javax.swing.JOptionPane;

public class Dialog {
    private String title = "NO_TITLE_PROVIDED";
    private String message = "NO_INPUT_PROVIDED";

    public Dialog(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    protected static String getString() {
        return enterMessage().toUpperCase();
    }

    protected static Integer getInteger() {
        return Integer.parseInt(enterMessage());
    }

    public Dialog setTitle(String title) {
        this.title = title;

        return this;
    }

    public Dialog setMessage(String message) {
        this.message = message;

        return this;
    }


    public Dialog setResult() {
        setMessage(getString());

        return this;
    }

    private static boolean isInputValid(String input) {
        return input != null && !input.isEmpty();
    }

    public static String enterMessage() {
        String result = JOptionPane.showInputDialog("Enter input: ");

        if (!isInputValid(result)) {
            throw new IllegalArgumentException("'" + result + "' is not a valid string");
        }

        return result;
    }

    public void show() {
        setResult();

        JOptionPane.showMessageDialog(
            null,
            getMessage(),
            getTitle(),
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
