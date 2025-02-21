package module2;

// here we are going to need to import the libraries that we will be using
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// calling the public class "BankBalanceApp"
public class BankBalanceApp {
    private double balance;
    private JLabel balanceLabel;

    // creating the initial balance for the user
    public BankBalanceApp() {
        balance = 0.0;

        // here is the main frame of the program
        JFrame frame = new JFrame("Bank Balance Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        // make the JPanel here
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        // display the balance for the user
        balanceLabel = new JLabel("Current Balance: $" + balance);
        panel.add(balanceLabel);

        // ------------------------------------------BUTTONS START------------------------------------------
        // create deposit button
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter deposit amount:");
                if (input != null) {
                    try {
                        double amount = Double.parseDouble(input);
                        if (amount > 0) {
                            balance += amount;
                            updateBalance();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Enter a valid amount.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input.");
                    }
                }
            }
        });
        panel.add(depositButton);

        // create withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
                if (input != null) {
                    try {
                        double amount = Double.parseDouble(input);
                        if (amount > 0 && amount <= balance) {
                            balance -= amount;
                            updateBalance();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid amount or insufficient funds.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input.");
                    }
                }
            }
        });
        panel.add(withdrawButton);
        
        // create an exit button for the user to close out the program, show balance on exit
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Final Balance: $" + balance);
            System.exit(0);
        });
        panel.add(exitButton);
        // ------------------------------------------BUTTONS END------------------------------------------

        // add panel to frame and display
        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankBalanceApp::new);
    }
}
