import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class update implements ActionListener {
    // database
    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";
    JFrame up = new JFrame("UPDATE");
    String[] time = { "8:00 AM-10:00 AM", "1:00 PM-3:00 PM" };
    JDateChooser aptDay = new JDateChooser();
    JLabel DOALabel, timeLabel, sched;
    JComboBox<String> ROAComboBox;
    JComboBox<String> timeComboBox;
    JButton updButton, backButton;
    String selectedReason;
    private int aptID;
    loginpage l;

    update(int aptID, loginpage l) {
        this.aptID = aptID;
        this.l = l;
        func();

        up.setSize(550, 260);
        up.setLayout(null);
        up.setLocationRelativeTo(null);// DISPLAY IN MIDDLE
        up.setResizable(false);
        up.getContentPane().setBackground(new Color(0xF5f5dc));

        up.add(sched);
        up.add(updButton);
        up.add(timeComboBox);
        up.add(DOALabel);
        up.add(aptDay);
        up.add(timeLabel);
        up.setVisible(true);
    }

    public void func() {
        // schedule
        sched = new JLabel("Refer the Schedule to the Assigned Doctor");
        sched.setBounds(80, 10, 500, 30);
        sched.setFont(new Font("Sans serif", Font.BOLD, 20));
        sched.setBackground(new Color(0x000000));
        // Date of Appointment
        DOALabel = new JLabel("Consultation Date");// for date of appointment
        DOALabel.setBounds(40, 90, 500, 30);
        DOALabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        DOALabel.setBackground(new Color(0x000000));

        aptDay.setBounds(40, 120, 200, 30);
        aptDay.setFont(new Font("Arial", Font.PLAIN, 15));
        aptDay.setBackground(Color.white);
        // time
        timeComboBox = new JComboBox<>();
        timeComboBox.setEditable(true);
        timeComboBox.setBounds(250, 120, 200, 30);
        timeComboBox.setFont(new Font("Sans serif", Font.PLAIN, 16));
        timeComboBox.addItem("8:00 AM-10:00 AM");
        timeComboBox.addItem("1:00 PM-3:00 PM");

        timeLabel = new JLabel("Consultation Time");
        timeLabel.setBounds(250, 90, 500, 30);
        timeLabel.setFont(new Font("Sans serif", Font.PLAIN, 18));
        timeLabel.setBackground(new Color(0x000000));

        updButton = new JButton("UPDATE");// BUTTON 4 for update
        updButton.setBackground(new Color(0xEAE1C4));
        updButton.setForeground(new Color(0x413F3F));
        updButton.setBounds(400, 180, 120, 30);
        updButton.setFont(new Font(null, Font.BOLD, 20));
        updButton.setFocusable(false);
        updButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updButton) {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(aptDay.getDate());
            String time = (String) timeComboBox.getSelectedItem();

            if (date.isEmpty() || time.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Complete the field", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                try (Connection connection = DriverManager.getConnection(db_url, user, password);
                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE appointments SET aptDate=?,aptTime=?,book=? WHERE aptID=?")) {
                    preparedStatement.setString(1, date);
                    preparedStatement.setString(2, time);
                    preparedStatement.setObject(3, LocalDateTime.now());
                    preparedStatement.setInt(4, aptID); // Assuming aptID is the primary key of the appointment table

                    // Execute the update query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully updated!");
                        new apt1(l);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update appointment", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
