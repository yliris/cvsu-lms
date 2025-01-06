package Components;

import Home.StudentHome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StudentEditProfile extends javax.swing.JFrame {

    static StudentHome StudentHome;
    private static int userID;

    public StudentEditProfile(int userID, StudentHome InstructorHome) {
        this.StudentHome = StudentHome;
        StudentEditProfile.userID = userID;
        initComponents();
        ButtonGroup sex = new ButtonGroup();
        sex.add(male_rdb);
        sex.add(female_rdb);
        sex.add(other_rdb);
        mover.initMoving(StudentEditProfile.this);
    }

    public static void setUserID(int userID) {
        StudentEditProfile.userID = userID;

        String query = "SELECT * FROM tb_studentinfo WHERE info_id = " + userID;

        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                age_field.setText(rs.getString("info_age"));
                String infoSex = rs.getString("info_sex");
                if (infoSex == null) {
                    other_rdb.setSelected(true);
                } else {
                    switch (infoSex) {
                        case "MALE" ->
                            male_rdb.setSelected(true);
                        case "FEMALE" ->
                            female_rdb.setSelected(true);
                        default ->
                            other_rdb.setSelected(true);
                    }
                }

                try {
                    String dbDate = rs.getString("info_birthday");

                    if (dbDate == null) {
                        bday_chooser.setDate(null);
                    } else {

                        SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat displayFormat = new SimpleDateFormat("MMM d, yyyy");

                        Date date = dbFormat.parse(dbDate);
                        String formattedDate = displayFormat.format(date);

                        date = displayFormat.parse(formattedDate);

                        bday_chooser.setDate(date);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                number_field.setText(String.valueOf(rs.getInt("info_contact_number")));
                address_field.setText(rs.getString("info_address"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        query = "SELECT * FROM tb_createinstructor WHERE EmployeeID = " + userID;

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                name_field.setText(rs.getString("Name"));
                email_field.setText(rs.getString("CvSU_Mail"));
                studNumber_field.setText(String.valueOf(userID));
                String info_department = rs.getString("Department");
                if (info_department == null) {
                    course_cbox.setSelectedItem("N/A");
                } else {
                    switch (info_department) {
                        case "DIT" ->
                            course_cbox.setSelectedItem("DIT");
                        case "DAS" ->
                            course_cbox.setSelectedItem("DAS");
                        case "DOM" ->
                            course_cbox.setSelectedItem("DOM");
                        case "TED" ->
                            course_cbox.setSelectedItem("TED");
                        default ->
                            course_cbox.setSelectedItem("N/A");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        info_btn = new javax.swing.JButton();
        sec_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mover = new Components.PanelMover();
        edit = new javax.swing.JTabbedPane();
        user_information = new javax.swing.JPanel();
        student_name = new javax.swing.JLabel();
        student_age = new javax.swing.JLabel();
        student_sex = new javax.swing.JLabel();
        student_contact = new javax.swing.JLabel();
        student_address = new javax.swing.JLabel();
        student_bday = new javax.swing.JLabel();
        student_email = new javax.swing.JLabel();
        student_number = new javax.swing.JLabel();
        student_course = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        age_field = new javax.swing.JTextField();
        male_rdb = new javax.swing.JRadioButton();
        female_rdb = new javax.swing.JRadioButton();
        other_rdb = new javax.swing.JRadioButton();
        number_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_field = new javax.swing.JTextArea();
        email_field = new javax.swing.JTextField();
        studNumber_field = new javax.swing.JTextField();
        course_cbox = new javax.swing.JComboBox<>();
        bday_chooser = new com.toedter.calendar.JDateChooser();
        user_security = new javax.swing.JPanel();
        student_answer = new javax.swing.JLabel();
        student_question = new javax.swing.JLabel();
        student_repassword = new javax.swing.JLabel();
        student_password = new javax.swing.JLabel();
        repassword_field = new javax.swing.JPasswordField();
        password_field = new javax.swing.JPasswordField();
        answer_field = new javax.swing.JTextField();
        studentQuestion_Combobox = new javax.swing.JComboBox<>();
        background = new javax.swing.JPanel();
        confirm_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(202, 154, 221));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info_btn.setBackground(new java.awt.Color(164, 83, 197));
        info_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        info_btn.setForeground(new java.awt.Color(255, 255, 255));
        info_btn.setText("Information");
        info_btn.setBorderPainted(false);
        info_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info_btnActionPerformed(evt);
            }
        });
        header.add(info_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 270, -1));

        sec_btn.setBackground(new java.awt.Color(164, 83, 197));
        sec_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        sec_btn.setForeground(new java.awt.Color(255, 255, 255));
        sec_btn.setText("Security");
        sec_btn.setBorderPainted(false);
        sec_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sec_btnActionPerformed(evt);
            }
        });
        header.add(sec_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 270, -1));

        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png"))); // NOI18N
        exit_btn.setBorder(null);
        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exit_btnMouseReleased(evt);
            }
        });
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        header.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 5, 30, 30));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editing Student Profile");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        header.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 20));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 80));

        user_information.setBackground(new java.awt.Color(202, 154, 221));
        user_information.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_name.setForeground(new java.awt.Color(255, 255, 255));
        student_name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_name.setText("Name:");
        user_information.add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 20));

        student_age.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_age.setForeground(new java.awt.Color(255, 255, 255));
        student_age.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_age.setText("Age:");
        user_information.add(student_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 180, 20));

        student_sex.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_sex.setForeground(new java.awt.Color(255, 255, 255));
        student_sex.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_sex.setText("Sex:");
        user_information.add(student_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 20));

        student_contact.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_contact.setForeground(new java.awt.Color(255, 255, 255));
        student_contact.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_contact.setText("Contact Number:");
        user_information.add(student_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 180, 20));

        student_address.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_address.setForeground(new java.awt.Color(255, 255, 255));
        student_address.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_address.setText("Address:");
        user_information.add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 180, 20));

        student_bday.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_bday.setForeground(new java.awt.Color(255, 255, 255));
        student_bday.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_bday.setText("Birthdate:");
        user_information.add(student_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 180, 20));

        student_email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_email.setForeground(new java.awt.Color(255, 255, 255));
        student_email.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_email.setText("CvSU Email:");
        user_information.add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 180, 20));

        student_number.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_number.setForeground(new java.awt.Color(255, 255, 255));
        student_number.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_number.setText("Student Number:");
        user_information.add(student_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 180, 20));

        student_course.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_course.setForeground(new java.awt.Color(255, 255, 255));
        student_course.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_course.setText("Course:");
        user_information.add(student_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 180, 20));

        name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 270, -1));

        age_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 270, -1));

        male_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        male_rdb.setForeground(new java.awt.Color(255, 255, 255));
        male_rdb.setText("Male");
        user_information.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        female_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        female_rdb.setForeground(new java.awt.Color(255, 255, 255));
        female_rdb.setText("Female");
        user_information.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        other_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        other_rdb.setForeground(new java.awt.Color(255, 255, 255));
        other_rdb.setText("Prefer not to say");
        user_information.add(other_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        number_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 270, -1));

        address_field.setColumns(20);
        address_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        address_field.setRows(5);
        jScrollPane1.setViewportView(address_field);

        user_information.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 270, 40));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 270, -1));

        studNumber_field.setEditable(false);
        studNumber_field.setBackground(new java.awt.Color(255, 255, 255));
        studNumber_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(studNumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 270, -1));

        course_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCS", "BSIT", " " }));
        user_information.add(course_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 270, -1));

        bday_chooser.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(bday_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 270, -1));

        edit.addTab("tab1", user_information);

        user_security.setBackground(new java.awt.Color(202, 154, 221));
        user_security.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_answer.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_answer.setForeground(new java.awt.Color(255, 255, 255));
        student_answer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_answer.setText("Validation Answer:");
        user_security.add(student_answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, 20));

        student_question.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_question.setForeground(new java.awt.Color(255, 255, 255));
        student_question.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_question.setText("Validation Question:");
        user_security.add(student_question, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, 20));

        student_repassword.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_repassword.setForeground(new java.awt.Color(255, 255, 255));
        student_repassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_repassword.setText("Re-enter Password:");
        user_security.add(student_repassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, 20));

        student_password.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_password.setForeground(new java.awt.Color(255, 255, 255));
        student_password.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_password.setText("Password:");
        user_security.add(student_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 20));

        repassword_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(repassword_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 240, -1));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 240, -1));

        answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 560, -1));

        studentQuestion_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentQuestion_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a question.", "What year did you start your studies at this school?", "Who was the school administrator during your time?", "Who was your adviser during your first year at CvSU?", "What is the name of your favorite class or course?", "What is the name of the first class you ever attended at your current school?", "What year did you graduate from your previous school?", "", "" }));
        studentQuestion_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        user_security.add(studentQuestion_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 560, -1));

        edit.addTab("tab2", user_security);

        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 410));

        background.setBackground(new java.awt.Color(202, 154, 221));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirm_btn.setBackground(new java.awt.Color(164, 83, 197));
        confirm_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        confirm_btn.setForeground(new java.awt.Color(255, 255, 255));
        confirm_btn.setText("Confirm Edit");
        confirm_btn.setBorder(null);
        confirm_btn.setBorderPainted(false);
        confirm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_btnActionPerformed(evt);
            }
        });
        background.add(confirm_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 130, 30));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        int confirmLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmLogout == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btnMousePressed

    private void exit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseReleased
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseReleased

    private void info_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info_btnActionPerformed
        edit.setSelectedIndex(0);
    }//GEN-LAST:event_info_btnActionPerformed

    private void sec_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sec_btnActionPerformed
        edit.setSelectedIndex(1);
    }//GEN-LAST:event_sec_btnActionPerformed

    private void confirm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_btnActionPerformed
        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(StudentEditProfile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String query = "UPDATE tb_studentinfo SET info_age = ?, info_sex = ?, info_contact_number = ?, info_address = ?, info_birthday = ? WHERE info_id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, age_field.getText());

            String sex;
            if (male_rdb.isSelected()) {
                sex = "MALE";
            } else if (female_rdb.isSelected()) {
                sex = "FEMALE";
            } else {
                sex = "N/A";
            }

            pst.setString(2, sex);
            pst.setString(3, number_field.getText());
            pst.setString(4, address_field.getText());

            Date date = bday_chooser.getDate();
            String strDate = DateFormat.getDateInstance().format(date);
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                date = inputFormat.parse(strDate);
                String formattedDate = outputFormat.format(date);
                pst.setString(5, formattedDate);
            } catch (ParseException e) {
                System.out.println("Error " + e.getMessage());
            }

            pst.setInt(6, userID);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        query = "UPDATE tb_createstudent SET Name = ?, CvSU_Mail = ?, Department = ? WHERE EmployeeID = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name_field.getText());
            pst.setString(2, email_field.getText());
            pst.setString(3, course_cbox.getSelectedItem().toString());
            pst.setInt(4, userID);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

