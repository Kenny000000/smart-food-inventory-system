package inventory;

import main.MainDashboard;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryFrame extends JFrame {
    
    //Text field for inventory data
    private JTextField txtFoodName;
    private JTextField txtQuantity;
    private JTextField txtExpiryDate;
    
    //Dropdown list for food categories
    private JComboBox<String> cmbCategory;

    //Table to display inventory items
    private JTable inventoryTable;
    
    //Constructor
    public InventoryFrame() {

        //Frame settings
        setTitle("Smart Food Inventory System - Inventory Management");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        //Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(46,125,50));

        JLabel lblTitle = new JLabel("Food Inventory Management");

        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));

        headerPanel.add(lblTitle);

        add(headerPanel, BorderLayout.NORTH);

        //Form panel on the left side
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(11,1,5,5));
        formPanel.setBorder(new EmptyBorder(20,20,20,20));

        //Create text fields
        txtFoodName = new JTextField();
        txtQuantity = new JTextField();
        txtExpiryDate = new JTextField();
           
        //Create category dropdown menu
        cmbCategory = new JComboBox<>(new String[]{
                "Fruit",
                "Vegetables",
                "Dairy",
                "Meat",
                "Drinks"
        });

        //Add labels and input fields
        formPanel.add(new JLabel("Food Name"));
        formPanel.add(txtFoodName);

        formPanel.add(new JLabel("Category"));
        formPanel.add(cmbCategory);

        formPanel.add(new JLabel("Quantity"));
        formPanel.add(txtQuantity);

        formPanel.add(new JLabel("Expiry Date"));
        formPanel.add(txtExpiryDate);

        //Buttons for inventory operations
        JButton btnAdd = new JButton("Add Item");
        JButton btnUpdate = new JButton("Update Item");
        JButton btnDelete = new JButton("Delete Item");
        JButton btnBack = new JButton("Back");
        
        
        btnBack.addActionListener(e ->{
            dispose();
            //Opens main page once back is clicked
            new MainDashboard().setVisible(true);
        });
        
        //for button to show on panel
        formPanel.add(btnAdd);
        formPanel.add(btnUpdate);
        formPanel.add(btnDelete);
        formPanel.add(btnBack);
        add(formPanel, BorderLayout.WEST);

        //Inventory table
        //Defining table column names
        String[] columns = {
                "ID",
                "Food Name",
                "Category",
                "Quantity",
                "Expiry Date",
                "Status"
        };

        //Create an empty table
        inventoryTable = new JTable(
                new Object[][]{},
                columns
        );

        //Add table inside a scroll pane
        inventoryTable.setRowHeight(25);
        JScrollPane scrollPane =
                new JScrollPane(inventoryTable);

        add(scrollPane, BorderLayout.CENTER);
        
        //Footer
        JPanel footerPanel = new JPanel();

        JLabel lblFooter = new JLabel(
           "Inventory Module - GUI Prototype"
        );

        footerPanel.add(lblFooter);

        add(footerPanel, BorderLayout.SOUTH);
    }
}
