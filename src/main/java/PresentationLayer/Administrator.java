package PresentationLayer;

import BusinessLayer.*;
import BusinessLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class will implement the interface used by the administrator
 */
public class Administrator extends JFrame implements ActionListener, Serializable {
    private JButton backButton = new JButton("Back");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton bDelete = new JButton("Delete");
    JButton bUpdate = new JButton("Update");
    JButton bAdd = new JButton("Add");
    JButton bCompose = new JButton("Compose");
    JTextField nameAdd = new JTextField("Name");
    JTextField priceAdd = new JTextField("Price");
    JTextField sodiumAdd = new JTextField("Sodium");
    JTextField fatAdd =  new JTextField("Fat");
    JTextField proteinAdd = new JTextField("Protein");
    JTextField caloriesAdd = new JTextField("Calories");
    JLabel title = new JLabel("Food Delivery Management System");
    JLabel lDelete = new JLabel("Enter the name of the product to be deleted");
    JLabel lUpdate = new JLabel("Enter the name of the product and the new price");
    JLabel lAddBase = new JLabel("Add a base product:");
    JTable menu ;
    JLabel compositeLable= new JLabel("The name of the new composite product: ");
    JTextField compositeAdd = new JTextField();

    JTextField startHour = new JTextField();
    JTextField endHour = new JTextField();
    JLabel statisticHour = new JLabel("Enter the start hour and the end hour for statistics");
    JButton hourButton = new JButton("Statistic 1");
    JTextField timesOrder = new JTextField();
    JLabel timesOrderLabel = new JLabel("Number of times for statistics");
    JButton timesButton = new JButton("Statistic 2");

    JLabel sumLabel = new JLabel("The order value");
    JTextField sumOrders = new JTextField();
    JLabel timesClient = new JLabel("The number of time");
    JTextField timesClientsText = new JTextField();
    JLabel rate = new JLabel("The number of times and the value of orders");
    JButton statistic3 = new JButton("Statistic 3");

    JLabel dayLabel = new JLabel("Day for statistic 4");
    JTextField dayText = new JTextField();
    JButton statistic4 = new JButton("Statistic 4");
    JButton importButton = new JButton("Import Products");
    Users users;
    DeliveryService service;

