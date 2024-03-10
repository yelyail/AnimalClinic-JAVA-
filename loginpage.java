import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class loginpage implements ActionListener {

    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";
    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");
    // JBUTTON
    JButton loginButton = new JButton("Login");
    JButton Register = new JButton("Register");
    JButton Home = new JButton("Home");
    JButton Abt = new JButton("About us");
    JButton Login = new JButton("Login");
    JButton Services = new JButton("Services");
    JButton FGP = new JButton("Forget password?");
    // JFIELD
    JTextField userIDField = new JTextField("Email");
    JPasswordField userPasswordField = new JPasswordField("Password");
    // JLABEL
    JLabel messageLabel = new JLabel("Create your Account -> ");
    JLabel login = new JLabel("LOG IN");
    JLabel firstLabel;// for picture sa iro
    // JPANEL
    JPanel Panel1 = new JPanel();
    JPanel Panel2 = new JPanel();
    // Check box
    JCheckBox passCheck;
    // Image Icon
    ImageIcon img;
    // for fetch
    int ownerID;

    Connection con;

    loginpage() {
        // add the methods
        buttons();
        frontPage();
        panels();
        textType();
        labels();
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
    }

    public void buttons() {
        // JBUTTON------------------------------------------------------------------------------------
        Home = new JButton("HOME");// BUTTON 4 for Home
        Home.setBackground(new Color(0xEAE1C4));
        Home.setBounds(748, 15, 120, 65);
        Home.setFont(new Font(null, Font.PLAIN, 20));
        Home.setFocusable(false);
        Home.addActionListener(this);

        Abt = new JButton("ABOUT US");// BUTTON 6 for About Us
        Abt.setBackground(new Color(0xEAE1C4));
        Abt.setBounds(880, 15, 160, 65);
        Abt.setFont(new Font(null, Font.PLAIN, 20));
        Abt.setFocusable(false);
        Abt.addActionListener(this);

        Services = new JButton("SERVICES");// BUTTON 7 for Services
        Services.setBackground(new Color(0xEAE1C4));
        Services.setBounds(1050, 15, 160, 65);
        Services.setFont(new Font(null, Font.PLAIN, 20));
        Services.setFocusable(false);

        Login = new JButton("LOG IN");// BUTTON 5 for Login
        Login.setBackground(new Color(0xEAE1C4));
        Login.setBounds(1220, 15, 120, 65);
        Login.setFont(new Font(null, Font.BOLD, 20));
        Login.setFocusable(false);
        Login.addActionListener(this);
    }

    public void frontPage() {
        // JBUTTON-----------------------------------------------------------------------------------
        loginButton.setBounds(140, 370, 350, 50);// BUTTON 1 for Login
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(0xEAE4CE));
        loginButton.setFont(new Font("Constantia", Font.PLAIN, 30));

        Register.setBounds(330, 510, 100, 20);// BUTTON 3 for Register
        Register.setFocusable(false);
        Register.addActionListener(this);
        Register.setBackground(new Color(0xDED0B6));
        Register.setFont(new Font("Constantia", Font.PLAIN, 15));

        FGP.setBounds(220, 430, 200, 30);// BUTTON 4 for Forget Password
        FGP.setFocusable(false);
        FGP.addActionListener(this);
        FGP.setBackground(new Color(0xDED0B6));
        FGP.setFont(new Font("Constantia", Font.PLAIN, 15));

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

    public void panels() {
        // JPANEL
        // 1-------------------------------------------------------------------------------------
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

        Panel2.setBounds(100, 110, 650, 540); // Set the bounds to cover the entire frame
        Panel2.setLayout(null);
        Panel2.add(Register);
        Panel2.add(userIDField);
        Panel2.add(userPasswordField);
        Panel2.add(loginButton);
        Panel2.add(messageLabel);
        Panel2.add(login);
        Panel2.add(FGP);
        Panel2.add(passCheck);
        Panel2.setBackground(new Color(0xDED0B6)); // Set background color to orange
        Panel2.setVisible(true);
    }

    public void textType() {
        // JTEXTFIELD &
        // JPASSWORD---------------------------------------------------------------------
        String in = "Email";
        userIDField.setColumns(20);
        userIDField.setBounds(120, 170, 400, 40);// USER INPUT 1
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
        String in1 = "Password";
        userPasswordField.setColumns(20);
        userPasswordField.setBounds(120, 270, 400, 40);// USER INPUT 2
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

    public void labels() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        messageLabel.setBounds(170, 500, 300, 35);// TEXT 3 = Initials
        messageLabel.setFont(new Font(null, Font.PLAIN, 15));

        login.setBounds(225, 10, 600, 100);// LOG IN
        login.setFont(new Font("Constantia", Font.BOLD, 55));
        login.setBackground(new Color(0x000000));
    }

    @Override
    public void actionPerformed(ActionEvent W1) {
        if (W1.getSource() == Home) { // HOME BUTTON
            F.dispose();
            new firstpage();
        }
        if (W1.getSource() == Abt) { // About us BUTTON
            F.dispose();
            new aboutUS();
        }
        if (W1.getSource() == Services) { // Services BUTTON
            F.dispose();
            new services();
        }
        if (W1.getSource() == Register) { // REGISTER BUTTON
            F.dispose();
            new registerpage();
        }
        if (W1.getSource() == FGP) { // forgot password BUTTON
            F.dispose();
            new forgotpass();
        }
        if (W1.getSource() == loginButton) { // LOGIN BUTTON
            String email = userIDField.getText().trim(); // Trim to remove leading/trailing spaces
            String password = userPasswordField.getText().trim();

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please complete all fields.", "ERROR!",
                        JOptionPane.ERROR_MESSAGE);
                return; // Stop further execution
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(db_url, user, password);
                Statement st = con.createStatement();
                String s1 = "SELECT * from owner where email='" + userIDField.getText() + "' and password= '"
                        + userPasswordField.getText() + "'";
                ResultSet rs = st.executeQuery(s1);

                if (rs.next()) {
                    ownerID = rs.getInt("ownerID"); // Retrieve the ownerID from the ResultSet
                    JOptionPane.showMessageDialog(null, "Log in successfully...", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    userIDField.setText("");
                    userPasswordField.setText("");
                    messageLabel.setText("");
                    F.dispose();
                    new home(this);

                } else {
                    JOptionPane.showMessageDialog(null, "Email or Password incorrect!", "ERROR!",
                            JOptionPane.ERROR_MESSAGE);
                    userIDField.setText("Email");
                    userPasswordField.setText("Password");
                    userIDField.requestFocusInWindow();
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

}
