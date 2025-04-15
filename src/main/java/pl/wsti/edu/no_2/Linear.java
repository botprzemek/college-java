package pl.wsti.edu.no_2;

public class Linear extends Polynomial {
    protected Linear(double a, double b) {
        super(a, b);
    }

    @Override
    public double[] getRoots() {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' in a linear equation results in infinite roots");
        }

        double x1 = (-b / a);

        return new double[] { x1 };
    }

    @Override
    public double calculate(double x) {
        return a * x + b;
    }
}
