import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class services implements ActionListener {

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, Abt, Login, Services, one, two;
    JPanel Panel1, first, second, third, fourth, fifth, six;
    ImageIcon img, first_1_1, second_1_1, third_1_1, fourth_1_1, fifth_1_1, six_1_1;
    JLabel firstLabel, serve, first_1_1_1, second_1_1_1, third_1_1_1, fourth_1_1_1, fifth_1_1_1, six_1_1_1;
    JTextArea first_1, second_1, third_1, fourth_1, fifth_1, six_1;

    services() {
        // ADDING METHODS HERE
        buttons();
        panel();
        service();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(Panel1);// ADD PANEL
        F.add(serve);
        F.add(first);
        F.add(first_1);
        F.add(second);
        F.add(second_1);
        F.add(third);
        F.add(third_1);
        F.add(fourth);
        F.add(fourth_1);
        F.add(fifth);
        F.add(fifth_1);
        F.add(six);
        F.add(six_1);
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

    public void service() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        serve = new JLabel("S E R V I C E S");
        serve.setForeground(Color.BLACK);
        serve.setFont(new Font("Constantia", Font.BOLD, 80));
        serve.setBounds(470, 100, 800, 100);
        // -----------------------------------------------------------------------------------------------
        first = new JPanel();
        first.setBounds(10, 240, 200, 200);
        first.setLayout(null);
        first.setBackground(new Color(0xFAEED1));

        first_1_1 = new ImageIcon("\\C:\\Users\\Acer\\OneDrive\\Desktop\\IT 6\\s1.png\\");
        first_1_1_1 = new JLabel();// label
        first_1_1_1.setIcon(first_1_1);// label
        first_1_1_1.setBounds(25, 30, 150, 150);// label
        first.add(first_1_1_1);// add the label

        first_1 = new JTextArea("BATHING AND \n" + "  GROOMING");
        first_1.setEditable(false);
        first_1.setLineWrap(true);
        first_1.setWrapStyleWord(true);
        first_1.setForeground(Color.BLACK);
        first_1.setFont(new Font("Arial", Font.BOLD, 20));
        first_1.setBackground(new Color(0xF5f5dc));
        first_1.setBounds(40, 440, 150, 50);
        // -----------------------------------------------------------------------------------------------
        second = new JPanel();
        second.setBounds(240, 240, 200, 200);
        second.setLayout(null);
        second.setBackground(new Color(0xFAEED1));

        second_1_1 = new ImageIcon("\\C:\\Users\\Acer\\OneDrive\\Desktop\\IT 6\\s2.png\\");
        second_1_1_1 = new JLabel();// label
        second_1_1_1.setIcon(second_1_1);// label
        second_1_1_1.setBounds(25, 30, 150, 150);// label
        second.add(second_1_1_1);// add the label

        second_1 = new JTextArea("ANESTHESIA");
        second_1.setEditable(false);
        second_1.setLineWrap(true);
        second_1.setWrapStyleWord(true);
        second_1.setForeground(Color.BLACK);
        second_1.setFont(new Font("Arial", Font.BOLD, 20));
        second_1.setBackground(new Color(0xF5f5dc));
        second_1.setBounds(270, 440, 150, 50);

        // -----------------------------------------------------------------------------------------------
        third = new JPanel();
        third.setBounds(470, 240, 200, 200);
        third.setLayout(null);
        third.setBackground(new Color(0xFAEED1));

        third_1_1 = new ImageIcon("\\C:\\Users\\Acer\\OneDrive\\Desktop\\IT 6\\s3.png\\");
        third_1_1_1 = new JLabel();// label
        third_1_1_1.setIcon(third_1_1);// label
        third_1_1_1.setBounds(25, 30, 150, 150);// label
        third.add(third_1_1_1);// add the label

        third_1 = new JTextArea("FOOD SAFETY");
        third_1.setEditable(false);
        third_1.setLineWrap(true);
        third_1.setWrapStyleWord(true);
        third_1.setForeground(Color.BLACK);
        third_1.setFont(new Font("Arial", Font.BOLD, 20));
        third_1.setBackground(new Color(0xF5f5dc));
        third_1.setBounds(500, 440, 150, 50);
        // -----------------------------------------------------------------------------------------------
        fourth = new JPanel();
        fourth.setBounds(700, 240, 200, 200);
        fourth.setLayout(null);
        fourth.setBackground(new Color(0xFAEED1));

        fourth_1_1 = new ImageIcon("\\C:\\Users\\Acer\\OneDrive\\Desktop\\IT 6\\s4.png\\");
        fourth_1_1_1 = new JLabel();// label
        fourth_1_1_1.setIcon(fourth_1_1);// label
        fourth_1_1_1.setBounds(25, 30, 150, 150);// label
        fourth.add(fourth_1_1_1);// add the label

        fourth_1 = new JTextArea("PET SURGERY");
        fourth_1.setEditable(false);
        fourth_1.setLineWrap(true);
        fourth_1.setWrapStyleWord(true);
        fourth_1.setForeground(Color.BLACK);
        fourth_1.setFont(new Font("Arial", Font.BOLD, 20));
        fourth_1.setBackground(new Color(0xF5f5dc));
        fourth_1.setBounds(730, 440, 150, 50);
        // -----------------------------------------------------------------------------------------------
        fifth = new JPanel();
        fifth.setBounds(930, 240, 200, 200);
        fifth.setLayout(null);
        fifth.setBackground(new Color(0xFAEED1));

        fifth_1_1 = new ImageIcon("\\C:\\Users\\Acer\\OneDrive\\Desktop\\IT 6\\s5.png\\");
        fifth_1_1_1 = new JLabel();// label
        fifth_1_1_1.setIcon(fifth_1_1);// label
        fifth_1_1_1.setBounds(25, 30, 150, 150);// label
        fifth.add(fifth_1_1_1);// add the label

        fifth_1 = new JTextArea("DIAGNOSTIC AND \n   THERAPEUTIC \n    SERVICES");
        fifth_1.setEditable(false);
        fifth_1.setLineWrap(true);
        fifth_1.setWrapStyleWord(true);
        fifth_1.setForeground(Color.BLACK);
        fifth_1.setFont(new Font("Arial", Font.BOLD, 20));
        fifth_1.setBackground(new Color(0xF5f5dc));
        fifth_1.setBounds(940, 440, 180, 90);
        // -----------------------------------------------------------------------------------------------
        six = new JPanel();
        six.setBounds(1160, 240, 200, 200);
        six.setLayout(null);
        six.setBackground(new Color(0xFAEED1));

        six_1_1 = new ImageIcon("\\C:\\Users\\Acer\\OneDrive\\Desktop\\IT 6\\s6.png\\");
        six_1_1_1 = new JLabel();// label
        six_1_1_1.setIcon(six_1_1);// label
        six_1_1_1.setBounds(25, 30, 150, 150);// label
        six.add(six_1_1_1);// add the label

        six_1 = new JTextArea("DOG TRAINING");
        six_1.setEditable(false);
        six_1.setLineWrap(true);
        six_1.setWrapStyleWord(true);
        six_1.setForeground(Color.BLACK);
        six_1.setFont(new Font("Arial", Font.BOLD, 20));
        six_1.setBackground(new Color(0xF5f5dc));
        six_1.setBounds(1190, 440, 150, 50);
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
        Services.setFont(new Font(null, Font.BOLD, 20));
        Services.setFocusable(false);

        Login = new JButton("LOG IN");// BUTTON 5 for Login
        Login.setBackground(new Color(0xEAE1C4));
        Login.setBounds(1220, 15, 120, 65);
        Login.setFont(new Font(null, Font.PLAIN, 20));
        Login.setFocusable(false);
        Login.addActionListener(this);
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
        if (e.getSource() == Abt) {
            F.dispose();
            new aboutUS_1();
        }
        if (e.getSource() == Login) {
            F.dispose();
            new loginpage();
        }
    }
}