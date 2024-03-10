import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class firstpage implements ActionListener {

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, Abt, Login, Services;
    JPanel Panel1 = new JPanel();
    ImageIcon img;
    JLabel firstLabel, secondLabel, secondLabel_1, thirdLabel, thirdLabel_1, bookAppointment;

    firstpage() {
        // ADDING METHODS HERE
        buttons();
        label();
        panel();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(Panel1);// ADD PANEL
        F.add(bookAppointment);// ADD buttons for the frame
        F.add(firstLabel); // ADD label for the frame
        F.add(secondLabel);// ADD label for the frame
        F.add(secondLabel_1);// ADD label for the frame
        F.add(thirdLabel);// ADD label for the frame
        F.add(thirdLabel_1);// ADD label for the frame
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
        Home.setBounds(748, 15, 120, 65);
        Home.setFont(new Font(null, Font.BOLD, 20));
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
        Services.addActionListener(this);

        Login = new JButton("LOG IN");// BUTTON 5 for Login
        Login.setBackground(new Color(0xEAE1C4));
        Login.setBounds(1220, 15, 120, 65);
        Login.setFont(new Font(null, Font.PLAIN, 20));
        Login.setFocusable(false);
        Login.addActionListener(this);
    }

    public void label() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        secondLabel = new JLabel("Welcome to LOVING");
        secondLabel.setBounds(50, 150, 900, 100);
        secondLabel.setFont(new Font("Constantia", Font.BOLD, 55));
        secondLabel.setBackground(new Color(0x000000));

        secondLabel_1 = new JLabel("CARE ANIMAL CLINIC,");
        secondLabel_1.setBounds(50, 210, 900, 100);
        secondLabel_1.setFont(new Font("Constantia", Font.BOLD, 55));
        secondLabel_1.setBackground(new Color(0x000000));

        thirdLabel = new JLabel("Where Compassionate");
        thirdLabel.setBounds(65, 270, 900, 130);
        thirdLabel.setFont(new Font("Constantia", Font.PLAIN, 55));
        thirdLabel.setBackground(new Color(0x000000));

        thirdLabel_1 = new JLabel("Care Meets Expertise");
        thirdLabel_1.setBounds(70, 330, 900, 130);
        thirdLabel_1.setFont(new Font("Constantia", Font.PLAIN, 55));
        thirdLabel_1.setBackground(new Color(0x000000));

        // book appointment
        bookAppointment = new JLabel("BOOK AN APPOINTMENT");// label for appointments
        bookAppointment.setBackground(new Color(0xFAEED1));
        bookAppointment.setBounds(350, 460, 460, 80);
        bookAppointment.setFont(new Font(null, Font.BOLD, 36));
        bookAppointment.setOpaque(true);
    }

    public void panel() {
        // JPANEL-------------------------------------------------------------------------------------
        Panel1.setBounds(0, 0, 1400, 100); // Set the bounds to cover the entire frame
        Panel1.setLayout(null);
        Panel1.add(Home);
        Panel1.add(Login);
        Panel1.add(Abt);
        Panel1.add(Services);
        Panel1.setBackground(new Color(0xFAEED1)); // Set background color to orange
        Panel1.setVisible(true);
    }

    public static void main(String[] args) {
        new firstpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Abt) {
            F.dispose();
            new aboutUS_1();
        }
        if (e.getSource() == Services) {
            F.dispose();
            new services();
        }
        if (e.getSource() == Login) {
            F.dispose();
            new loginpage();
        }
    }
}