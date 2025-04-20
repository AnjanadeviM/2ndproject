import javax.swing.*;
import java.awt.*;

public class URLShortenerGUI {
    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        JFrame frame = new JFrame("Java URL Shortener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JTextField inputField = new JTextField();
        JTextArea outputArea = new JTextArea();
        JButton shortenButton = new JButton("Shorten");
        JButton expandButton = new JButton("Expand");

        shortenButton.addActionListener(e -> {
            String longURL = inputField.getText();
            outputArea.setText("Shortened URL:\n" + shortener.shortenURL(longURL));
        });

        expandButton.addActionListener(e -> {
            String shortURL = inputField.getText();
            outputArea.setText("Original URL:\n" + shortener.expandURL(shortURL));
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.NORTH);
        panel.add(outputArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(shortenButton);
        buttonPanel.add(expandButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
