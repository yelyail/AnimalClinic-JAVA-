import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class book implements ActionListener {
    static final String db_url = "jdbc:mysql://localhost:3306/databitz";
    static final String user = "root";
    static final String password = "";

    JFrame F = new JFrame("LOVING CARE ANIMAL CLINIC");
    JButton Home, apt, doc, transact, logout, bookButton, backButton;
    JPanel Panel1, Panel2, Panel3;
    ImageIcon img;
    JLabel firstLabel, firstLabel_1, secondLabel, spec, ROALabel, bday, gender_Label, breedN, petLabel, serviceLabel,
            doctorLabel, availableLabel, DOALabel, timeLabel;
    JTextField petName, breedName, availSchedField, serviceField;
    String[] species = { "Dog", "Cat", "Rabbit", "Guinea Pig", "Hamster", "Bird", "Snake", "Rodents" };
    JComboBox speciesComboBox, reasons, genderBox;
    String[] gender_1 = { "Female", "Male" };
    JDateChooser date_of_birth = new JDateChooser();
    JDateChooser aptDay = new JDateChooser();
    JComboBox<String> docComboBox;
    JComboBox<String> ROAComboBox;
    JComboBox<String> timeComboBox;
    String selectedReason;
    String doctorInfo;
    String selectDoc;
    String selectedSpecies;
    loginpage l;

    book(loginpage l) {
        this.l = l;
        // ADDING METHODS HERE
        buttons();
        label();
        panel();
        // ADD
        // TOFRAME-------------------------------------------------------------------------------
        F.add(Panel1);// ADD PANEL
        F.add(Panel2);
        F.add(Panel3); // Add Panel3 before the buttons
        F.add(bookButton);
        F.add(backButton);
        F.add(firstLabel); // for the background image
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
        Home.setFont(new Font(null, Font.PLAIN, 20));
        Home.setFocusable(false);

        apt = new JButton("APPOINTMENT");// BUTTON for appointment
        apt.setBackground(new Color(0xEAE1C4));
        apt.setBounds(634, 15, 180, 65);
        apt.setFont(new Font(null, Font.BOLD, 19));
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

        logout = new JButton("LOG OUT");// BUTTON for log out
        logout.setBackground(new Color(0xEAE1C4));
        logout.setBounds(1190, 15, 180, 65);
        logout.setFont(new Font(null, Font.PLAIN, 20));
        logout.setFocusable(false);
        logout.addActionListener(this);

        bookButton = new JButton("BOOK");// BUTTON for book
        bookButton.setBackground(new Color(0xD9C889));
        bookButton.setForeground(new Color(0x413F3F));
        bookButton.setBounds(1050, 570, 150, 50);
        bookButton.setFont(new Font(null, Font.BOLD, 20));
        bookButton.setFocusable(false);
        bookButton.addActionListener(this);

        backButton = new JButton("BACK");// BUTTON for BACK
        backButton.setBackground(new Color(0xD9C889));
        backButton.setForeground(new Color(0x413F3F));
        backButton.setBounds(1210, 570, 150, 50);
        backButton.setFont(new Font(null, Font.BOLD, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
    }

    public void label() {
        // JLABEL-------------------------------------------------------------------------------------
        img = new ImageIcon("C:/Users/Acer/OneDrive/Desktop/IT 6/bg.png"); // picture for bg
        firstLabel = new JLabel();
        firstLabel.setIcon(img);
        firstLabel.setBounds(970, 40, 700, 700);

        firstLabel_1 = new JLabel("BOOK AN APPOINTMENT");
        firstLabel_1.setBounds(30, 2, 500, 50);
        firstLabel_1.setFont(new Font("Sans Serif", Font.BOLD, 35));
        firstLabel_1.setBackground(new Color(0x000000));

        connectfirstPanel();
    }

    public void connectfirstPanel() {
        petName = new JTextField("");
        petName.setColumns(20);
        petName.setBounds(40, 110, 410, 50);
        petName.setFont(new Font("Arial", Font.PLAIN, 20));

        petLabel = new JLabel("Pet's Name");
        petLabel.setBounds(40, 40, 900, 100);
        petLabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        petLabel.setBackground(new Color(0x000000));

        // birtdhay---------------------
        date_of_birth.setBounds(40, 300, 410, 50);
        date_of_birth.setFont(new Font("Sans serif", Font.PLAIN, 20));

        bday = new JLabel("Birthdate");
        bday.setBounds(40, 230, 900, 100);
        bday.setFont(new Font("Sans serif", Font.PLAIN, 20));
        bday.setBackground(new Color(0x000000));
        // gender
        genderBox = new JComboBox<>(gender_1);
        genderBox.setEditable(true);
        genderBox.setBounds(40, 200, 410, 50);
        genderBox.setFont(new Font("Sans serif", Font.PLAIN, 20));

        gender_Label = new JLabel("Gender");
        gender_Label.setBounds(40, 130, 900, 100);
        gender_Label.setFont(new Font("Sans serif", Font.PLAIN, 20));
        gender_Label.setBackground(new Color(0x000000));

        // speciesss
        speciesComboBox = new JComboBox<>(species);
        speciesComboBox.setEditable(true);
        speciesComboBox.setBounds(40, 400, 200, 50);
        speciesComboBox.setFont(new Font("Arial", Font.PLAIN, 20));

        spec = new JLabel("Species");// for species textfield
        spec.setBounds(40, 330, 900, 100);
        spec.setFont(new Font("Sans serif", Font.PLAIN, 20));
        spec.setBackground(new Color(0x000000));
        // breed--------------------------------------------------
        breedN = new JLabel("Breed Name");// for breedname textfield
        breedN.setBounds(250, 330, 900, 100);
        breedN.setFont(new Font("Sans serif", Font.PLAIN, 20));
        breedN.setBackground(new Color(0x000000));

        breedName = new JTextField("");
        breedName.setColumns(20);
        breedName.setBounds(250, 400, 200, 50);
        breedName.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public void connectSecondPanel() {
        // reason of appointment
        ROAComboBox = new JComboBox<>();
        ROAComboBox.setEditable(true);
        ROAComboBox.setBounds(40, 115, 410, 40);
        ROAComboBox.setFont(new Font("Sans serif", Font.PLAIN, 20));
        ROAComboBox.addItem("Bathing, Brushing, and Nail Trimming");
        ROAComboBox.addItem("Prevention of Matting and Skin Issues");
        ROAComboBox.addItem("Nutritional Consultations");
        ROAComboBox.addItem("Surgical Interventions for emergency and scheduled medical needs");
        ROAComboBox.addItem("Basic obedience training for puppies or newly adopted dogs");
        ROAComboBox.addItem("X-rays, blood tests, or urinalysis to identify health issues");
        ROAComboBox.addItem("Weight Management");
        ROAComboBox.addItem("Dental Cleanings, Tooth Extractions, or injuries in pets");
        ROAComboBox.addItem("Pet is Exhibiting signs of illness, injury, or discomfort");
        ROAComboBox.addItem("Behavioral Issues such as excessive barking, jumping, and aggression");
        ROAComboBox.addItem("Pets get sick or hurt and need surgery to get better like broken bones");

        ROAComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fetchDoctorNames();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        ROALabel = new JLabel("Purpose of Consultation");
        ROALabel.setBounds(40, 70, 900, 50);
        ROALabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        ROALabel.setBackground(new Color(0x000000));

        // service
        serviceLabel = new JLabel("Service Name");
        serviceLabel.setBounds(40, 150, 900, 50);
        serviceLabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        serviceLabel.setBackground(new Color(0x000000));

        serviceField = new JTextField("");
        serviceField.setColumns(20);
        serviceField.setBounds(40, 190, 410, 50);
        serviceField.setFont(new Font("Arial", Font.PLAIN, 20));
        serviceField.setEditable(false);
        // doctor
        docComboBox = new JComboBox<>();
        docComboBox.setEditable(true);
        docComboBox.setBounds(40, 280, 410, 40);
        docComboBox.setFont(new Font("Sans serif", Font.PLAIN, 20));
        docComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedDoctor = (String) docComboBox.getSelectedItem();
                    String availabilityQuery = "SELECT d.availSched " +
                            "FROM doctor d " +
                            "WHERE d.docName = ?";

                    try (Connection connection = DriverManager.getConnection(db_url, user, password);
                            PreparedStatement avail = connection.prepareStatement(availabilityQuery)) {

                        avail.setString(1, selectedDoctor);

                        try (ResultSet availRes = avail.executeQuery()) {
                            if (availRes.next()) {
                                // Update the availSchedField with the availability of the selected doctor
                                String availSched = availRes.getString("availSched");
                                availSchedField.setText(availSched);
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        doctorLabel = new JLabel("Doctor Name");
        doctorLabel.setBounds(40, 235, 900, 50);
        doctorLabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        doctorLabel.setBackground(new Color(0x000000));

        // available Schedule
        availableLabel = new JLabel("Available Schedule" + "\n");// for available sched
        availableLabel.setBounds(40, 310, 900, 50);
        availableLabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        availableLabel.setBackground(new Color(0x000000));

        availSchedField = new JTextField("");
        availSchedField.setColumns(20);
        availSchedField.setBounds(40, 360, 410, 50);
        availSchedField.setFont(new Font("Arial", Font.PLAIN, 20));
        availSchedField.setEditable(false);
        // Date of Appointment
        DOALabel = new JLabel("Consultation Date");// for date of appointment
        DOALabel.setBounds(40, 400, 900, 50);
        DOALabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        DOALabel.setBackground(new Color(0x000000));

        aptDay.setBounds(40, 450, 200, 50);
        aptDay.setFont(new Font("Arial", Font.PLAIN, 15));
        aptDay.setBackground(Color.white);
        // time

        timeComboBox = new JComboBox<>();
        timeComboBox.setEditable(true);
        timeComboBox.setBounds(250, 450, 200, 50);
        timeComboBox.setFont(new Font("Sans serif", Font.PLAIN, 20));
        timeComboBox.addItem("8:00 AM-10:00 AM");
        timeComboBox.addItem("1:00 PM-3:00 PM");

        timeLabel = new JLabel("Consultation Time");
        timeLabel.setBounds(250, 400, 900, 50);
        timeLabel.setFont(new Font("Sans serif", Font.PLAIN, 20));
        timeLabel.setBackground(new Color(0x000000));
        // adding panels
        Panel3.add(serviceField);
        Panel3.add(availSchedField);
        Panel3.add(docComboBox);
        Panel3.add(timeComboBox);
        Panel3.add(timeLabel);
        Panel3.add(availableLabel);
        Panel3.add(DOALabel);
        Panel3.add(aptDay);
        Panel3.add(doctorLabel);
        Panel3.add(serviceLabel);
        Panel3.add(ROALabel);
        Panel3.add(ROAComboBox);
    }

    public void panel() {
        // JPANEL-------------------------------------------------------------------------------------
        Panel1 = new JPanel();
        Panel1.setBounds(0, 0, 1400, 100); // Set the bounds to cover the entire frame
        Panel1.setLayout(null);
        Panel1.add(Home);
        Panel1.add(apt);
        Panel1.add(doc);
        Panel1.add(transact);
        Panel1.add(logout);
        Panel1.setBackground(new Color(0xFAEED1)); // Set background color to orange
        Panel1.setVisible(true);

        Panel2 = new JPanel();
        Panel2.setBounds(20, 120, 480, 520); // Set the bounds to cover the entire frame
        Panel2.setLayout(null);
        Panel2.add(firstLabel_1);
        Panel2.add(petName);
        Panel2.add(petLabel);
        Panel2.add(speciesComboBox);
        Panel2.add(spec);
        Panel2.add(breedN);
        Panel2.add(breedName);
        Panel2.add(date_of_birth);
        Panel2.add(bday);
        Panel2.add(genderBox);
        Panel2.add(gender_Label);
        Panel2.setBackground(new Color(0xDED0B6)); // Set background color to orange
        Panel2.setVisible(true);

        // for appointment
        Panel3 = new JPanel();
        Panel3.setBounds(530, 120, 480, 520); // Set the bounds to cover the entire frame
        Panel3.setLayout(null);
        Panel3.setBackground(new Color(0xDED0B6)); // Set background color to orange
        Panel3.setVisible(true);

        connectSecondPanel();
    }

    private void fetchDoctorNames() throws SQLException {
        docComboBox.removeAllItems();

        selectedReason = (String) ROAComboBox.getSelectedItem();
        if (selectedReason == null) {
            return;
        }

        String query = "SELECT d.docName, d.availSched, s.serviceName " +
                "FROM doctor d " +
                "INNER JOIN docservice ds ON d.docID = ds.docID " +
                "INNER JOIN service s ON ds.serviceID = s.serviceID " +
                "WHERE s.description = ?";

        try (Connection connection = DriverManager.getConnection(db_url, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, selectedReason);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                boolean isFirstDoctor = true; // Flag to track the first doctor
                while (resultSet.next()) {
                    String doctorName = resultSet.getString("docName");
                    String sched = resultSet.getString("availSched");
                    String service = resultSet.getString("serviceName");

                    docComboBox.addItem(doctorName);

                    // Set the fields for the first doctor only
                    if (isFirstDoctor) {
                        serviceField.setText(service);
                        availSchedField.setText(sched);
                        isFirstDoctor = false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        LocalDateTime currentTime = LocalDateTime.now();
        String birday = new SimpleDateFormat("yyyy-MM-dd").format(date_of_birth.getDate());
        String dateOFAppointment = new SimpleDateFormat("yyyy-MM-dd").format(aptDay.getDate());

        try (Connection conn = DriverManager.getConnection(db_url, user, password)) {
            // Check for nullity of components before accessing them
            if (petName.getText().isEmpty() || speciesComboBox.getSelectedItem() == null ||
                    breedName.getText().isEmpty() || birday.trim().isEmpty() ||
                    genderBox.getSelectedItem() == null || dateOFAppointment.isEmpty() ||
                    timeComboBox.getSelectedItem() == null ||
                    ROAComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Please complete all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prepare the SQL statement for inserting into the animals table
            String animalsSQL = "INSERT INTO animals(ownerID, petName, species, breed, dateOfBirth, Gender) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstAnimals = conn.prepareStatement(animalsSQL)) {
                // Set values for the animals table
                pstAnimals.setInt(1, l.ownerID); // Set the ownerID
                pstAnimals.setString(2, petName.getText());
                pstAnimals.setString(3, (String) speciesComboBox.getSelectedItem()); // Only insert the selected item
                pstAnimals.setString(4, breedName.getText());
                pstAnimals.setString(5, birday);
                pstAnimals.setString(6, genderBox.getSelectedItem().toString());

                // Execute the animalsSQL statement
                pstAnimals.executeUpdate();
            }

            // Prepare the SQL statement for inserting into the appointments table
            String aptSQL = "INSERT INTO appointments(animalsID, docServiceID, aptDate, aptTime, book) " +
                    "SELECT a.animalsID, ds.docServiceID, ?, ?, ? " +
                    "FROM animals a " +
                    "INNER JOIN docservice ds ON a.petName = ? " +
                    "INNER JOIN doctor d ON ds.docID = d.docID " +
                    "INNER JOIN service s ON ds.serviceID = s.serviceID " +
                    "WHERE s.description = ? AND d.docName = ?";
            try (PreparedStatement pstAppointment = conn.prepareStatement(aptSQL)) {
                // Check for nullity of components before accessing them
                if (petName.getText().isEmpty() || breedName.getText().isEmpty() || birday.trim().isEmpty() ||
                        genderBox.getSelectedItem() == null || dateOFAppointment.isEmpty() ||
                        timeComboBox.getSelectedItem() == null || ROAComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Please complete all fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Set values for the appointment table
                pstAppointment.setString(1, dateOFAppointment);
                pstAppointment.setString(2, timeComboBox.getSelectedItem().toString());
                pstAppointment.setString(3, currentTime.toString());
                pstAppointment.setString(4, petName.getText());
                pstAppointment.setString(5, selectedReason);
                pstAppointment.setString(6, (String) docComboBox.getSelectedItem());

                // Execute the appointmentSQL statement
                int appointmentRowsAffected = pstAppointment.executeUpdate();

                // Check if appointment insertion was successful
                if (appointmentRowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Booking Successful", "Added to the Appointment Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Booking Failed", "BOOKING", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            try {
                connect();
                new apt1(l);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                System.out.println("sdfsd");
                e1.printStackTrace();
            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(null, "Please complete the fields", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (e.getSource() == Home) {
            F.dispose();
            new home(l);
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
        if (e.getSource() == backButton) {
            F.dispose();
        }
    }
}