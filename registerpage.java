import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registerpage implements ActionListener {

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    // JBUTTOn
    JButton regButton = new JButton("Confirm");
    JButton LOGIN1 = new JButton("LOG IN");

    JButton Home = new JButton("Home");
    JButton Abt = new JButton("About us");
    JButton Login = new JButton("Login");
    JButton Services = new JButton("Services");
    JButton EXIT = new JButton("login");

    // JFIELD
    JTextField ContactNum = new JTextField("Contact Number");
    JTextField userName = new JTextField("Full Name");
    JTextField userIDField = new JTextField("Email");
    JPasswordField userPasswordField = new JPasswordField("Password");

    // JLABEL
    JLabel register_label = new JLabel("REGISTRATION");
    JLabel messageLabel = new JLabel("");
    JLabel firstLabel;

    // JPANEL
    JPanel Panel1 = new JPanel();
    JPanel Panel2 = new JPanel();
    // Check box
    JCheckBox passCheck;

    // image
    ImageIcon img;
    // for database
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    registerpage() {
        // database connection here
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databitz", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(registerpage.class.getName()).log(Level.SEVERE, null, ex);
        }
        // add to method
        buttons();
        frontPage();
        textType();
        labels();
        panels();

        // ADD TO
        // FRAME-------------------------------------------------------------------------------
        F.add(firstLabel);
        F.add(Panel1);// ADD PANEL
        F.add(Panel2);// ADD PANEL

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
        Home.setBounds(548, 15, 180, 70);
        Home.setFont(new Font(null, Font.PLAIN, 20));
        Home.setFocusable(false);
        Home.addActionListener(this);

        Abt = new JButton("ABOUT US");// BUTTON 6 for About Us
        Abt.setBackground(new Color(0xEAE1C4));
        Abt.setBounds(755, 15, 180, 70);
        Abt.setFont(new Font(null, Font.PLAIN, 20));
        Abt.setFocusable(false);
        Abt.addActionListener(this);

        Services = new JButton("SERVICES");// BUTTON 7 for Services
        Services.setBackground(new Color(0xEAE1C4));
        Services.setBounds(965, 15, 180, 70);
        Services.setFont(new Font(null, Font.PLAIN, 20));
        Services.setFocusable(false);
        Services.addActionListener(this);

        Login = new JButton("LOG IN");// BUTTON 5 for Login
        Login.setBackground(new Color(0xEAE1C4));
        Login.setBounds(1170, 15, 180, 70);
        Login.setFont(new Font(null, Font.BOLD, 20));
        Login.setFocusable(false);
        Login.addActionListener(this);
    }

    public void panels() {
        // JPANEL-------------------------------------------------------------------------------------
        Panel1.setBounds(0, 0, 1400, 100); // Set the bounds to cover the entire frame
        Panel1.setLayout(null);
        Panel1.add(Home);
        Panel1.add(Login);
        Panel1.add(Abt);
        Panel1.add(Services);
        Panel1.setBackground(new Color(0xFAEED1)); // Set background color to orange
        Panel1.setVisible(true);

        // JPANEL
        // 2-------------------------------------------------------------------------------------

        Panel2.setBounds(30, 110, 650, 540); // Set the bounds to cover the entire frame
        Panel2.setLayout(null);
        Panel2.add(regButton);
        Panel2.add(userIDField);
        Panel2.add(userPasswordField);
        Panel2.add(LOGIN1);
        Panel2.add(messageLabel);
        Panel2.add(register_label);
        Panel2.add(userName);
        Panel2.add(ContactNum);
        Panel2.add(passCheck);
        Panel2.setBackground(new Color(0xDED0B6)); // Set background color to orange
        Panel2.setVisible(true);
    }

    public void frontPage() {
        // JBUTTON------------------------------------------------------------------------------------
        regButton.setBounds(140, 370, 350, 50);// BUTTON 1 for Confirm
        regButton.setFocusable(false);
        regButton.addActionListener(this);
        regButton.setBackground(new Color(0xEAE4CE));
        regButton.setFont(new Font("Constantia", Font.PLAIN, 30));

        LOGIN1.setBounds(215, 430, 200, 35);// BUTTON 3 for Login
        LOGIN1.setFocusable(false);
        LOGIN1.addActionListener(this);
        LOGIN1.setBackground(new Color(0xEAE4CE));
        LOGIN1.setFont(new Font("Constantia", Font.PLAIN, 20));

    }

    public void labels() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        messageLabel.setBounds(130, 320, 300, 35);// TEXT 3 = Initials
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        register_label.setBounds(115, 10, 600, 100);// REGISTRATION
        register_label.setFont(new Font("Constantia", Font.BOLD, 55));
        register_label.setBackground(new Color(0x000000));

        passCheck = new JCheckBox("Show Password"); // showPassword
        passCheck.setBounds(120, 320, 150, 20);
        passCheck.setFont(new Font("Arial", Font.PLAIN, 16));
        passCheck.setForeground(Color.black);
        passCheck.setBackground(new Color(0xDED0B6));
        passCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passCheck.isSelected()) {
                    userPasswordField.setEchoChar((char) 0);
                } else {
                    userPasswordField.setEchoChar('•');
                }
            }

        });

    }

    public void textType() {
        // JTEXTFIELD &
        // JPASSWORD---------------------------------------------------------------------
        String in1 = "Full Name";
        userName.setColumns(20);
        userName.setBounds(120, 100, 400, 40);// USER INPUT 1
        userName.setFont(new Font("Constantia", Font.PLAIN, 20));
        userName.setBackground(new Color(0xEAE4CE));
        userName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userName.getText().equals(in1)) {
                    userName.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userName.getText().isEmpty()) {
                    userName.setText(in1);
                }
            }
        });

        String in = "Email";
        userIDField.setColumns(20);
        userIDField.setBounds(120, 160, 400, 40);// USER INPUT 2
        userIDField.setFont(new Font("Constantia", Font.PLAIN, 20));
        userIDField.setBackground(new Color(0xEAE4CE));
        userIDField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userIDField.getText().equals(in)) {
                    userIDField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userIDField.getText().isEmpty()) {
                    userIDField.setText(in);
                }
            }
        });

        String we = "Contact Number";
        ContactNum.setColumns(20);
        ContactNum.setBounds(120, 220, 400, 40);// USER INPUT 2
        ContactNum.setFont(new Font("Constantia", Font.PLAIN, 20));
        ContactNum.setBackground(new Color(0xEAE4CE));
        ContactNum.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ContactNum.getText().equals(we)) {
                    ContactNum.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ContactNum.getText().isEmpty()) {
                    ContactNum.setText(we);
                }
            }
        });

        String in2 = "Password";
        userPasswordField.setColumns(20);
        userPasswordField.setBounds(120, 280, 400, 40);// USER INPUT 3
        userPasswordField.setFont(new Font("Constantia", Font.PLAIN, 20));
        userPasswordField.setBackground(new Color(0xEAE4CE));
        userPasswordField.addFocusListener(new FocusAdapter() {
            @SuppressWarnings("deprecation")
            @Override
            public void focusGained(FocusEvent e) {
                if (userPasswordField.getText().equals(in2)) {
                    userPasswordField.setText("");
                }
            }

            @SuppressWarnings("deprecation")
            @Override
            public void focusLost(FocusEvent e) {
                if (userPasswordField.getText().isEmpty()) {
                    userPasswordField.setText(in2);
                }
            }
        });

    }

    public void confirm() {
        String fullName = userName.getText().trim();
        String emailName = userIDField.getText().trim();
        String contactNumber = ContactNum.getText().trim();
        String password = new String(userPasswordField.getPassword()).trim();

        // Placeholder texts
        String fullNamePlaceholder = "Full Name";
        String emailPlaceholder = "Email";
        String contactNumberPlaceholder = "Contact Number";
        String passwordPlaceholder = "Password";

        // Check if any field contains placeholder text
        if (fullName.equals(fullNamePlaceholder) || emailName.equals(emailPlaceholder) ||
                contactNumber.equals(contactNumberPlaceholder) || password.equals(passwordPlaceholder)) {
            JOptionPane.showMessageDialog(null, "Please complete all fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!emailName.contains("@")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else if (contactNumber.length() != 11) {
            JOptionPane.showMessageDialog(null, "Contact number must only contain 11 digits", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                PreparedStatement emailCheckStmt = con.prepareStatement("SELECT * FROM owner WHERE email = ?");
                emailCheckStmt.setString(1, emailName);
                ResultSet emailCheckResult = emailCheckStmt.executeQuery();
                if (emailCheckResult.next()) {
                    JOptionPane.showMessageDialog(null, "Email address already exists.", "TRY AGAIN!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    ps = con.prepareStatement(
                            "INSERT INTO owner(fullName, email, contactNum,password) VALUES(?,?,?,?)");
                    ps.setString(1, fullName);
                    ps.setString(2, emailName);
                    ps.setString(3, contactNumber);
                    ps.setString(4, password);

                    int k = ps.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Register Successfully!", "Successful",
                                JOptionPane.INFORMATION_MESSAGE);
                        userName.setText("");
                        userIDField.setText("");
                        userPasswordField.setText("");
                        messageLabel.setText("");
                        ContactNum.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration Failed!", "Incomplete",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "REGISTRATION ERROR!", "INCORRECT", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
        }
    }

    @SuppressWarnings({ "deprecation" })
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == regButton.getActionCommand()) {
            confirm();
        }
        if (ae.getSource() == LOGIN1) { // for log in nga naas container
            F.dispose();
            new loginpage();
        }
        if (ae.getSource() == Login) { // login sa navigation
            F.dispose();
            new loginpage();
        }
        if (ae.getSource() == Home) {
            F.dispose();
            new firstpage();
        }
    }
}
