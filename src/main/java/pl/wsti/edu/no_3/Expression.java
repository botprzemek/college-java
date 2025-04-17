package pl.wsti.edu.no_3;

class Expression {
    private final Node root;

    public Expression(String expression) {
        this.root = create(
                expression,
                0,
                expression.length() - 1
        );
    }

    private Node create(String expression, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Invalid starting index - must be less than ending index");
        }

        if (start == end) {
            if (start == expression.length()) {
                throw new IndexOutOfBoundsException("Invalid starting index");
            }

            return new Constant(Character.digit(
                    expression.charAt(start),
                    10)
            );
        }

        int index = start;
        int brackets = 0;
        boolean isWrapped = true;

        while (
                index <= end
                        && expression.charAt(start) == '('
                        && expression.charAt(end) == ')'
        ) {
            switch (expression.charAt(index++)) {
                case '(' -> brackets++;
                case ')' -> brackets--;
                default -> {
                    if (brackets != 0) {
                        break;
                    }

                    isWrapped = false;
                }
            }

            if (isWrapped) {
                return create(expression, start + 1, end - 1);
            }
        }

        brackets = 0;
        index = end;

        while (
                (index-- >= start
                        && brackets == 0)
        ) {
            switch (expression.charAt(index)) {
                case '(' -> brackets++;
                case ')' -> brackets--;
                case '+', '-', '*', '/' -> {
                    return new Equation(expression.charAt(index))
                            .setLeft(create(expression, start, index - 1))
                            .setRight(create(expression, index + 1, end));
                }
            }
        }

        throw new IndexOutOfBoundsException("Invalid expression");
    }

    public int calculate() {
        return root.value();
    }
}