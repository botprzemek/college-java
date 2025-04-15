package pl.wsti.edu.no_1;

import java.math.BigInteger;

public class Factorial extends Dialog {
    public Factorial(String title) {
        super(title);
    }

    public Factorial setResult() {
        setMessage(calculate(getInteger()).toString());

        return this;
    }

    private static BigInteger calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number argument must be a positive integer");
        }

        BigInteger result = BigInteger.ONE;

        while (number >= 1) {
            result = result.multiply(BigInteger.valueOf(number--));
        }

        return result;
    }
}

