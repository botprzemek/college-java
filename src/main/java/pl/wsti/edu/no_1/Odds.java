package pl.wsti.edu.no_1;

public class Odds extends Dialog {
    public Odds(String title) {
        super(title);
    }

    public Odds setResult() {
        setMessage(Integer.toString(calculate(getInteger())));

        return this;
    }

    private static int calculate(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number argument must be a positive integer");
        }

        int value = 0;

        if (number % 2 == 0) {
            number -= 1;
        }

        while (number >= 1) {
            value += number;
            number -= 2;
        }

        return value;
    }
}
