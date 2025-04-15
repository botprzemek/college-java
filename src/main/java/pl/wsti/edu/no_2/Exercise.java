package pl.wsti.edu.no_2;

import pl.wsti.edu.no_1.Dialog;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise extends Dialog {
    public Exercise(String title) {
        super(title);
    }

    public Exercise setResult() {
        Polynomial[] p = new Polynomial[3];

        p[0] = new Linear(2, 1);
        p[1] = new Quadratic(1, -2, 2);
        p[2] = new Quadratic(1, 0, -1);

        String result = Arrays
            .stream(p)
            .map(Polynomial::getRoots)
            .map(roots ->
                switch (roots.length) {
                    case 1 -> "Roots: { x1: " + roots[0] + " }";
                    case 2 -> "Roots: { x1: " + roots[0] + ", x2: " + roots[1] + " }";
                    default -> "Roots: None";
            })
            .collect(Collectors.joining(",\n"));

        setMessage(result);

        return this;
    }
}