package PresentationLayer;

//import BusinessLayer.BaseProducts;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

/**
 * This class will implement the interface used by the clients
 */
public class Client extends JFrame implements ActionListener {

    private final JButton backButton = new JButton("Back");
    private JLabel title = new JLabel("Client Interface");
    private JTable menu;
    private JButton order = new JButton("Order");
    private final JButton filterButton = new JButton("Filter");
    private final JTextField dateOrder = new JTextField();
    private final JLabel dateLable = new JLabel("Order date: ");
    private String clientId = "";
    JLabel message = new JLabel();
    JLabel criteriaLabel = new JLabel("Criteria");
    JLabel typeLabel = new JLabel("Type");
    JTextField typeText = new JTextField();
    JLabel ratingLabel = new JLabel("Rating");
    JTextField ratingText = new JTextField();
    JLabel caloriesLabel = new JLabel("Calories");
    JTextField caloriesText = new JTextField();
    JLabel proteinLabel = new JLabel("Protein");
    JTextField proteinText = new JTextField();
    JLabel sodiumLabel = new JLabel("Sodium");
    JTextField sodiumText = new JTextField();
    JLabel fatLabel = new JLabel("Fats");
    JTextField fatText = new JTextField();
    JLabel priceLabel = new JLabel("Price");
    JTextField priceText = new JTextField();
    JPanel mainPanel =  new JPanel();
    JLabel hourLabel = new JLabel("Order hour");
    JTextField hourText = new JTextField();
    private Users users;
    private DeliveryService service;

    /**
     * This constructor will set the initial conditions of the interface
     * @param users
     * @param service
     */
    public Client(Users users, DeliveryService service, String client){
        this.clientId = client;
        this.users = users;
        this.service = service;
        this.setBounds(0,0,950, 750);
        this.setLayout(null);
        this.setBackground(new Color(0xE5DAD2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Delivery Service");
        this.setResizable(false);
        this.setVisible(true);
        mainPanel.setBounds(0,0,950, 750);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(0xE5DAD2));
        mainPanel.setVisible(true);


        title.setForeground(new Color(0x996633));
        title.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 30));
        title.setBounds(375, 10,400,30);
        title.setBackground(new Color( 0x613659));

        TableModel tableModel = new DefaultTableModel(service.getMenu().toArray(new Object[][]{}),new String[] {"Name", "Price","Calories", "Fat","Protein","Sodium", "Rating"});
        menu = new JTable(tableModel);

        menu.setFillsViewportHeight(true);

        JScrollPane js=new JScrollPane(menu);
        js.setBounds(30,100,600,200);

        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        menu.setBackground(new Color(0xE5DAD2));
        js.setVisible(true);

        order.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        order.setBackground(new Color(0x710019));
        order.setBounds(700,250,200,50);
        order.setForeground(new Color(0x996633));
        order.addActionListener(this);

        backButton.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        backButton.setBackground(new Color(0x710019));
        backButton.setBounds(35,400,200,50);
        backButton.setForeground(new Color(0x996633));
        backButton.addActionListener(this);

        dateLable.setForeground(new Color(0x996633));
        dateLable.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        dateLable.setBounds(650, 150,200,30);

        dateOrder.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        dateOrder.setForeground(new Color(0x996633));
        dateOrder.setBounds(750,150,100,30);

        hourLabel.setForeground(new Color(0x996633));
        hourLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        hourLabel.setBounds(650, 200,200,30);

        hourText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        hourText.setForeground(new Color(0x996633));
        hourText.setBounds(750,200,100,30);

