import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class aboutUS_1 implements ActionListener {

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");

    JButton Home, Abt, Login, Services, one, two;
    JPanel Panel1, firstPanel, secondPanel;
    ImageIcon img;
    static JLabel firstLabel, aboutus, secondLabel;
    static JTextArea firstTextArea, secondTextArea;

    aboutUS_1() {
        // ADDING METHODS HERE
        buttons();
        panel();
        about_us();
        // ADD TOFRAME----------------------
        F.add(Panel1);// ADD PANEL
        F.add(firstPanel);
        F.add(secondPanel);
        F.add(firstLabel);
        F.add(one);
        F.add(two);
        F.add(aboutus);
        // FRAME SETUP----------------------------------
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setSize(1400, 700);
        F.setLayout(null);
        F.setLocationRelativeTo(null);// DISPLAY IN MIDDLE
        F.setResizable(false);
        F.getContentPane().setBackground(new Color(0xF5f5dc));
        F.setVisible(true);
        // --------------------------------------------------------------------------------------------
    }

    public void about_us() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        aboutus = new JLabel("ABOUT US");
        aboutus.setForeground(Color.BLACK);
        aboutus.setFont(new Font("Constantia", Font.BOLD, 100));
        aboutus.setBounds(470, 100, 800, 150);

        firstPanel = new JPanel();
        firstPanel.setBounds(50, 210, 600, 350);
        firstPanel.setLayout(null);
        firstPanel.setBackground(new Color(0xC6B680));

        secondPanel = new JPanel();
        secondPanel.setBounds(750, 210, 600, 350);
        secondPanel.setLayout(null);
        secondPanel.setBackground(new Color(0xEAE1C4));

        firstTextArea = new JTextArea(
                "At LOVING CARE ANIMAL CLINIC, we take pleasure in offering excellent veterinary care with a compassionate touch. "
                        + "Our professional doctors and caring staff are committed to your pets well-being and health. "
                        + "We understand that each pet is an important part of the family and deserves the best possible care and attention. "
                        + "From the minute you and your canine partner walk through our doors, you can expect to be greeted with love, care, and greatest respect.");
        firstTextArea.setEditable(false); // Make the text area read-only
        firstTextArea.setLineWrap(true); // Enable line wrapping
        firstTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        firstTextArea.setBackground(new Color(0xC6B680));
        firstTextArea.setForeground(Color.BLACK);
        firstTextArea.setFont(new Font("Arial", Font.PLAIN, 25));
        firstTextArea.setBounds(10, 20, 570, 300);
        firstPanel.add(firstTextArea);
        // ------------------------------------------------------------------------------------------------
        secondLabel = new JLabel("G O A L S");
        secondLabel.setForeground(Color.BLACK);
        secondLabel.setFont(new Font("Constantia", Font.BOLD, 60));
        secondLabel.setBounds(180, 10, 300, 80);

        secondTextArea = new JTextArea(
                "Our top priority is to offer outstanding veterinary care with a compassionate touch."
                        + "We are committed to the well-being and health of every pet entrusted to us, viewing them as "
                        + "valued members of the family. We strive hard to make sure that every visit to our clinic is filled "
                        + "with compassion, knowledge, and a genuine concern for our beloved companions' health and happiness.");
        secondTextArea.setEditable(false);
        secondTextArea.setLineWrap(true);
        secondTextArea.setWrapStyleWord(true);
        secondTextArea.setBackground(new Color(0xEAE1C4));
        secondTextArea.setForeground(Color.BLACK);
        secondTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        secondTextArea.setBounds(10, 90, 570, 240);
        secondPanel.add(secondLabel);
        secondPanel.add(secondTextArea);
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
        one.setFont(new Font(null, Font.BOLD, 40));
        one.setFocusable(false);

        two = new JButton("2");// for two
        two.setBackground(new Color(0xEAE1C4));
        two.setBounds(710, 580, 70, 70);
        two.setFont(new Font(null, Font.PLAIN, 40));
        two.setFocusable(false);
        two.addActionListener(this);
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
        if (e.getSource() == two) {
            F.dispose();
            new aboutUS();
        }
        if (e.getSource() == Login) {
            F.dispose();
            new loginpage();
        }
    }
}