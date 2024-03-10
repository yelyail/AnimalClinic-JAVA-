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

import com.toedter.calendar.JDateChooser;

import java.sql.Statement;

public class apt1 implements ActionListener {

    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";
    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");
    JButton Home, apt, doc, transact, logout, plus, editBTn, deleteBtn, searchButton;
    JPanel Panel1, Panel2;
    ImageIcon img, searchIcon;
    JLabel firstLabel, secondLabel, sched;
    JTable tbl;
    JScrollPane pane;
    String[] columns = { "Appointment #", "Pet Name", "Species", "Doctor Name", "Specialization", "Available Schedule",
            "Service", "Reason for Appointment", "Schedule Date", "Schedule Time", "Book Date" };
    DefaultTableModel model;
    // this is for update function
    JFrame up = new JFrame("UPDATE");
    String[] species = { "Dog", "Cat", "Rabbit", "Guinea Pig", "Hamster", "Bird", "Snake", "Rodents" };
    String[] time = { "8:00 AM-10:00 AM", "1:00 PM-3:00 PM" };
    JDateChooser aptDay = new JDateChooser();
    JLabel ROALabel, serviceLabel, doctorLabel, availableLabel, DOALabel, timeLabel;
    JComboBox<String> docComboBox;
    JComboBox<String> ROAComboBox;
    JComboBox<String> timeComboBox;
    JTextField serviceField, availSchedField, searchField;
    JButton updButton;
    String selectedReason;
    loginpage l;

    apt1(loginpage l) {
        this.l = l;
        // ADDING METHODS HERE
        buttons();
        label();
        panel();
        table();
        updateTable();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(searchButton);
        F.add(searchField);
        F.add(pane);
        F.add(plus);
        F.add(sched);
        F.add(secondLabel);
        F.add(editBTn);
        F.add(deleteBtn);
        F.add(Panel1);// ADD PANEL
        F.add(firstLabel); // for the background image
        // FRAME SET
        // UP-------------------------------------------------------------------------------
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
        apt.setFont(new Font(null, Font.BOLD, 19));
        apt.setFocusable(false);

        doc = new JButton("DOCTORS");// BUTTON for doctors
        doc.setBackground(new Color(0xEAE1C4));
        doc.setBounds(828, 15, 160, 65);
        doc.setFont(new Font(null, Font.PLAIN, 20));
        doc.setFocusable(false);
        doc.addActionListener(this);

        transact = new JButton("TRANSACTION");// BUTTON for transaction
        transact.setBackground(new Color(0xEAE1C4));
        transact.setBounds(1000, 15, 180, 65);
        transact.setFont(new Font(null, Font.PLAIN, 19));
        transact.setFocusable(false);
        transact.addActionListener(this);

        logout = new JButton("LOG OUT");// BUTTON for logout
        logout.setBackground(new Color(0xEAE1C4));
        logout.setBounds(1190, 15, 180, 65);
        logout.setFont(new Font(null, Font.PLAIN, 20));
        logout.setFocusable(false);
        logout.addActionListener(this);
    }

