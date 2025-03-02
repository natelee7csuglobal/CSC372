package module3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuExample extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

    public MenuExample() {
        // Here we have the initial setup of the frame
        setTitle("Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Now we need to create the area for the text
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Menu Bar creation
        JMenuBar menuBar = new JMenuBar();
        
        // We add the menu here
        JMenu menu = new JMenu("Options");
        
        // Add menu items
        // First we need to get the time stamp to print in the frame
        JMenuItem getTimeItem = new JMenuItem("Get Date and Time");
        getTimeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String currentTime = dtf.format(LocalDateTime.now());
                textArea.setText(currentTime);
            }
        });
        
        // next we need create the save to file button here
        JMenuItem saveToFileItem = new JMenuItem("Save to Log File");
        saveToFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String content = textArea.getText();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
                    writer.write(content);
                    JOptionPane.showMessageDialog(null, "Content saved to log.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving to file: " + ex.getMessage());
                }
            }
        });
        
        // this changes the background color for the frame
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        changeColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Random hue of green
                Random rand = new Random();
                int greenValue = rand.nextInt(256);
                getContentPane().setBackground(new Color(0, greenValue, 0));
            }
        });
        
        // Create the exit button action here
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Here we add the actual menu items
        menu.add(getTimeItem);
        menu.add(saveToFileItem);
        menu.add(changeColorItem);
        menu.add(exitItem);
        
        // Adding menu to menu bar
        menuBar.add(menu);
        
        // Setting the menu bar
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuExample example = new MenuExample();
            example.setVisible(true);
        });
    }
}
