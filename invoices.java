import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class invoices {
    // database
    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";
    JFrame F = new JFrame("OFFICIAL RECEIPT");

    // JPANEL
    JPanel Panel1 = new JPanel();

    // JLABEL
    JLabel ID, To, From, Total, PetName, rece, name, address, refe, head, Logo, DATI;
    JLabel ID1, To1, PetName1, From1;
    JLabel Total1 = new JLabel("Total amount : " + Total);

    ImageIcon logo;
    JTable tbl;
    JScrollPane pane;
    private int transactID;

    invoices(int transactID) {
        this.transactID = transactID;
        labels();
        panels();
        table();
        // ADD TO
        // FRAME-------------------------------------------------------------------------------
        F.add(Logo);
        F.add(name);
        F.add(address);
        F.add(Total1);
        F.getContentPane().add(pane);// for the table
        F.add(Panel1);

        // FRAME SET
        // UP-------------------------------------------------------------------------------
        F.setSize(400, 700);
        F.setLayout(null);
        F.setLocationRelativeTo(null); // DISPLAY IN MIDDLE
        F.setResizable(false);
        F.getContentPane().setBackground(Color.decode("#e0d3d3"));
        F.setVisible(true);

        // --------------------------------------------------------------------------------------------
    }

    public void panels() {
        // JPANEL-------------------------------------------------------------------------------------
        Panel1.setBounds(0, 75, 400, 500); // Set the bounds to cover the entire frame
        Panel1.setLayout(null);
        Panel1.add(ID1);
        Panel1.add(To1);
        Panel1.add(From1);
        Panel1.add(PetName1);
        Panel1.add(DATI);
        Panel1.setBackground(Color.decode("#f2d8d8"));
        Panel1.setVisible(true);
    }

    public void labels() {
        // JLABEL-------------------------------------------------------------------------------------
        logo = new ImageIcon("C:\\Users\\Acer\\Downloads\\firstPage\\firstPage\\logo_1.png");
        Logo = new JLabel();
        Logo.setIcon(logo);
        Logo.setBounds(10, 2, 80, 70);

        name = new JLabel();
        name.setText("LOVING CARE ANIMAL CLINIC");
        name.setForeground(Color.black);
        name.setFont(new Font("Monospaced", Font.BOLD, 18));
        name.setBounds(95, 5, 500, 30);

        address = new JLabel();
        address.setText("Matina, Davao City");
        address.setForeground(Color.black);
        address.setFont(new Font("Monospaced", Font.PLAIN, 16));
        address.setBounds(135, 25, 300, 30);

        ID1 = new JLabel();
        ID1.setBounds(10, 5, 400, 20);
        ID1.setFont(new Font("Monospaced", Font.PLAIN, 12));

        To1 = new JLabel("Payment Method: Cash");
        To1.setBounds(10, 25, 400, 20);
        To1.setFont(new Font("Monospaced", Font.PLAIN, 12));

        PetName1 = new JLabel();
        PetName1.setBounds(10, 45, 400, 20);
        PetName1.setFont(new Font("Monospaced", Font.PLAIN, 12));

        From1 = new JLabel();
        From1.setBounds(10, 65, 400, 20);
        From1.setFont(new Font("Monospaced", Font.PLAIN, 12));
        try {
            Connection connection = DriverManager.getConnection(db_url, user, password);
            String sql = "SELECT a.petName, t.transactID, e.empName " +
                    "FROM Transaction t " +
                    "JOIN appointments ap ON t.aptID = ap.aptID " +
                    "JOIN animals a ON ap.animalsID = a.animalsID " +
                    "JOIN employee e ON t.empID = e.empID " +
                    "WHERE t.transactID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, transactID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int transactionID = resultSet.getInt("transactID");
                String petName = resultSet.getString("petName");
                String employee = resultSet.getString("empName");

                ID1.setText("Invoice ID    : " + transactionID);
                PetName1.setText("Pet Name      : " + petName);
                From1.setText("Cashier       : " + employee);
            } else {
                System.out.println("Pet Name not found for transaction ID: ");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Total1.setBounds(150, 600, 400, 20);
        Total1.setFont(new Font("Arial", Font.BOLD, 18));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        DATI = new JLabel("Date/Time     : " + formattedDateTime);
        DATI.setBounds(10, 85, 400, 20);
        DATI.setFont(new Font("Monospaced", Font.PLAIN, 12));
    }

    public void table() {
        tbl = new JTable() {
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                return new MultiLineTableCellRenderer();
            }
        };
        String[] columns = { "Service", "Description", "Amount" };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        JTableHeader tHeader = tbl.getTableHeader();
        tHeader.setBackground(Color.decode("#beccd4"));
        tHeader.setForeground(Color.decode("#000000"));
        tHeader.setFont(new Font("Arial", Font.BOLD, 20));

        tbl.setModel(model);
        tbl.setBackground(new Color(0xe0d3d3));
        tbl.setForeground(Color.black);
        tbl.setSelectionBackground(new Color(0xEAE1C4));
        tbl.setGridColor(Color.BLACK);
        tbl.setSelectionForeground(Color.WHITE);
        tbl.setFont(new Font("Arial", Font.PLAIN, 18));
        tbl.setRowHeight(50);
        tbl.setAutoCreateRowSorter(true);

        pane = new JScrollPane(tbl);
        pane.setForeground(Color.black);
        pane.setBackground(new Color(0xDED0B6));
        pane.setBounds(7, 190, 370, 400);
        double totalAmount = 0.00;
        try (Connection conn = DriverManager.getConnection(db_url, user, password)) {
            String sql = "SELECT s.serviceName, s.description, t.totalAmount " +
                    "FROM transaction t " +
                    "INNER JOIN appointments a ON t.aptID = a.aptID " +
                    "INNER JOIN docservice ds ON a.docServiceID = ds.docServiceID " +
                    "INNER JOIN doctor d ON ds.docID = d.docID " +
                    "INNER JOIN service s ON ds.serviceID = s.serviceID " +
                    "WHERE t.transactID = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, transactID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String serviceName = resultSet.getString("serviceName").trim();
                        String description = resultSet.getString("description").trim();
                        double amount = resultSet.getDouble("totalAmount");
                        totalAmount += amount;

                        String amt = String.format("₱ %.2f", amount);
                        model.addRow(new Object[] { serviceName, description, amt });
                    }
                    String ttlAmt = String.format("₱ %.2f", totalAmount);
                    Total1.setText("Total Amount: " + ttlAmt);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {
        public MultiLineTableCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setText(value == null ? "" : value.toString());
            return this;
        }
    }

}