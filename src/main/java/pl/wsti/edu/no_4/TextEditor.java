package pl.wsti.edu.no_4;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextEditor extends JFrame {
    private final JTextArea textArea;

    public TextEditor() {
        super("Text Editor");

        textArea = new JTextArea(20, 40);
        JButton saveButton = new JButton("Save file");
        JScrollPane scrollPane = new JScrollPane(textArea);

        saveButton.addActionListener(event -> save());

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(saveButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = fileChooser.getSelectedFile();
        try {
            FileOutputStream output = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);

            writer.write(textArea.getText());

            writer.close();
            output.close();

            JOptionPane.showMessageDialog(this, "File saved.");
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File not found: " + ex.getMessage());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Write error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditor::new);
    }
}
