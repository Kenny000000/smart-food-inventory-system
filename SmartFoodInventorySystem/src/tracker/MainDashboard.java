
package tracker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDashboard extends JFrame {

    public MainDashboard() {
        setTitle("Smart Food Inventory System - Main Dashboard (SDG 12)");
        setSize(650, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(46, 125, 50));
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel lblTitle = new JLabel("Smart Food Inventory System", JLabel.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        headerPanel.add(lblTitle);
        add(headerPanel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(4, 1, 12, 12));
        menuPanel.setBorder(new EmptyBorder(25, 40, 25, 40));

        JButton btnInventory = new JButton("1. Food Inventory Management");
        JButton btnReminders = new JButton("2. Expiry Alerts and Reminders");
        JButton btnTracker = new JButton("3. Food Waste and Saving Tracker");
        JButton btnExit = new JButton("Exit Application");

        Font btnFont = new Font("Segoe UI", Font.BOLD, 13);
        btnInventory.setFont(btnFont);
        btnReminders.setFont(btnFont);
        btnTracker.setFont(btnFont);
        btnExit.setFont(btnFont);

        btnTracker.setBackground(new Color(220, 237, 200));
        btnExit.setBackground(new Color(255, 205, 210));

        menuPanel.add(btnInventory);
        menuPanel.add(btnReminders);
        menuPanel.add(btnTracker);
        menuPanel.add(btnExit);

        add(menuPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        JLabel lblFooter = new JLabel("Status: Main landing page connected and operational (SDG 12)");
        lblFooter.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        footerPanel.add(lblFooter);
        add(footerPanel, BorderLayout.SOUTH);

        btnInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainDashboard.this, 
                    "Food Inventory Management module is being integrated.", 
                    "Navigation Notice", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnReminders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainDashboard.this, 
                    "Expiry Alerts & Reminders module is being integrated.", 
                    "Navigation Notice", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnTracker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TrackerFrame().setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }
}