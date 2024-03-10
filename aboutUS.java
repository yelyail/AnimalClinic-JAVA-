import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class aboutUS implements ActionListener {

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, Abt, Login, Services, one, two;
    JPanel Panel1, yel, ron, ralph, judd;
    ImageIcon img, yel_1_1, ron_1_1, ralph_1_1, judd_1_1;
    JLabel firstLabel, members;
    JLabel yel_1, ron_1, ralph_1, judd_1;

    aboutUS() {
        // ADDING METHODS HERE
        buttons();
        panel();
        members();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(Panel1);// ADD PANEL
        F.add(yel);
        F.add(yel_1);
        F.add(ron);
        F.add(ron_1);
        F.add(ralph);
        F.add(ralph_1);
        F.add(judd);
        F.add(judd_1);
        F.add(firstLabel);
        F.add(one);
        F.add(two);
        F.add(members);
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

    public void members() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        members = new JLabel("M E M B E R S");
        members.setForeground(Color.BLACK);
        members.setFont(new Font("Constantia", Font.BOLD, 100));
        members.setBounds(400, 100, 800, 150);
        // -------------------------------------------------------------------------------------------
        yel = new JPanel();
        yel.setBounds(160, 250, 200, 200);
        yel.setLayout(null);
        yel.setBackground(new Color(0xb48768));

        yel_1_1 = new ImageIcon("\\C:\\Users\\Acer\\Downloads\\firstPage\\firstPage\\1.jpg\\");
        yel_1 = new JLabel();
        yel_1.setIcon(yel_1_1);
        yel_1.setBounds(25, 30, 150, 150);
        yel.add(yel_1);

        yel_1 = new JLabel("Ariel July Traje");
        yel_1.setForeground(Color.BLACK);
        yel_1.setFont(new Font("Constantia", Font.PLAIN, 20));
        yel_1.setBounds(200, 440, 200, 100);
        // ------------------------------------------------------------------------------
        ron = new JPanel();
        ron.setBounds(400, 250, 200, 200);
        ron.setLayout(null);
        ron.setBackground(new Color(0xb48768));

        ron_1_1 = new ImageIcon("C:/Users/Acer/Downloads/firstPage/firstPage/2.png");
        ron_1 = new JLabel();
        ron_1.setIcon(ron_1_1);
        ron_1.setBounds(25, 30, 150, 150);
        ron.add(ron_1);

        ron_1 = new JLabel("Ron Vergel Luzon");
        ron_1.setForeground(Color.BLACK);
        ron_1.setFont(new Font("Constantia", Font.PLAIN, 20));
        ron_1.setBounds(426, 440, 200, 100);
        // ------------------------------------------------------------------------------
        ralph = new JPanel();
        ralph.setBounds(640, 250, 200, 200);
        ralph.setLayout(null);
        ralph.setBackground(new Color(0xb48768));

        ralph_1_1 = new ImageIcon("\\C:\\Users\\Acer\\Downloads\\firstPage\\firstPage\\ralph.png\\");
        ralph_1 = new JLabel();
        ralph_1.setIcon(ralph_1_1);
        ralph_1.setBounds(25, 30, 150, 150);
        ralph.add(ralph_1);

        ralph_1 = new JLabel("Ralph Joseph Quiñones");
        ralph_1.setForeground(Color.BLACK);
        ralph_1.setFont(new Font("Constantia", Font.PLAIN, 19));
        ralph_1.setBounds(643, 440, 200, 100);
        // ------------------------------------------------------------------------------
        judd = new JPanel();
        judd.setBounds(880, 250, 200, 200);
        judd.setLayout(null);
        judd.setBackground(new Color(0xb48768));

        judd_1_1 = new ImageIcon("C:/Users/Acer/Downloads/firstPage/firstPage/3.png");
        judd_1 = new JLabel();
        judd_1.setIcon(judd_1_1);
        judd_1.setBounds(25, 30, 150, 150);
        judd.add(judd_1);

        judd_1 = new JLabel("");
        judd_1.setForeground(Color.BLACK);
        judd_1.setFont(new Font("Constantia", Font.PLAIN, 20));
        judd_1.setBounds(895, 440, 200, 100);
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
        Abt.setFont(new Font(null, Font.BOLD, 20));
        Abt.setFocusable(false);

        Services = new JButton("SERVICES");// BUTTON 7 for Services
        Services.setBackground(new Color(0xEAE1C4));
        Services.setBounds(1050, 15, 160, 65);
        Services.setFont(new Font(null, Font.PLAIN, 20));
        Services.setFocusable(false);
        Services.addActionListener(this);

        Login = new JButton("LOG IN");// BUTTON 5 for Login
        Login.setBackground(new Color(0xEAE1C4));
        Login.setBounds(1220, 15, 120, 65);
        Login.setFont(new Font(null, Font.PLAIN, 20));
        Login.setFocusable(false);
        Login.addActionListener(this);

        one = new JButton("1");// for one
        one.setBackground(new Color(0xEAE1C4));
        one.setBounds(610, 580, 70, 70);
        one.setFont(new Font(null, Font.PLAIN, 40));
        one.setFocusable(false);
        one.addActionListener(this);

        two = new JButton("2");// for two
        two.setBackground(new Color(0xEAE1C4));
        two.setBounds(710, 580, 70, 70);
        two.setFont(new Font(null, Font.BOLD, 40));
        two.setFocusable(false);
    }

    public void panel() {
        // JPANEL-------------------------------------------------------------------------------------
        Panel1 = new JPanel();
        Panel1.setBounds(0, 0, 1400, 100); // Set the bounds to cover the entire frame
        Panel1.setLayout(null);
        Panel1.add(Home);
        Panel1.add(Login);
        Panel1.add(Abt);
        Panel1.add(Services);
        Panel1.setBackground(new Color(0xFAEED1)); // Set background color to orange
        Panel1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Home) {
            F.dispose();
            new firstpage();
        }
        if (e.getSource() == Services) {
            F.dispose();
            new services();
        }
        if (e.getSource() == one) {
            F.dispose();
            new aboutUS_1();
        }
        if (e.getSource() == Login) {
            F.dispose();
            new loginpage();
        }
    }
}