//        StudentHome.refreshProfile();
        JOptionPane.showMessageDialog(new JFrame(), "Edit Profile Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_confirm_btnActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentEditProfile(0, StudentHome).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea address_field;
    private static javax.swing.JTextField age_field;
    private javax.swing.JTextField answer_field;
    private javax.swing.JPanel background;
    private static com.toedter.calendar.JDateChooser bday_chooser;
    private javax.swing.JButton confirm_btn;
    private static javax.swing.JComboBox<String> course_cbox;
    private javax.swing.JTabbedPane edit;
    private static javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private static javax.swing.JRadioButton female_rdb;
    private javax.swing.JPanel header;
    private javax.swing.JButton info_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JRadioButton male_rdb;
    private Components.PanelMover mover;
    private static javax.swing.JTextField name_field;
    private static javax.swing.JTextField number_field;
    private static javax.swing.JRadioButton other_rdb;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JPasswordField repassword_field;
    private javax.swing.JButton sec_btn;
    private static javax.swing.JTextField studNumber_field;
    private javax.swing.JComboBox<String> studentQuestion_Combobox;
    private javax.swing.JLabel student_address;
    private javax.swing.JLabel student_age;
    private javax.swing.JLabel student_answer;
    private javax.swing.JLabel student_bday;
    private javax.swing.JLabel student_contact;
    private javax.swing.JLabel student_course;
    private javax.swing.JLabel student_email;
    private javax.swing.JLabel student_name;
    private javax.swing.JLabel student_number;
    private javax.swing.JLabel student_password;
    private javax.swing.JLabel student_question;
    private javax.swing.JLabel student_repassword;
    private javax.swing.JLabel student_sex;
    private javax.swing.JPanel user_information;
    private javax.swing.JPanel user_security;
    // End of variables declaration//GEN-END:variables
}
