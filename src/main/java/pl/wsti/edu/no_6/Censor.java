package pl.wsti.edu.no_6;

import javax.swing.*;

class Censor extends Thread {
    private final JTextArea window;
    volatile boolean isEnded;

    public Censor(JTextArea window) {
        this.window = window;
        isEnded = false;
    }

    public void run() {
        while (!isEnded) {
            try {
                String tekst = window.getText().toLowerCase();

                if (!tekst.contains("cholera")) {
                    continue;
                }

                SwingUtilities.invokeLater(() ->
                    JOptionPane.showMessageDialog(
                        null,
                        "Uwaga! Wprowadzono niecenzuralne słowo!",
                        "Cenzor",
                        JOptionPane.WARNING_MESSAGE)
                );

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

