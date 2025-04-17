package pl.wsti.edu.no_3;

class Constant extends Node {
    private final int value;

    public Constant(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
