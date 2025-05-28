package pl.wsti.edu.no_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFramer extends JFrame {
    private JTextArea textArea;
    private Swapper swapper;
    private Censor censor;

    public JFramer() {
        initComponents();
        setSize(350, 250);

        swapper = new Swapper(textArea);
        swapper.start();
        censor = new Censor(textArea);
        censor.start();
    }

    private void initComponents() {
        JScrollPane pane = new JScrollPane();
        textArea = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textArea.setPreferredSize(new Dimension(300, 200));
        pane.setViewportView(textArea);

        getContentPane().add(pane, BorderLayout.CENTER);
        pack();
    }

    private void formWindowClosing(WindowEvent event) {
        if (swapper != null) {
            swapper.isEnded = true;
            swapper = null;
        }
        if (censor != null) {
            censor.isEnded = true;
            censor = null;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
            new JFramer().setVisible(true)
        );
    }
}

