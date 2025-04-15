package pl.wsti.edu.no_2;

public class Quadratic extends Polynomial {
    protected double c;

    protected Quadratic(double a, double b, double c) {
        super(a, b);

        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' in a quadratic equation cannot be 0");
        }

        this.c = c;
    }

    private double getDelta() {
        return (b * b) - (4 * a * c);
    }

    public double[] getRoots() {
        double delta = getDelta();

        if (delta < 0) {
            return new double[0];
        }

        double sqrtDelta = Math.sqrt(delta);
        double x1 = (-b - sqrtDelta) / (2.0 * a);

        if (delta == 0) {
            return new double[] { x1 };
        }

        double x2 = (-b + sqrtDelta) / (2.0 * a);
        return new double[] { x1, x2 };
    }

    @Override
    public double calculate(double x) {
        return a * (x * x) + (b * x) + c;
    }
}