    /**
     * This constructor will set the initial conditions of the interface
     * @param users
     * @param service
     */
    public Administrator(Users users, DeliveryService service) {



        this.users =users;
        this.service=service;
        this.setBounds(0,0,1000, 950);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Delivery Service");
        this.setResizable(false);
        this.setVisible(true);


        panel1.setBackground(new Color(0x613659));
        panel2.setBackground(new Color(0xEAE6F0));

        panel1.setBounds(0,0,1000,50);
        panel2.setBounds(0,50,1000,900);

        title.setForeground(new Color(0x996633));
        title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 30));
        title.setOpaque(true);
        title.setHorizontalAlignment((JLabel.CENTER));
        title.setBackground(new Color( 0x613659));
        title.setVerticalTextPosition(JLabel.TOP);

        panel1.add(title);


        panel2.setLayout(null);
        lAddBase.setForeground(new Color(0x996633));
        lAddBase.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        lAddBase.setOpaque(true);
        lAddBase.setBackground(new Color( 0xEAE6F0));
        lAddBase.setBounds(10,10,200,25);

        nameAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        nameAdd.setBounds(225,5,300,30);
        nameAdd.setForeground(new Color(0x996633));

        priceAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        priceAdd.setForeground(new Color(0x996633));
        priceAdd.setBounds(550,2,100,30);

        caloriesAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        caloriesAdd.setForeground(new Color(0x996633));
        caloriesAdd.setBounds(225,40,100,30);

        proteinAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        proteinAdd.setForeground(new Color(0x996633));
        proteinAdd.setBounds(340,40,100,30);


        sodiumAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        sodiumAdd.setForeground(new Color(0x996633));
        sodiumAdd.setBounds(455,40,100,30);

        fatAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        fatAdd.setForeground(new Color(0x996633));
        fatAdd.setBounds(570,40,100,30);


        bAdd.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        bAdd.setBackground(new Color(0x420264));
        bAdd.setBounds(675,3,200,30);
        bAdd.setForeground(new Color(0x996633));
        bAdd.addActionListener(this);

        bDelete.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        bDelete.setBackground(new Color(0x420264));
        bDelete.setBounds(675,100,200,30);
        bDelete.setForeground(new Color(0x996633));
        bDelete.addActionListener(this);


        bUpdate.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        bUpdate.setBackground(new Color(0x420264));
        bUpdate.setBounds(675,150,200,30);
        bUpdate.setForeground(new Color(0x996633));
        bUpdate.addActionListener(this);

        importButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        importButton.setBackground(new Color(0x420264));
        importButton.setBounds(675,250,250,30);
        importButton.setForeground(new Color(0x996633));
        importButton.addActionListener(this);

        bCompose.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        bCompose.setBackground(new Color(0x420264));
        bCompose.setBounds(675,350,200,30);
        bCompose.setForeground(new Color(0x996633));
        bCompose.addActionListener(this);

        backButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        backButton.setBackground(new Color(0x420264));
        backButton.setBounds(35,400,200,50);
        backButton.setForeground(new Color(0x996633));
        backButton.addActionListener(this);

        updateTable();

        compositeLable.setForeground(new Color(0x996633));
        compositeLable.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        compositeLable.setOpaque(true);
        compositeLable.setBackground(new Color( 0xEAE6F0));
        compositeLable.setBounds(10,350,350,25);

        compositeAdd.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        compositeAdd.setForeground(new Color(0x996633));
        compositeAdd.setBounds(400,350,150,30);

        statisticHour.setForeground(new Color(0x996633));
        statisticHour.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        statisticHour.setOpaque(true);
        statisticHour.setBackground(new Color( 0xEAE6F0));
        statisticHour.setBounds(35,470,400,25);

        startHour.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        startHour.setForeground(new Color(0x996633));
        startHour.setBounds(450,470,100,30);

        endHour.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        endHour.setForeground(new Color(0x996633));
        endHour.setBounds(570,470,100,30);

        hourButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        hourButton.setBackground(new Color(0x420264));
        hourButton.setBounds(675,470,200,30);
        hourButton.setForeground(new Color(0x996633));
        hourButton.addActionListener(this);

        timesOrder.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        timesOrder.setForeground(new Color(0x996633));
        timesOrder.setBounds(450,520,100,30);

        timesOrderLabel.setForeground(new Color(0x996633));
        timesOrderLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        timesOrderLabel.setOpaque(true);
        timesOrderLabel.setBackground(new Color( 0xEAE6F0));
        timesOrderLabel.setBounds(35,520,400,25);

        timesButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        timesButton.setBackground(new Color(0x420264));
        timesButton.setBounds(675,520,200,30);
        timesButton.setForeground(new Color(0x996633));
        timesButton.addActionListener(this);

        sumOrders.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        sumOrders.setForeground(new Color(0x996633));
        sumOrders.setBounds(450,570,100,30);

        timesClientsText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        timesClientsText.setForeground(new Color(0x996633));
        timesClientsText.setBounds(570,570,100,30);

        rate.setForeground(new Color(0x996633));
        rate.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        rate.setOpaque(true);
        rate.setBackground(new Color( 0xEAE6F0));
        rate.setBounds(35,570,400,25);

        statistic3.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        statistic3.setBackground(new Color(0x420264));
        statistic3.setBounds(675,570,200,30);
        statistic3.setForeground(new Color(0x996633));
        statistic3.addActionListener(this);

        dayLabel.setForeground(new Color(0x996633));
        dayLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        dayLabel.setOpaque(true);
        dayLabel.setBackground(new Color( 0xEAE6F0));
        dayLabel.setBounds(35,620,400,25);

        dayText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        dayText.setForeground(new Color(0x996633));
        dayText.setBounds(450,620,100,30);

        statistic4.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        statistic4.setBackground(new Color(0x420264));
        statistic4.setBounds(675,620,200,30);
        statistic4.setForeground(new Color(0x996633));
        statistic4.addActionListener(this);

        panel2.add(statistic4);
        panel2.add(dayLabel);
        panel2.add(dayText);
        panel2.add(rate);
        panel2.add(statistic3);
        panel2.add(timesOrderLabel);
        panel2.add(timesOrder);
        panel2.add(timesButton);
        panel2.add(sumOrders);
        panel2.add(timesClientsText);
        panel2.add(hourButton);
        panel2.add(endHour);
        panel2.add(startHour);
        panel2.add(statisticHour);
        panel2.add(compositeAdd);
        panel2.add(compositeLable);
        panel2.add(bAdd);
        panel2.add(lAddBase);
        panel2.add(importButton);
        panel2.add(nameAdd);
        panel2.add(priceAdd);
        panel2.add(bDelete);
        panel2.add(bUpdate);
        panel2.add(bCompose);
        panel2.add(backButton);
        panel2.add(caloriesAdd);
        panel2.add(proteinAdd);
        panel2.add(sodiumAdd);
        panel2.add(fatAdd);
        this.add(panel1);
        this.add(panel2);

    }

    /**
     * This method will update the table for menu
     */
    public void updateTable(){

        Component[] componentList = panel2.getComponents();
        for(Component c : componentList){
            if(c instanceof JScrollPane){
                panel2.remove(c);
            }
        }
        panel2.revalidate();
        panel2.repaint();
        menu = new JTable(service.getMenu().toArray(new Object[][]{}),new String[] {"Name", "Price","Calories", "Fat","Protein","Sodium", "Rating"});
        menu.setBackground(new Color( 0xEAE6F0));
        menu.setRowSelectionAllowed(true);
        menu.setFillsViewportHeight(true);
        JScrollPane scroll= new JScrollPane(menu);
        scroll.setBounds(30,100,600,200);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        panel2.add(scroll);

        this.setVisible(true);


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
        if(e.getSource() == bAdd){
            float price = Float.parseFloat(priceAdd.getText());

            BaseProducts item = new BaseProducts(0,price,nameAdd.getText(),Integer.parseInt(caloriesAdd.getText()),Integer.parseInt(proteinAdd.getText()),Integer.parseInt(fatAdd.getText()),Integer.parseInt(sodiumAdd.getText()));
            System.out.println(item);
            service.addInMenu(item);
            updateTable();
        }
        if(e.getSource() == bDelete){
            int row = menu.getSelectedRow();
            String name = menu.getValueAt(row,0).toString();
            System.out.println(name);
            service.deleteFromMenu(name);
            updateTable();

        }
        if(e.getSource() == bUpdate){
            int row = menu.getSelectedRow();
            String result = new String();
            service.updateInMenu(Float.parseFloat(menu.getValueAt(row,1).toString()),menu.getValueAt(row,0).toString());
            updateTable();
        }
        if(e.getSource() == bCompose){
            CompositeProduct compositeProduct = new CompositeProduct(0,0,compositeAdd.getText(),0,0,0,0);
            int rows[] = menu.getSelectedRows();
            for(int i = 0; i < menu.getSelectedRowCount(); i++){
               service.addToComposite(compositeProduct,service.getMenuItem(menu.getValueAt(rows[i],0).toString()));
            }
            service.addInMenu(compositeProduct);

            updateTable();
        }
        if(e.getSource() == hourButton){
            Long start = Long.parseLong(startHour.getText());
            Long end = Long.parseLong(endHour.getText());

            service.getStatistic1(start, end);


        }
        if(e.getSource() == timesButton){
            service.getStatistic2(Long.parseLong(timesOrder.getText()));
        }
        if(e.getSource() == statistic3){
            service.getStatistic3(Integer.parseInt(sumOrders.getText()), Float.parseFloat(timesClientsText.getText()));
        }
        if(e.getSource() == statistic4){
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
            Date date = null;
            try {
                date = sdf.parse(dayText.getText());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            service.getStatistic4(date);
        }
        if(e.getSource() == importButton){
            try {
                service.importProducts();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            updateTable();
        }
    }



}
