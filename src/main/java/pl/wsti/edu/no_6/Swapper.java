package pl.wsti.edu.no_6;

import javax.swing.*;

class Swapper extends Thread {
    private final JTextArea window;
    volatile boolean isEnded;

    public Swapper(JTextArea window) {
        this.window = window;
        isEnded = false;
    }

    public void run() {
        while (!isEnded) {
            try {
                String tekst = window.getText();
                int indeks = tekst.indexOf("{");

                if (indeks >= 0) {
                    window.replaceRange("begin", indeks, indeks + 1);
                    window.setCaretPosition(tekst.length() + 4);
                } else {
                    indeks = tekst.indexOf("}");

                    if (indeks >= 0) {
                        window.replaceRange("end", indeks, indeks + 1);
                        window.setCaretPosition(tekst.length() + 2);
                    }
                }

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
