package pl.wsti.edu.no_2;

public abstract class Polynomial {
    protected double a;
    protected double b;

    protected Polynomial(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public abstract double[] getRoots();

    public abstract double calculate(double x);
}