        criteriaLabel.setForeground(new Color(0x996633));
        criteriaLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 30));
        criteriaLabel.setBounds(550, 320,300,30);
        criteriaLabel.setBackground(new Color( 0x613659));

        typeLabel.setForeground(new Color(0x996633));
        typeLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        typeLabel.setBounds(400, 370,200,30);

        typeText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        typeText.setForeground(new Color(0x996633));
        typeText.setBounds(630,370,100,30);

        filterButton.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        filterButton.setBackground(new Color(0x710019));
        filterButton.setBounds(750,470,150,50);
        filterButton.setForeground(new Color(0x996633));
        filterButton.addActionListener(this);

        ratingLabel.setForeground(new Color(0x996633));
        ratingLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        ratingLabel.setBounds(400, 420,200,30);

        ratingText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        ratingText.setForeground(new Color(0x996633));
        ratingText.setBounds(630,420,100,30);


        caloriesLabel.setForeground(new Color(0x996633));
        caloriesLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        caloriesLabel.setBounds(400, 470,200,30);

        caloriesText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        caloriesText.setForeground(new Color(0x996633));
        caloriesText.setBounds(630,470,100,30);

        proteinLabel.setForeground(new Color(0x996633));
        proteinLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        proteinLabel.setBounds(400, 520,200,30);

        proteinText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        proteinText.setForeground(new Color(0x996633));
        proteinText.setBounds(630,520,100,30);


        sodiumLabel.setForeground(new Color(0x996633));
        sodiumLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        sodiumLabel.setBounds(400, 570,200,30);

        sodiumText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        sodiumText.setForeground(new Color(0x996633));
        sodiumText.setBounds(630,570,100,30);


        fatLabel.setForeground(new Color(0x996633));
        fatLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        fatLabel.setBounds(400, 620,200,30);

        fatText.setFont(new Font("Comic Sans",Font.ITALIC, 15));
        fatText.setForeground(new Color(0x996633));
        fatText.setBounds(630,620,100,30);

        priceLabel.setForeground(new Color(0x996633));
        priceLabel.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        priceLabel.setBounds(400, 670,200,30);

        priceText.setForeground(new Color(0x996633));
        priceText.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 20));
        priceText.setBounds(630, 670,100,30);



        mainPanel.add(hourLabel);
        mainPanel.add(hourText);
        mainPanel.add(filterButton);
        mainPanel.add(priceLabel);
        mainPanel.add(priceText);
        mainPanel.add(proteinLabel);
        mainPanel.add(proteinText);
        mainPanel.add(sodiumLabel);
        mainPanel.add(sodiumText);
        mainPanel.add(fatLabel);
        mainPanel.add(fatText);
        mainPanel.add(caloriesLabel);
        mainPanel.add(caloriesText);
        mainPanel.add(ratingLabel);
        mainPanel.add(ratingText);
        mainPanel.add(typeLabel);
        mainPanel.add(typeText);
        mainPanel.add(title);
        mainPanel.add(backButton);
        mainPanel.add(js);
        mainPanel.add(order);
        mainPanel.add(dateOrder);
        mainPanel.add(dateLable);
        mainPanel.add(criteriaLabel);
        this.add(mainPanel);
    }
    /**
     * This method will update the table for menu
     */
    public void updateTable(List<MenuItem> list){

        List<Object[]> result = new ArrayList<>();
        for(MenuItem item: list){
            result.add(new Object[]{item.getName(), item.getPrice(), item.getCalories(),item.getFat(),item.getProtein(),item.getSodium(),item.getRating()});
        }
        Component[] componentList = mainPanel.getComponents();
        for(Component c : componentList){
            if(c instanceof JScrollPane){
                mainPanel.remove(c);
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        menu = new JTable(result.toArray(new Object[][]{}),new String[] {"Name", "Price","Calories", "Fat","Protein","Sodium", "Rating"});
        menu.setBackground(new Color(0xE5DAD2));
        menu.setRowSelectionAllowed(true);
        menu.setFillsViewportHeight(true);
        JScrollPane scroll= new JScrollPane(menu);
        scroll.setBounds(30,100,600,200);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        mainPanel.add(scroll);

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
        if(e.getSource() == order){
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
            int hour = Integer.parseInt(hourText.getText());
            Date date = null;
            try {
                date = sdf.parse(dateOrder.getText());
                date.setHours(hour);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            int id = service.createOrder(clientId,date);

            for(int i =  0; i < menu.getSelectedRowCount(); i++){
               service.addItemsToOrder(menu.getValueAt(i,0).toString(),id);

            }
            title.setText("Success: Your order is on its way");
            title.setForeground(new Color(0x1A4314));
            title.setBounds(300, 10,450,50);
            System.out.println(service.getOrder(id).toString());
            service.notifyOrder(service.getOrder(id).toString());
        }
        if(e.getSource() == filterButton){
            if(!typeText.getText().isEmpty()) {
                updateTable(service.filterByType(typeText.getText()));
            }

            if(!caloriesText.getText().isEmpty()){
                    updateTable(service.filterByCalories(Integer.parseInt(caloriesText.getText())));
                }
            if(!fatText.getText().isEmpty()){
                updateTable(service.filterByFat(Integer.parseInt(fatText.getText())));
            }
            if(!priceText.getText().isEmpty()){
                updateTable(service.filterByPrice(Float.parseFloat(priceText.getText())));
            }
            if(!proteinText.getText().isEmpty()){
                updateTable(service.filterByProtein(Integer.parseInt(proteinText.getText())));
            }
            if(!ratingText.getText().isEmpty()){
                updateTable(service.filterByRating(Float.parseFloat(ratingText.getText())));
            }
            if(!sodiumText.getText().isEmpty()){
                updateTable(service.filterBySodium(Integer.parseInt(sodiumText.getText())));
            }

        }


    }

    }

