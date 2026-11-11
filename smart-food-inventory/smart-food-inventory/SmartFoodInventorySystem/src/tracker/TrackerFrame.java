package tracker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TrackerFrame extends JFrame {
    private JTextField txtItemName, txtAmount;
    private JComboBox<String> cbImpactType;
    private JTable customTable;
    private DefaultTableModel tableModel;
    private JLabel lblStatus;

    public TrackerFrame() {
        setTitle("Smart Food Waste & Saving Tracker - Hai Anh Unit");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(46, 125, 50));
        headerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel lblTitle = new JLabel("SDG 12: Food Waste Reduction & Saving Tracker", JLabel.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        headerPanel.add(lblTitle, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel formGrid = new JPanel(new GridLayout(4, 2, 8, 8));
        
        formGrid.add(new JLabel("Food / Ingredient Name:"));
        txtItemName = new JTextField();
        formGrid.add(txtItemName);

        formGrid.add(new JLabel("Impact Classification:"));
        cbImpactType = new JComboBox<>(new String[]{"Wasted Food", "Saved / Reused Food"});
        formGrid.add(cbImpactType);

        formGrid.add(new JLabel("Quantity (kg / Portion):"));
        txtAmount = new JTextField();
        formGrid.add(txtAmount);

        formGrid.add(new JLabel("Recorded Date:"));
        JLabel lblDateVal = new JLabel(LocalDate.now().toString());
        lblDateVal.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        formGrid.add(lblDateVal);

        mainPanel.add(formGrid, BorderLayout.NORTH);

        String[] columns = {"ID", "Food Description", "Status / Impact", "Amount", "Date Logged"};
        tableModel = new DefaultTableModel(columns, 0);
        customTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(customTable);
        mainPanel.add(tableScroll, BorderLayout.CENTER);

        lblStatus = new JLabel(" Status: Ready to log tracking data...");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        mainPanel.add(lblStatus, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        
        JButton btnInsert = new JButton("Log Entry");
        JButton btnRemove = new JButton("Remove Selected");
        JButton btnSummary = new JButton("Generate Impact Report");
        JButton btnClose = new JButton("Return to Menu");

        btnInsert.setBackground(new Color(56, 142, 60));
        btnInsert.setForeground(Color.WHITE);
        btnClose.setBackground(new Color(198, 40, 40));
        btnClose.setForeground(Color.WHITE);

        actionPanel.add(btnInsert);
        actionPanel.add(btnRemove);
        actionPanel.add(btnSummary);
        actionPanel.add(btnClose);

        add(actionPanel, BorderLayout.SOUTH);

        btnInsert.addActionListener(new ActionListener() {
            int counter = 1;
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtItemName.getText().trim();
                String impact = (String) cbImpactType.getSelectedItem();
                String amount = txtAmount.getText().trim();

                if (!name.isEmpty() && !amount.isEmpty()) {
                    tableModel.addRow(new Object[]{
                        "TRK-" + (100 + counter++),
                        name,
                        impact,
                        amount + " kg",
                        LocalDate.now().toString()
                    });
                    txtItemName.setText("");
                    txtAmount.setText("");
                    lblStatus.setText(" Status: Successfully recorded new entry!");
                } else {
                    JOptionPane.showMessageDialog(TrackerFrame.this, "Please enter both food name and quantity!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = customTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                    lblStatus.setText(" Status: Selected log entry removed.");
                } else {
                    JOptionPane.showMessageDialog(TrackerFrame.this, "Please select a row from the table to remove.", "Notice", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalRows = tableModel.getRowCount();
                JOptionPane.showMessageDialog(TrackerFrame.this, 
                    "=== SUSTAINABILITY IMPACT REPORT ===\nTotal Tracked Entries: " + totalRows + "\nAligned with UN SDG 12 Goals.", 
                    "Impact Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrackerFrame().setVisible(true);
            }
        });
    }
}