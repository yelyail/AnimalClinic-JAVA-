import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class transaction implements ActionListener {
    // database
    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, apt, doc, transact, logout, plus, printBtn;
    JPanel Panel1, Panel2;
    ImageIcon img;
    JLabel firstLabel, secondLabel, sched;
    JTable tbl;
    JScrollPane pane;
    loginpage l;

    transaction(loginpage l) {
        // ADDING METHODS HERE
        buttons();
        label();
        panel();
        table();
        // ADD_TOFRAME-------------------------------------------------------------------------------
        F.add(printBtn);
        F.add(Panel1);// ADD PANEL
        F.add(secondLabel); // for label sa appointmet
        F.getContentPane().add(pane);// for the table
        F.add(firstLabel);// for picture
        // FRAME
        // SET_UP-------------------------------------------------------------------------------
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setSize(1400, 700);
        F.setLayout(null);
        F.setLocationRelativeTo(null);// DISPLAY IN MIDDLE
        F.setResizable(false);
        F.getContentPane().setBackground(new Color(0xF5f5dc));
        F.setVisible(true);
        // --------------------------------------------------------------------------------------------
    }

    public void buttons() {
        // JBUTTON------------------------------------------------------------------------------------
        Home = new JButton("HOME");// BUTTON 4 for Home
        Home.setBackground(new Color(0xEAE1C4));
        Home.setBounds(500, 15, 120, 65);
        Home.setFont(new Font(null, Font.PLAIN, 20));
        Home.setFocusable(false);
        Home.addActionListener(this);

        apt = new JButton("APPOINTMENT");// BUTTON for appointment
        apt.setBackground(new Color(0xEAE1C4));
        apt.setBounds(634, 15, 180, 65);
        apt.setFont(new Font(null, Font.PLAIN, 19));
        apt.setFocusable(false);
        apt.addActionListener(this);

        doc = new JButton("DOCTORS");// BUTTON for doctors
        doc.setBackground(new Color(0xEAE1C4));
        doc.setBounds(828, 15, 160, 65);
        doc.setFont(new Font(null, Font.PLAIN, 20));
        doc.setFocusable(false);
        doc.addActionListener(this);

        transact = new JButton("TRANSACTION");// BUTTON for transaction
        transact.setBackground(new Color(0xEAE1C4));
        transact.setBounds(1000, 15, 180, 65);
        transact.setFont(new Font(null, Font.BOLD, 19));
        transact.setFocusable(false);

        logout = new JButton("LOG OUT");// BUTTON for transaction
        logout.setBackground(new Color(0xEAE1C4));
        logout.setBounds(1190, 15, 180, 65);
        logout.setFont(new Font(null, Font.PLAIN, 20));
        logout.setFocusable(false);
        logout.addActionListener(this);
    }

    public void label() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        secondLabel = new JLabel("TRANSACTION HISTORY");
        secondLabel.setBounds(420, 100, 900, 120);
        secondLabel.setFont(new Font("Constantia", Font.BOLD, 40));
        secondLabel.setBackground(new Color(0x000000));

        // for print Button
        printBtn = new JButton("PRINT");// BUTTON for delete
        printBtn.setBackground(new Color(0xF6F5DC));
        printBtn.setBounds(1262, 210, 95, 30);
        printBtn.setFont(new Font(null, Font.BOLD, 14));
        printBtn.setFocusable(false);
        printBtn.addActionListener(this);
    }

    public void panel() {
        // JPANEL-------------------------------------------------------------------------------------
        Panel1 = new JPanel();
        Panel1.setBounds(0, 0, 1400, 100); // Set the bounds to cover the entire frame
        Panel1.setLayout(null);
        Panel1.add(Home);
        Panel1.add(apt);
        Panel1.add(doc);
        Panel1.add(transact);
        Panel1.add(logout);
        Panel1.setBackground(new Color(0xFAEED1)); // Set background color to orange
        Panel1.setVisible(true);
    }

    public void table() {
        tbl = new JTable();
        String[] columns = { "Transaction #", "Services", "Description", "Date", "Time", "Cashier", "Amount" };
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        tbl.setModel(model);
        tbl.setBackground(new Color(0xDED0B6));
        tbl.setForeground(Color.black);
        tbl.setSelectionBackground(new Color(0xEAE1C4));
        tbl.setGridColor(Color.BLACK);
        tbl.setSelectionForeground(Color.WHITE);
        tbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tbl.setRowHeight(30);
        tbl.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl.setDefaultRenderer(Object.class, centerRenderer);

        pane = new JScrollPane(tbl);
        pane.setForeground(Color.black);
        pane.setBackground(new Color(0xDED0B6));
        pane.setBounds(10, 250, 1350, 400);

        JTableHeader tHeader = tbl.getTableHeader();
        tHeader.setBackground(Color.BLACK);
        tHeader.setForeground(Color.white);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 15));

        String query = "SELECT t.transactID, e.empName AS cashier, a.aptID, a.aptDate, t.transtime, " +
                "t.totalAmount, s.serviceName, s.description " +
                "FROM transaction t " +
                "INNER JOIN employee e ON t.empID = e.empID " +
                "INNER JOIN appointments a ON t.aptID = a.aptID " +
                "INNER JOIN docservice ds ON a.docserviceID = ds.docserviceID " +
                "INNER JOIN doctor d ON ds.docID = d.docID " +
                "INNER JOIN service s ON ds.serviceID = s.serviceID " +
                "ORDER BY a.aptDate DESC";

        try (Connection connection = DriverManager.getConnection(db_url, user, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("transactID"),
                            rs.getString("serviceName"),
                            rs.getString("description"),
                            rs.getString("aptDate"),
                            rs.getString("transtime"),
                            rs.getString("cashier"),
                            "₱ " + rs.getDouble("totalAmount")
                    };
                    System.out.println();
                    model.addRow(rowData);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to fetch transaction data:" + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Home) {
            F.dispose();
            new home(l);
        }
        if (e.getSource() == doc) {
            F.dispose();
            new doctor(l);
        }
        if (e.getSource() == apt) {
            F.dispose();
            new apt1(l);
        }
        if (e.getSource() == printBtn) {
            int selectedRow = tbl.getSelectedRow();
            if (selectedRow != -1) { // If a row is selected
                int transactID = (int) tbl.getValueAt(selectedRow, 0);
                new invoices(transactID);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a transaction to print", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == logout) {
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Logout Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.out.println("LOG OUT SUCCESSFULLY");
                System.exit(0);
            }
        }
    }
}