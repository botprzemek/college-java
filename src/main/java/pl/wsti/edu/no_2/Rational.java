package pl.wsti.edu.no_2;

import java.util.Arrays;

public class Rational implements Comparable<Rational> {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must be a non-zero integer");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational(String rational) {
        int[] split = Arrays
                .stream(rational.split("/"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (split[1] == 0) {
            throw new IllegalArgumentException("Denominator must be a non-zero integer");
        }

        if (split[1] < 0) {
            split[0] = -split[0];
            split[1] = -split[1];
        }

        this.numerator = split[0];
        this.denominator = split[1];
    }

    public Rational add(Rational arg) {
        return new Rational(
                (this.numerator * arg.denominator) + (arg.numerator * this.denominator),
                (this.denominator * arg.denominator)
        );
    }

    public Rational subtract(Rational arg) {
        arg.numerator = -this.numerator;

        return add(arg);
    }

    public Rational multiply(Rational arg) {
        return new Rational(
            this.numerator * arg.numerator,
            this.denominator * arg.denominator
        );
    }

    public Rational divide(Rational arg) {
        if (arg.denominator == 0) {
            throw new ArithmeticException("Numerator cannot be a zero number");
        }

        int denominator = arg.denominator;
        arg.denominator = arg.numerator;
        arg.numerator = denominator;

        return multiply(arg);
    }

    public boolean equals(Rational arg) {
        return this.numerator * arg.denominator == arg.numerator * this.denominator;
    }

    @Override
    public int compareTo(Rational arg) {
        int left = this.numerator * arg.denominator;
        int right = arg.numerator * this.denominator;

        return Integer.compare(left, right);
    }

    public String getString() {
        return this.numerator + "/" + this.denominator;
    }
}
