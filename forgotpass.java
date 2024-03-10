import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class forgotpass implements ActionListener {

    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";
    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");
    // JBUTTOn
    JButton confirmButton = new JButton("Confirm");
    JButton BACK = new JButton("BACK");

    JButton Home = new JButton("Home");
    JButton Abt = new JButton("About us");
    JButton Login = new JButton("Login");
    JButton Services = new JButton("Services");
    JButton EXIT = new JButton("login");

    // JFIELD
    JTextField userIDField = new JTextField("Email");
    JPasswordField userPasswordField = new JPasswordField("New Password");
    JLabel captchaLabel;
    JTextField captchaField = new JTextField();
    private String captcha;
    // JLABEL
    JLabel register = new JLabel("RESET PASSWORD");
    JLabel messageLabel = new JLabel("");
    JLabel firstLabel;
    JLabel emailLabel, passwordLabel;

    // JPANEL
    JPanel Panel1 = new JPanel();
    JPanel Panel2 = new JPanel();
    // Check box
    JCheckBox passCheck;
    // image
    ImageIcon img;
    Connection con;

    forgotpass() {
        // add method
        buttons();
        panels();
        textType();
        frontPage();
        labels();
        // ADD TO
        // FRAME-------------------------------------------------------------------------------
        F.add(firstLabel);// for picture
        F.add(passCheck);// show password
        F.add(captchaLabel); // captcha label
        F.add(emailLabel);// for email label
        F.add(passwordLabel);// for password label
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
        Panel2.add(confirmButton);
        Panel2.add(userIDField);
        Panel2.add(userPasswordField);
        Panel2.add(BACK);
        Panel2.add(register);
        Panel2.add(captchaField);
        Panel2.setBackground(new Color(0xDED0B6)); // Set background color to orange
        Panel2.setVisible(true);

    }

    public void frontPage() {
        // JBUTTON------------------------------------------------------------------------------------
        captcha = generateCaptcha();

        captchaLabel = new JLabel("CAPTCHA: " + captcha);
        captchaLabel.setBounds(150, 330, 500, 20);//
        captchaLabel.setFont(new Font("Constantia", Font.BOLD, 17));
        captchaLabel.setBackground(new Color(0x000000));

        captchaField.setBounds(120, 240, 400, 40);// for captch text field
        captchaField.setFont(new Font("Constantia", Font.PLAIN, 20));
        captchaField.setBackground(new Color(0xEAE4CE));

        confirmButton.setBounds(140, 400, 350, 50);// CONFIRM BUTTOn
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);
        confirmButton.setBackground(new Color(0xEAE4CE));
        confirmButton.setFont(new Font("Constantia", Font.PLAIN, 30));

        BACK.setBounds(215, 460, 200, 35);// BACK BUTTON
        BACK.setFocusable(false);
        BACK.addActionListener(this);
        BACK.setBackground(new Color(0xEAE4CE));
        BACK.setFont(new Font("Constantia", Font.PLAIN, 20));

        passCheck = new JCheckBox("Show Password"); // showPassword
        passCheck.setBounds(150, 470, 150, 20);
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

    private static String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 6) {
            int index = (int) (rnd.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public void labels() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        messageLabel.setBounds(130, 280, 300, 35);//
        messageLabel.setFont(new Font("Constantia", Font.ITALIC, 20));

        register.setBounds(80, 5, 600, 100);//
        register.setFont(new Font("Constantia", Font.BOLD, 50));
        register.setBackground(new Color(0x000000));

        emailLabel = new JLabel("EMAIL");
        emailLabel.setBounds(150, 250, 500, 20);//
        emailLabel.setFont(new Font("Constantia", Font.BOLD, 17));
        emailLabel.setBackground(new Color(0x000000));

        passwordLabel = new JLabel("NEW PASSWORD");
        passwordLabel.setBounds(150, 410, 500, 20);//
        passwordLabel.setFont(new Font("Constantia", Font.BOLD, 17));
        passwordLabel.setBackground(new Color(0x000000));
    }

    public void textType() {
        // JTEXTFIELD &
        // JPASSWORD---------------------------------------------------------------------
        String in = "Email";
        userIDField.setColumns(20);
        userIDField.setBounds(120, 160, 400, 40);// USER INPUT 1
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

        String in1 = "New Password";
        userPasswordField.setColumns(20);
        userPasswordField.setBounds(120, 320, 400, 40);// USER INPUT 2
        userPasswordField.setFont(new Font("Constantia", Font.PLAIN, 20));
        userPasswordField.setBackground(new Color(0xEAE4CE));
        userPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userPasswordField.getText().equals(in1)) {
                    userPasswordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userPasswordField.getText().isEmpty()) {
                    userPasswordField.setText(in1);
                }
            }
        });
    }

    @SuppressWarnings({ "deprecation" })
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirmButton) {
            if (captchaField.getText().equals(captcha)) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(db_url, user, password);

                    Statement st = con.createStatement();
                    String selectQuery = "SELECT * FROM owner WHERE email='" + userIDField.getText() + "'";
                    ResultSet rs = st.executeQuery(selectQuery);

                    if (rs.next()) {
                        String updateQuery = "UPDATE owner SET password='"
                                + new String(userPasswordField.getPassword()) + "' WHERE email='"
                                + userIDField.getText() + "'";
                        int rowsAffected = st.executeUpdate(updateQuery);

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Password updated successfully.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            userIDField.setText("");
                            userPasswordField.setText("");
                            messageLabel.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update password.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // If no matching record found, display error message
                        JOptionPane.showMessageDialog(null, "Email not found!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                        userIDField.setText("");
                        captchaField.setText("");
                        userPasswordField.setText("");
                        userIDField.requestFocusInWindow();
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid CAPTCHA! Please try again.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                captcha = generateCaptcha();

                captchaLabel.setText("CAPTCHA: " + captcha);

                captchaField.setText("");
            }
        }

        if (ae.getSource() == BACK) {
            F.dispose();
            new loginpage();
        }
        if (ae.getSource() == Login) {
            F.dispose();
            new loginpage();
        }
        if (ae.getSource() == Home) {
            F.dispose();
            new firstpage();

        }
    }
}
