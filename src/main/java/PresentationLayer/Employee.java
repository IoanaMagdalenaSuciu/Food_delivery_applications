package PresentationLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.Users;
import DataLayer.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 * This class will implement the interface used by the employees
 */
public class Employee extends JFrame implements Observer, ActionListener {
    JPanel mainPanel = new JPanel();
    JLabel orderMessage = new JLabel("No order to be delivered");
    JLabel title = new JLabel("Orders");
    JButton billButton = new JButton("Generate Bill");
    private final JButton backButton = new JButton("Back");
    private final List<Observer> observers = new ArrayList<>();
    private final FileWriter writer = new FileWriter();
    Users users;
    DeliveryService service;
    /**
     * This constructor will set the initial conditions of the interface
     * @param users
     * @param service
     */
    public Employee(Users users, DeliveryService service){
        this.users = users;
        this.service = service;
        service.registerObserver(this);
        mainPanel.setLayout(null);
        mainPanel.setSize(550, 400);
        mainPanel.setBackground(new Color(0x122620));

        title.setForeground(new Color(0xD6AD60));
        title.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
        title.setOpaque(true);
        title.setHorizontalAlignment((JLabel.CENTER));
        title.setBounds(130,25,250,55);
        title.setBackground(new Color(0x122620));

        orderMessage.setForeground(new Color(0xD6AD60));
        orderMessage.setFont(new Font(Font.SERIF, Font.PLAIN, 17));
        orderMessage.setOpaque(true);
        orderMessage.setHorizontalAlignment((JLabel.CENTER));
        orderMessage.setBounds(10,75,500,50);
        orderMessage.setBackground(new Color(0x122620));

        backButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        backButton.setBackground(new Color(0x122620));
        backButton.setBounds(35,300,100,50);
        backButton.setForeground(new Color(0xD6AD60));
        backButton.addActionListener( this);

        billButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        billButton.setBackground(new Color(0x122620));
        billButton.setBounds(175,300,200,50);
        billButton.setForeground(new Color(0xD6AD60));
        billButton.addActionListener( this);

        mainPanel.add(billButton);
        mainPanel.add(title);
        mainPanel.add(orderMessage);
        mainPanel.add(backButton);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 400);
        this.setLayout(null);
        this.setVisible(true);


    }


    /**
     * This method is define in Observer interface and will update the message with the new oder
     * @param message
     */
    public void update(String message) {
        orderMessage.setText(message);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /**
     * This method will perform an action for every Button
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();
            LogIn logIn = new LogIn(users,service);
        }
        if(e.getSource() == billButton){
            writer.writeBill(orderMessage.getText());

        }

    }
}
