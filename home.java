import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class home implements ActionListener {

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, apt, doc, transact, logout;
    JPanel Panel1 = new JPanel();
    ImageIcon img;
    JLabel firstLabel, firstLabel_1, secondLabel;
    loginpage l;

    home(loginpage l) {
        this.l = l;
        // ADDING METHODS HERE
        buttons();
        label();
        panel();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(Panel1);// ADD PANEL
        F.add(firstLabel); // for the background image
        F.add(firstLabel_1); // for the first sentence
        F.add(secondLabel); // for the second sentence
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
        Home.setFont(new Font(null, Font.BOLD, 20));
        Home.setFocusable(false);

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

    public void label() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        firstLabel_1 = new JLabel("WELCOME BACK!");
        firstLabel_1.setBounds(80, 200, 900, 100);
        firstLabel_1.setFont(new Font("Constantia", Font.BOLD, 90));
        firstLabel_1.setBackground(new Color(0x000000));

        secondLabel = new JLabel("  We’re here to serve you!");
        secondLabel.setBounds(80, 300, 1000, 200);
        secondLabel.setFont(new Font("Constantia", Font.BOLD, 80));
        secondLabel.setBackground(new Color(0x000000));
    }

    public void panel() {
        // JPANEL-------------------------------------------------------------------------------------
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == apt) {
            F.dispose();
            new apt1(l);
        }
        if (e.getSource() == doc) {
            F.dispose();
            new doctor(l);
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