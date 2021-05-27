package PresentationLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class will implement the interface used to create a new account
 */
public class NewClient extends JFrame implements ActionListener {
    JPanel mainPanel = new JPanel();
    JButton client = new JButton("Client");
    JButton employee = new JButton("Employee");
    private JButton backButton = new JButton("Back");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel title = new JLabel("Create account");
    JLabel messageLabel = new JLabel();
    DeliveryService service;
    Users users;

    public NewClient(Users users, DeliveryService service) {
        this.users = users;
        this.service = service;
        mainPanel.setLayout(null);
        mainPanel.setSize(500, 420);
        mainPanel.setBackground(new Color(0x21C5C4));

        title.setForeground(new Color(0x412516));
        title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
        title.setOpaque(true);
        title.setHorizontalAlignment((JLabel.CENTER));
        title.setBackground(new Color(0x21C5C4));
        title.setBounds(70, 25, 250, 55);

        userIDLabel.setBounds(25, 100, 105, 25);
        userIDLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));
        userIDLabel.setForeground(new Color(0x412516));

        userPasswordLabel.setBounds(25, 150, 105, 30);
        userPasswordLabel.setForeground(new Color(0x412516));
        userPasswordLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(130, 100, 200, 25);
        userIDField.setBackground(new Color(0xC8F4F9));
        userIDField.setForeground(new Color(0x412516));
        userIDField.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 15));

        userPasswordField.setBounds(130, 150, 200, 25);
        userPasswordField.setBackground(new Color(0xC8F4F9));

        resetButton.setBounds(100, 190, 200, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(0x513B41));
        resetButton.setForeground(new Color(0xC8F4F9));
        resetButton.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));

        client.setBounds(100, 230, 200, 25);
        client.setFocusable(false);
        client.addActionListener(this);
        client.setBackground(new Color(0x513B41));
        client.setForeground(new Color(0xC8F4F9));
        client.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));

        employee.setBounds(100, 270, 200, 25);
        employee.setFocusable(false);
        employee.addActionListener(this);
        employee.setBackground(new Color(0x513B41));
        employee.setForeground(new Color(0xC8F4F9));
        employee.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));

        backButton.setBounds(25, 300, 200, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setBackground(new Color(0x513B41));
        backButton.setForeground(new Color(0xC8F4F9));
        backButton.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));

        mainPanel.add(client);
        mainPanel.add(employee);
        mainPanel.add(backButton);
        mainPanel.add(resetButton);
        mainPanel.add(userIDField);
        mainPanel.add(userIDLabel);
        mainPanel.add(userPasswordField);
        mainPanel.add(userPasswordLabel);
        mainPanel.add(title);
        mainPanel.add(messageLabel);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(null);
        this.setVisible(true);
    }
    /**
     * This method will perform an action for every Button
     * @param e
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource() == client){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if(users.getClients().getLoginInfo().containsKey(userID)) {
                title.setForeground(new Color(0x900300));
                title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
                title.setBounds(5,25,400, 55);
                title.setText("This userId already exists, please try again");
            }
           else{
                title.setForeground(new Color(0x1A4314));
                title.setText("Success");

                users.addClient(userID,password);
            }

        }
        if(e.getSource() == employee) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if (users.getEmployee().getLoginInfo().containsKey(userID)) {
                title.setForeground(new Color(0x900300));
                title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
                title.setBounds(5, 25, 400, 55);
                title.setText("This userId already exists, please try again");
            } else {
                title.setForeground(new Color(0x1A4314));
                title.setText("Success");

                users.addEmployee(userID, password);
            }
        }
        if(e.getSource() == backButton){
            this.dispose();
            LogIn main = new LogIn(users,service);
        }

    }
}
