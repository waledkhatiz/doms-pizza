import java.awt.*;
import javax.swing.*;
import java.util.ArrayList; 
import java.util.List;

public class menu {
    public static void main(String args[]) {
        String[] pizzaType = {"Pepperoni", "Italian", "Cheese", "Meat Lovers"};
        String[] pizzaCrust = {"Traditional", "Cheese-Stuffed", "Thin"};
        String[] pizzaSauce = {"None", "Tomato", "Barbecue", "Chilli"};
        List<Double> orderPrices = new ArrayList<Double>();

        pizza currentOrder = new pizza();
    
        JFrame mainMenu = new JFrame();
        JFrame pizzaMenu = new JFrame();
        
        mainMenu.setSize(630, 400);
        mainMenu.setTitle("Dom's Pizza");
        mainMenu.setResizable(true);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pizzaMenu.setSize(450, 500);
        pizzaMenu.setTitle("Create Your Pizza");
        pizzaMenu.setResizable(false);
        pizzaMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //left side of the interface (the list of pizzas)

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setPreferredSize(new Dimension(500, 400));

        List<String> orderStrings = new ArrayList<String>();
        DefaultListModel listElements = new DefaultListModel();
        listElements.addElement("No Orders");
        JList orderList = new JList(listElements);
        orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPanel = new JScrollPane(orderList);
        listScrollPanel.setPreferredSize(new Dimension(500, 300));

        JButton addItem = new JButton("+ Add Item");
        JButton clearItem = new JButton("- Clear Item");

        listPanel.add(listScrollPanel);
        listPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        listPanel.add(addItem);
        listPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        listPanel.add(clearItem);
        listPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        //right side of the interface (the order details)

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setPreferredSize(new Dimension(100, 400));

        JLabel total = new JLabel();
        total.setText("Total: ");
        JLabel count = new JLabel();
        count.setText("Count: ");
        JButton button3 = new JButton();
        button3.setText("Order");
        JCheckBox delivery = new JCheckBox();
        delivery.setText("Delivery");

        detailsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailsPanel.add(total);
        detailsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailsPanel.add(count);
        detailsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailsPanel.add(delivery);
        detailsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailsPanel.add(button3);
        detailsPanel.add(Box.createRigidArea(new Dimension(20, 20)));

        mainMenu.add(listPanel, BorderLayout.WEST);
        mainMenu.add(detailsPanel, BorderLayout.EAST);

        //the pizza selection page

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        orderPanel.setPreferredSize(new Dimension(450, 400));

        JComboBox selectType = new JComboBox(pizzaType);
        JComboBox selectCrust = new JComboBox(pizzaCrust);
        JComboBox selectSauce = new JComboBox(pizzaSauce);
        JButton submitOrder = new JButton("Submit Order");

        orderPanel.add(selectType);
        orderPanel.add(selectCrust);
        orderPanel.add(selectSauce);
        orderPanel.add(submitOrder);
        pizzaMenu.add(orderPanel);

        //navigation and action listeners
        mainMenu.setVisible(true);
        pizzaMenu.setVisible(false);

        addItem.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){  
                pizzaMenu.setVisible(true);
               }    
        });

        clearItem.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){  
                orderStrings.clear();
                listElements.clear();
                total.setText("Total: $0");
                count.setText("Count: ");
                currentOrder.resetOrder();
               }    
        });

        selectType.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                System.out.println("selected " + pizzaType[selectType.getSelectedIndex()]);
                currentOrder.setType(selectType.getSelectedIndex());
               }    
        });

        selectCrust.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                System.out.println("selected " + pizzaCrust[selectCrust.getSelectedIndex()]);
                currentOrder.setCrust(selectCrust.getSelectedIndex());
               }    
        });

        selectSauce.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                System.out.println("selected " + pizzaSauce[selectSauce.getSelectedIndex()]);
                currentOrder.setSauce(selectSauce.getSelectedIndex());
               }    
        });

        submitOrder.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                orderStrings.add(currentOrder.getOrderString());
                listElements.clear();
                for(Integer x = 0; x < orderStrings.size(); x++){
                    listElements.addElement(orderStrings.get(x));
                }
                orderPrices.add(currentOrder.getPrice());
                
                Double totalPrice = 0.0;
                for(Integer x = 0; x < orderPrices.size(); x++){
                    totalPrice += orderPrices.get(x);
                }
                total.setText("Total: $" + totalPrice);
                count.setText("Count: " + orderStrings.size());
                orderPanel.repaint();  
                pizzaMenu.setVisible(false);
                selectType.setSelectedIndex(0);
                selectSauce.setSelectedIndex(0);
                selectCrust.setSelectedIndex(0);
                currentOrder.resetOrder();
            }
        });
    }
}