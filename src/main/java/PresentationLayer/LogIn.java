package PresentationLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class will implement the interface used to Log in application
 */
public class LogIn extends JFrame implements ActionListener  {

    JPanel mainPanel = new JPanel();
    JButton loginClient = new JButton("Login as Client");
    JButton loginAdmin = new JButton("Login as Admin");
    JButton loginEmployee = new JButton("Login as Employee");
    JButton newClient = new JButton("Create Account");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");

    JLabel title = new JLabel("Welcome");
    Users users;
    DeliveryService service;
    /**
     * This constructor will set the initial conditions of the interface
     * @param users
     * @param service
     */
    public LogIn(Users users, DeliveryService service) {

        this.users = users;
        this.service = service;
        mainPanel.setLayout(null);
        mainPanel.setSize(500, 420);
        mainPanel.setBackground(new Color(0x21C5C4));

        title.setForeground(new Color(0x412516));
        title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 50));
        title.setOpaque(true);
        title.setHorizontalAlignment((JLabel.CENTER));
        title.setBackground(new Color( 0x21C5C4));
        title.setBounds(70,25,250,55);


        userIDLabel.setBounds(25, 100, 105, 25);
        userIDLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));
        userIDLabel.setForeground(new Color(0x412516));

        userPasswordLabel.setBounds(25, 150, 105, 30);
        userPasswordLabel.setForeground(new Color(0x412516));
        userPasswordLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));



        userIDField.setBounds(130, 100, 200, 25);
        userIDField.setBackground(new Color(0xC8F4F9));
        userIDField.setForeground(new Color(0x412516));
        userIDField.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 15));

        userPasswordField.setBounds(130, 150, 200, 25);
        userPasswordField.setBackground(new Color(0xC8F4F9));


        loginClient.setBounds(25, 200, 150, 25);
        loginClient.setBackground(new Color(0x513B41));
        loginClient.setForeground(new Color(0xC8F4F9));
        loginClient.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));
        loginClient.setFocusable(false);
        loginClient.addActionListener(this);

        loginAdmin.setBounds(225, 200, 150, 25);
        loginAdmin.setFocusable(false);
        loginAdmin.addActionListener(this);
        loginAdmin.setBackground(new Color(0x513B41));
        loginAdmin.setForeground(new Color(0xC8F4F9));
        loginAdmin.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));


        loginEmployee.setBounds(25, 250, 150, 25);
        loginEmployee.setFocusable(false);
        loginEmployee.addActionListener(this);
        loginEmployee.setBackground(new Color(0x513B41));
        loginEmployee.setForeground(new Color(0xC8F4F9));
        loginEmployee.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 15));


        resetButton.setBounds(100, 290, 200, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(0x513B41));
        resetButton.setForeground(new Color(0xC8F4F9));
        resetButton.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));

        newClient.setBounds(225, 250, 150, 25);
        newClient.setFocusable(false);
        newClient.addActionListener(this);
        newClient.setBackground(new Color(0x513B41));
        newClient.setForeground(new Color(0xC8F4F9));
        newClient.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 17));


        mainPanel.add(userIDLabel);
        mainPanel.add(userPasswordLabel);

        mainPanel.add(userIDField);
        mainPanel.add(userPasswordField);
        mainPanel.add(loginClient);
        mainPanel.add(loginAdmin);
        mainPanel.add(loginEmployee);
        mainPanel.add(newClient);
        mainPanel.add(resetButton);
        mainPanel.add(title);
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

        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginAdmin) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            System.out.println(userID+" "+password);
            System.out.println(users.getAdmin().getLoginInfo());
            if(users.getAdmin().getLoginInfo().containsKey(userID)) {
                if(users.getAdmin().getLoginInfo().get(userID).equals(password)) {
                    title.setForeground(new Color(0x1A4314));
                    title.setText("Login successful");
                    this.dispose();
                    Administrator administrator = new Administrator(users, service);
                }
                else {
                    title.setForeground(new Color(0x900300));
                    title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
                    title.setBounds(5,25,400, 55);
                    title.setText("Wrong password");
                }

            }
            else {
                title.setForeground(new Color(0x900300));
                title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
                title.setBounds(5,25,400, 55);
                title.setText("username not found");
            }
        }
        if(e.getSource()==loginClient) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(users.getClients().getLoginInfo().containsKey(userID)) {
                if(users.getClients().getLoginInfo().get(userID).equals(password)) {
                    title.setForeground(new Color(0x1A4314));
                    title.setText("Login successful");
                    this.dispose();
                    Client client = new Client(users,service, userID);
                }
                else {
                    title.setForeground(new Color(0x900300));
                    title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
                    title.setBounds(5,25,400, 55);
                    title.setText("Wrong password");
                }

            }
            else {
                title.setForeground(new Color(0x900300));
                title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
                title.setBounds(5,25,400, 55);
                title.setText("username not found");
            }
        }
        if(e.getSource()==newClient) {
            this.dispose();
            NewClient newClient = new NewClient(users, service);
        }
        if(e.getSource()==loginEmployee){

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(users.getEmployee().getLoginInfo().containsKey(userID)) {
                if(users.getEmployee().getLoginInfo().get(userID).equals(password)) {

                    title.setForeground(new Color(0x1A4314));
                    title.setText("Login successful");
                    // this.dispose();

                    Employee emp = new Employee(users,service);
                }
                else {
                    title.setForeground(new Color(0x900300));
                    title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
                    title.setBounds(5,25,400, 55);
                    title.setText("Wrong password");
                }
            }
            else {
                title.setForeground(new Color(0x900300));
                title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 40));
                title.setBounds(5,25,400, 55);
                title.setText("username not found");

            }
        }
    }
}

