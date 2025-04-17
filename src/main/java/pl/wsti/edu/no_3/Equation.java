package pl.wsti.edu.no_3;

class Equation extends Node {
    private final char operator;

    public Equation(char operator) {
        this.operator = operator;
    }

    public Equation setLeft(Node node) {
        this.left = node;

        return this;
    }

    public Equation setRight(Node node) {
        this.right = node;

        return this;
    }

    public int value() {
        return switch (operator) {
            case '+' -> left.value() + right.value();
            case '-' -> left.value() - right.value();
            case '*' -> left.value() * right.value();
            case '/' -> {
                if (right.value() == 0) {
                    throw new ArithmeticException("Denominator cannot be a zero number");
                }

                yield left.value() / right.value();
            }
            default -> throw new IllegalArgumentException("Invalid operator - must be '+', '-', '/' or '*'");
        };
    }
}
