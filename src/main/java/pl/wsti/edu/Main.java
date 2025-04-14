package pl.wsti.edu;

import pl.wsti.edu.no_1.Converter;
import pl.wsti.edu.no_1.Dialog;
import pl.wsti.edu.no_1.Factorial;
import pl.wsti.edu.no_1.Odds;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Dialog> panes = new ArrayList<>();

    public static void main(String[] args) {
        try {
            panes.add(new Dialog("1.1. Dialog"));
            panes.add(new Factorial("1.2 Factorial"));
            panes.add(new Odds("1.3 Odds"));
            panes.add(new Converter("1.4 Converter"));

            panes.forEach(Dialog::show);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }
}