    public void updateTable() {
        editBTn = new JButton("UPDATE");// BUTTON for edit
        editBTn.setBackground(new Color(0x4CAF50));
        editBTn.setBounds(1160, 210, 95, 30);
        editBTn.setFont(new Font(null, Font.BOLD, 14));
        editBTn.setFocusable(false);
        editBTn.addActionListener(this);

        deleteBtn = new JButton("CANCEL");// BUTTON for delete
        deleteBtn.setBackground(new Color(0xF44336));
        deleteBtn.setBounds(1262, 210, 95, 30);
        deleteBtn.setFont(new Font(null, Font.BOLD, 14));
        deleteBtn.setFocusable(false);
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbl.getSelectedRow();

                if (selectedRow != -1) { // If a row is selected
                    int res = JOptionPane.showConfirmDialog(null, "Are you sure to cancel the appointment?", "TITLE",
                            JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        int aptID = (int) tbl.getValueAt(selectedRow, 0);
                        deleteTable(aptID);
                        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
                        model.removeRow(selectedRow);
                    }
                }
            }
        });
    }

    public void deleteTable(int aptID) {
        try (Connection connection = DriverManager.getConnection(db_url, user, password)) {
            String query = "DELETE FROM appointments WHERE aptID=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, aptID);
                preparedStatement.executeUpdate(); // Execute the delete query
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void label() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        secondLabel = new JLabel("APPOINTMENT INFORMATION");
        secondLabel.setBounds(420, 100, 900, 120);
        secondLabel.setFont(new Font("Constantia", Font.BOLD, 40));
        secondLabel.setBackground(new Color(0x000000));

        sched = new JLabel("SCHEDULE");
        sched.setBounds(70, 175, 300, 40);
        sched.setFont(new Font("Arial", Font.BOLD, 20));
        sched.setBackground(new Color(0x000000));

        plus = new JButton("+");// BUTTON for schedule
        plus.setBackground(new Color(0xEAE1C4));
        plus.setBounds(10, 170, 50, 50);
        plus.setFont(new Font(null, Font.BOLD, 20));
        plus.setFocusable(false);
        plus.addActionListener(this);

        searchField = new JTextField();
        searchField.setBounds(935, 220, 200, 20);
        searchField.setFont(new Font("Constantia", Font.PLAIN, 14));
        searchField.setBackground(new Color(0xFFFFE0));

        searchButton = new JButton();// BUTTON 4 for search
        searchButton.setBackground(new Color(0xEAE1C4));
        searchButton.setBounds(1135, 220, 20, 20);
        searchButton.setFont(new Font(null, Font.PLAIN, 20));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                searchByPetName(searchTerm);
            }
        });
        searchIcon = new ImageIcon("C:/Users/Acer/Downloads/firstPage/seach.png");
        searchButton.setIcon(searchIcon);

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

    public void searchByPetName(String searchTerm) {
        model.setRowCount(0); // Clear the table before populating with search results
        try (Connection connection = DriverManager.getConnection(db_url, user, password)) {
            String query = "SELECT a.aptID, an.petName, an.species, d.docName, d.Specialization, d.availSched, s.serviceName, "
                    + "s.description, a.aptDate, a.aptTime, a.book "
                    + "FROM appointments a "
                    + "INNER JOIN animals an ON a.animalsID = an.animalsID "
                    + "INNER JOIN docservice ds ON a.docserviceID = ds.docserviceID "
                    + "INNER JOIN doctor d ON ds.docID = d.docID "
                    + "INNER JOIN service s ON ds.serviceID = s.serviceID "
                    + "WHERE an.petName LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchTerm + "%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getInt("aptID"),
                            rs.getString("petName"),
                            rs.getString("species"),
                            rs.getString("docName"),
                            rs.getString("Specialization"),
                            rs.getString("availSched"),
                            rs.getString("serviceName"),
                            rs.getString("description"),
                            rs.getDate("aptDate"),
                            rs.getString("aptTime"),
                            rs.getString("book")
                    };
                    model.addRow(row);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void table() {
        tbl = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        tbl.setModel(model);
        tbl.setBackground(new Color(0xF5f5dc));
        tbl.setForeground(Color.black);
        tbl.setSelectionBackground(new Color(0xEAE1C4));
        tbl.setGridColor(Color.BLACK);
        tbl.setSelectionForeground(new Color(0x222222));
        tbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tbl.setRowHeight(40);
        tbl.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl.setDefaultRenderer(Object.class, centerRenderer);

        pane = new JScrollPane(tbl);
        pane.setForeground(Color.black);
        pane.setBackground(new Color(0xF5f5dc));
        pane.setBounds(10, 250, 1350, 350);

        JTableHeader tHeader = tbl.getTableHeader();
        tHeader.setBackground(Color.BLACK);
        tHeader.setForeground(Color.white);
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 15));

        try (Connection connection = DriverManager.getConnection(db_url, user, password)) {
            Statement stmt = connection.createStatement();
            String query = "SELECT a.aptID, an.petName,an.species, d.docName, d.Specialization,d.availSched, s.serviceName,"
                    +
                    "s.description, a.aptDate, a.aptTime,a.book " +
                    "FROM appointments a " +
                    "INNER JOIN animals an ON a.animalsID = an.animalsID " +
                    "INNER JOIN docservice ds ON a.docserviceID = ds.docserviceID " +
                    "INNER JOIN doctor d ON ds.docID = d.docID " +
                    "INNER JOIN service s ON ds.serviceID = s.serviceID";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                            rs.getInt("aptID"),
                            rs.getString("petName"),
                            rs.getString("species"),
                            rs.getString("docname"),
                            rs.getString("specialization"),
                            rs.getString("availSched"),
                            rs.getString("serviceName"),
                            rs.getString("description"),
                            rs.getDate("aptDate"),
                            rs.getString("aptTime"),
                            rs.getString("book")
                    };
                    model.addRow(row);
                } // Close resources
                rs.close();
                stmt.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        if (e.getSource() == transact) {
            F.dispose();
            new transaction(l);
        }
        if (e.getSource() == plus) {
            new book(l);
        }
        if (e.getSource() == editBTn) {
            int selectedRow = tbl.getSelectedRow();
            if (selectedRow != -1) { // If a row is selected
                int aptID = (int) tbl.getValueAt(selectedRow, 0); // Get the aptID from the selected row
                new update(aptID, l); // Pass the aptID to the update constructor
            } else {
                JOptionPane.showMessageDialog(null, "Please select an appointment to update", "Error",
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
