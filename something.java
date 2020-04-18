import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Arrays;
import java.util.ArrayList; 
import java.util.List;

public class something {
    public static void main(String args[]) {
        String[] crust = {"cheeseStuffed", "original", "deepDish"};
        String[] meat = {"vegan", "chicken", "beef", "pepperoni"};
        String[] extra = {"tomato", "onion", "capsicum", "olives", "spinach", "cheese", "bacon"};
        List<String> selectedExtra = new ArrayList<String>();

        JFrame mainMenu = new JFrame();
        JFrame pizzaMenu = new JFrame();

 //       pizza order = new pizza();            Reminder: Implement the pizza object into this code

        mainMenu.setSize(430, 400);
        mainMenu.setTitle("Orders");
        mainMenu.setResizable(true);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pizzaMenu.setSize(450, 400);
        pizzaMenu.setTitle("Pick Your Pizza");
        pizzaMenu.setResizable(true);
        pizzaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setPreferredSize(new Dimension(300, 400));

        JList orderList;
        String[] orders = {"no orders"};
        orderList = new JList(orders);
        orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane orderPane = new JScrollPane(orderList);
        orderPane.setPreferredSize(new Dimension(300, 300));
        
        JButton addItem = new JButton("addItem");
        addItem.setText("+ Add Item");
        
        JButton clearItem = new JButton("clear");
        clearItem.setText("- Clear");

        listPanel.add(orderPane);
        listPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        listPanel.add(addItem);
        listPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        listPanel.add(clearItem);
        listPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setPreferredSize(new Dimension(100, 400));

        JLabel total = new JLabel();
        total.setText("Total: ");
        JLabel count = new JLabel();
        count.setText("Count: ");
        JButton submit = new JButton("Submit");
        JCheckBox delivery = new JCheckBox();
        delivery.setText("Delivery");

        detailPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailPanel.add(total);
        detailPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailPanel.add(count);
        detailPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailPanel.add(delivery);
        detailPanel.add(Box.createRigidArea(new Dimension(20, 20)));
        detailPanel.add(submit);
        detailPanel.add(Box.createRigidArea(new Dimension(20, 20)));

        mainMenu.add(listPanel, BorderLayout.WEST);
        mainMenu.add(detailPanel, BorderLayout.EAST);

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        orderPanel.setPreferredSize(new Dimension(450, 400));

        JComboBox selectCrust = new JComboBox(crust);
        JComboBox selectMeat = new JComboBox(meat);
        JComboBox selectExtra = new JComboBox(extra);
        JButton submitOrder = new JButton("Submit Order");

        orderPanel.add(selectCrust);
        orderPanel.add(selectMeat);
        orderPanel.add(selectExtra);
        orderPanel.add(submitOrder);

        pizzaMenu.add(orderPanel);

        mainMenu.setVisible(true);
        pizzaMenu.setVisible(false);

        addItem.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){  
                pizzaMenu.setVisible(true);
               }    
        });

        selectCrust.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                System.out.println("selected" + crust[selectCrust.getSelectedIndex()]);
                selectedExtra.add(crust[selectCrust.getSelectedIndex()]);
               }    
        });

        selectMeat.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                System.out.println("selected" + meat[selectMeat.getSelectedIndex()]);
                selectedExtra.add(meat[selectMeat.getSelectedIndex()]);
               }    
        });

        selectExtra.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){ 
                System.out.println("selected" + extra[selectExtra.getSelectedIndex()]);
                selectedExtra.add(extra[selectExtra.getSelectedIndex()]);
               }    
        });

        submitOrder.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                pizzaMenu.setVisible(false);
                String finalString = "";
                for(String x:selectedExtra){
                    finalString = finalString + "+" + x + "\n";
                }
                // String[] orders = Arrays.copyOf(orders, orders.length + 1);
                // orders[orders.length - 1] = finalString;
            }
        });
    }
}