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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class doctor implements ActionListener {

    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";
    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, apt, doc, transact, logout, searchButton;
    JPanel Panel1, Panel2;
    ImageIcon img, searchIcon;
    JLabel firstLabel, secondLabel, sched;
    JTable tbl;
    JScrollPane pane;
    JTextField searchField;
    Connection con;
    PreparedStatement preparedStatement;
    loginpage l;
    String[] columns = { "Fullname", "Available Schedule", "Contact number", "Email", "Specialization" };

    doctor(loginpage l) {
        this.l = l;
        // ADDING METHODS HERE
        buttons();
        label();
        panel();
        table();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(searchField);
        F.add(searchButton);
        F.add(Panel1);// ADD PANEL
        F.add(secondLabel); // for label sa appointmet
        F.getContentPane().add(pane);// for the table
        F.add(firstLabel);// for picture
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
        apt.setFont(new Font(null, Font.PLAIN, 19));
        apt.setFocusable(false);
        apt.addActionListener(this);

        doc = new JButton("DOCTORS");// BUTTON for doctors
        doc.setBackground(new Color(0xEAE1C4));
        doc.setBounds(828, 15, 160, 65);
        doc.setFont(new Font(null, Font.BOLD, 20));
        doc.setFocusable(false);

        transact = new JButton("TRANSACTION");// BUTTON for transaction
        transact.setBackground(new Color(0xEAE1C4));
        transact.setBounds(1000, 15, 180, 65);
        transact.setFont(new Font(null, Font.PLAIN, 19));
        transact.setFocusable(false);
        transact.addActionListener(this);

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

        secondLabel = new JLabel("DOCTORS INFORMATION");
        secondLabel.setBounds(450, 100, 900, 120);
        secondLabel.setFont(new Font("Constantia", Font.BOLD, 40));
        secondLabel.setBackground(new Color(0x000000));

        searchField = new JTextField();
        searchField.setBounds(1000, 190, 200, 20);
        searchField.setFont(new Font("Constantia", Font.PLAIN, 14));
        searchField.setBackground(new Color(0xFFFFE0));

        searchButton = new JButton();// BUTTON for search
        searchButton.setBackground(new Color(0xEAE1C4));
        searchButton.setBounds(1200, 190, 20, 20);
        searchButton.setFont(new Font(null, Font.PLAIN, 20));
        searchButton.setFocusable(false);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchDoc(searchField.getText());
            }
        });
        searchIcon = new ImageIcon("C:/Users/Acer/Downloads/firstPage/seach.png");
        searchButton.setIcon(searchIcon);
    }

    private void searchDoc(String specia) {
        try (Connection connection = DriverManager.getConnection(db_url, user, password)) {
            String sql = "SELECT * FROM doctor WHERE Specialization LIKE ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + specia + "%");
            ResultSet rs = preparedStatement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl.getModel();
            model.setRowCount(0);

            if (rs.next()) {
                do {
                    String docName = rs.getString("docName");
                    String availSched = rs.getString("availSched");
                    String contactNum = rs.getString("contactNum");
                    String cEmail = rs.getString("cEmail");
                    String specialization = rs.getString("Specialization");

                    Object[] row = { docName, availSched, contactNum, cEmail, specialization };
                    model.addRow(row);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No doctor found with this specific services ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while searching for doctors: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        tbl.setModel(model);
        tbl.setBackground(new Color(0xDED0B6));
        tbl.setForeground(Color.black);
        tbl.setSelectionBackground(new Color(0xF5F5FA));
        tbl.setGridColor(new Color(0x1F1C1C));
        tbl.setSelectionForeground(new Color(0x1F1C1C));
        tbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tbl.setRowHeight(30);
        tbl.setAutoCreateRowSorter(true);

        pane = new JScrollPane(tbl);
        pane.setForeground(new Color(0x1F1F29));
        pane.setBackground(new Color(0xDED0B6));
        pane.setBounds(100, 210, 1200, 340);

        JTableHeader tHeader = tbl.getTableHeader();
        tHeader.setBackground(new Color(0x13131A));
        tHeader.setForeground(new Color(0xF5F5FA));
        tHeader.setFont(new Font("Tahoma", Font.BOLD, 20));

        try (Connection connection = DriverManager.getConnection(db_url, user, password)) {
            String query = "SELECT docName, availSched, contactNum, cEmail, Specialization FROM doctor";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String docName = resultSet.getString("docName");
                    String availSched = resultSet.getString("availSched");
                    String contactNum = resultSet.getString("contactNum");
                    String cEmail = resultSet.getString("cEmail");
                    String specialization = resultSet.getString("Specialization");

                    Object[] row = { docName, availSched, contactNum, cEmail, specialization };
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data from database: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Home) {
            F.dispose();
            new home(l);
        }
        if (e.getSource() == apt) {
            F.dispose();
            new apt1(l);
        }
        if (e.getSource() == transact) {
            F.dispose();
            new transaction(l);
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