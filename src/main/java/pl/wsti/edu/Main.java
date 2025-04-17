package pl.wsti.edu;

import pl.wsti.edu.no_1.Converter;
import pl.wsti.edu.no_1.Dialog;
import pl.wsti.edu.no_1.Factorial;
import pl.wsti.edu.no_1.Odds;
import pl.wsti.edu.no_2.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Dialog> panes = new ArrayList<>();

    private static void no1() {
        panes.add(new Dialog("1.1. Dialog"));
        panes.add(new Factorial("1.2 Factorial"));
        panes.add(new Odds("1.3 Odds"));
        panes.add(new Converter("1.4 Converter"));

        panes.forEach(Dialog::setResult);
    }

    private static void no2() {
        panes.add(new Exercise("2.3. Polynomial")
                .setResult());
    }

    public static void main(String[] args) {
        try {
//            no1();
            no2();

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