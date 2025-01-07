package Components;

import static Components.UtilityMethods.getUserID;
import Home.InstructorHome;
import Signup.InstructorCreateAccount2Frame;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InstructorEditProfile extends javax.swing.JFrame {

    static InstructorHome InstructorHome;
    private static int userID;

    public InstructorEditProfile(int userID, InstructorHome InstructorHome) {
        this.InstructorHome = InstructorHome;
        InstructorEditProfile.userID = userID;
        initComponents();
        ButtonGroup sex = new ButtonGroup();
        sex.add(male_rdb);
        sex.add(female_rdb);
        sex.add(other_rdb);
        mover.initMoving(InstructorEditProfile.this);
        
        question_cbox.setModel(new DefaultComboBoxModel<>(new String[]{
            "Select a question.",
            "What is the name of the school where you completed your student teaching?",
            "What was the name of the first school where you taught?",
            "What year did you start working at CvSU?",
            "Who was the school administrator on your first year working at CvSU?",
            "What was your first advisory section?",
            "What was grade level of your first teaching position?",
            "What is the name of your favorite subject to teach?",
            "What was the title of the first course you taught?"
        }));
    }

    public static void setUserID(int userID) {
        InstructorEditProfile.userID = userID;

        String query = "SELECT * FROM tb_instructorinfo WHERE info_id = " + userID;

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
                id_field.setText(String.valueOf(userID));
                String info_department = rs.getString("Department");
                if (info_department == null) {
                    department_cbox.setSelectedItem("N/A");
                } else {
                    switch (info_department) {
                        case "DIT" ->
                            department_cbox.setSelectedItem("DIT");
                        case "DAS" ->
                            department_cbox.setSelectedItem("DAS");
                        case "DOM" ->
                            department_cbox.setSelectedItem("DOM");
                        case "TED" ->
                            department_cbox.setSelectedItem("TED");
                        default ->
                            department_cbox.setSelectedItem("N/A");
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
        user_security = new javax.swing.JPanel();
        instructor_answer = new javax.swing.JLabel();
        instructor_question = new javax.swing.JLabel();
        instructor_repassword = new javax.swing.JLabel();
        instructor_password = new javax.swing.JLabel();
        question_cbox = new javax.swing.JComboBox<>();
        repassword_field = new javax.swing.JPasswordField();
        currentpassword_field = new javax.swing.JPasswordField();
        answer_field = new javax.swing.JTextField();
        confirm_btn1 = new javax.swing.JButton();
        password_field = new javax.swing.JPasswordField();
        instructor_password1 = new javax.swing.JLabel();
        user_information = new javax.swing.JPanel();
        instructor_name = new javax.swing.JLabel();
        instructor_age = new javax.swing.JLabel();
        instructor_sex = new javax.swing.JLabel();
        instructor_number = new javax.swing.JLabel();
        instructor_address = new javax.swing.JLabel();
        instructor_bday = new javax.swing.JLabel();
        instructor_email = new javax.swing.JLabel();
        instructor_ID = new javax.swing.JLabel();
        instructor_department = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        age_field = new javax.swing.JTextField();
        male_rdb = new javax.swing.JRadioButton();
        female_rdb = new javax.swing.JRadioButton();
        other_rdb = new javax.swing.JRadioButton();
        number_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_field = new javax.swing.JTextArea();
        email_field = new javax.swing.JTextField();
        id_field = new javax.swing.JTextField();
        department_cbox = new javax.swing.JComboBox<>();
        bday_chooser = new com.toedter.calendar.JDateChooser();
        confirm_btn = new javax.swing.JButton();
        background = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(81, 199, 135));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info_btn.setBackground(new java.awt.Color(48, 150, 95));
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

        sec_btn.setBackground(new java.awt.Color(48, 150, 95));
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
        jLabel1.setText("Editing Instructor Profile");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        header.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 20));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 80));

        user_security.setBackground(new java.awt.Color(81, 199, 135));
        user_security.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructor_answer.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_answer.setForeground(new java.awt.Color(255, 255, 255));
        instructor_answer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_answer.setText("Validation Answer:");
        user_security.add(instructor_answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 250, 150, 20));

        instructor_question.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_question.setForeground(new java.awt.Color(255, 255, 255));
        instructor_question.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_question.setText("Validation Question:");
        user_security.add(instructor_question, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 190, 150, 20));

        instructor_repassword.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_repassword.setForeground(new java.awt.Color(255, 255, 255));
        instructor_repassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_repassword.setText("Re-enter Password:");
        user_security.add(instructor_repassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 220, 20));

        instructor_password.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_password.setForeground(new java.awt.Color(255, 255, 255));
        instructor_password.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_password.setText("Current Password: ");
        user_security.add(instructor_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 20));

        question_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        question_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a question.", "What is the name of the school where you completed your student teaching?", "What was the name of the first school where you taught?", "What year did you start working at CvSU?", "Who was the school administrator on your first year working at CvSU?", "What was your first advisory section?", "What was grade level of your first teaching position?", "What is the name of your favorite subject to teach?", "What was the title of the first course you taught?", " " }));
        question_cbox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        user_security.add(question_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 560, -1));

        repassword_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(repassword_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 240, -1));

        currentpassword_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(currentpassword_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 240, -1));

        answer_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(answer_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 560, -1));

        confirm_btn1.setBackground(new java.awt.Color(48, 150, 95));
        confirm_btn1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        confirm_btn1.setForeground(new java.awt.Color(255, 255, 255));
        confirm_btn1.setText("Confirm Edit");
        confirm_btn1.setBorder(null);
        confirm_btn1.setBorderPainted(false);
        confirm_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_btn1ActionPerformed(evt);
            }
        });
        user_security.add(confirm_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 110, 30));

        password_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_security.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 240, -1));

        instructor_password1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_password1.setForeground(new java.awt.Color(255, 255, 255));
        instructor_password1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_password1.setText("New Password:");
        user_security.add(instructor_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 20));

        edit.addTab("tab2", user_security);

        user_information.setBackground(new java.awt.Color(81, 199, 135));
        user_information.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructor_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_name.setForeground(new java.awt.Color(255, 255, 255));
        instructor_name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_name.setText("Name:");
        user_information.add(instructor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 70, 180, 20));

        instructor_age.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_age.setForeground(new java.awt.Color(255, 255, 255));
        instructor_age.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_age.setText("Age:");
        user_information.add(instructor_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 100, 180, 20));

        instructor_sex.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_sex.setForeground(new java.awt.Color(255, 255, 255));
        instructor_sex.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_sex.setText("Sex:");
        user_information.add(instructor_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 130, 180, 20));

        instructor_number.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_number.setForeground(new java.awt.Color(255, 255, 255));
        instructor_number.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_number.setText("Contact Number:");
        user_information.add(instructor_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 160, 180, 20));

        instructor_address.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_address.setForeground(new java.awt.Color(255, 255, 255));
        instructor_address.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_address.setText("Address:");
        user_information.add(instructor_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 200, 180, 20));

        instructor_bday.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_bday.setForeground(new java.awt.Color(255, 255, 255));
        instructor_bday.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_bday.setText("Birthdate:");
        user_information.add(instructor_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 240, 180, 20));

        instructor_email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_email.setForeground(new java.awt.Color(255, 255, 255));
        instructor_email.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_email.setText("CvSU Email:");
        user_information.add(instructor_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 280, 180, 20));

        instructor_ID.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_ID.setForeground(new java.awt.Color(255, 255, 255));
        instructor_ID.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_ID.setText("Employee ID:");
        user_information.add(instructor_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 310, 180, 20));

        instructor_department.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_department.setForeground(new java.awt.Color(255, 255, 255));
        instructor_department.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_department.setText("Department:");
        user_information.add(instructor_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 340, 180, 20));

        name_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 270, -1));

        age_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 270, -1));

        male_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        male_rdb.setForeground(new java.awt.Color(255, 255, 255));
        male_rdb.setText("Male");
        user_information.add(male_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        female_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        female_rdb.setForeground(new java.awt.Color(255, 255, 255));
        female_rdb.setText("Female");
        user_information.add(female_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        other_rdb.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        other_rdb.setForeground(new java.awt.Color(255, 255, 255));
        other_rdb.setText("Prefer not to say");
        user_information.add(other_rdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        number_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 270, -1));

        address_field.setColumns(20);
        address_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        address_field.setRows(5);
        jScrollPane1.setViewportView(address_field);

        user_information.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 270, 40));

        email_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 270, -1));

        id_field.setEditable(false);
        id_field.setBackground(new java.awt.Color(255, 255, 255));
        id_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 270, -1));

        department_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        department_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIT", "DAS", "DOM", "TED", "N/A" }));
        user_information.add(department_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 270, -1));

        bday_chooser.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        user_information.add(bday_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 270, -1));

        confirm_btn.setBackground(new java.awt.Color(48, 150, 95));
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
        user_information.add(confirm_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 110, 30));

        edit.addTab("tab1", user_information);

        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 410));

        background.setBackground(new java.awt.Color(81, 199, 135));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
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
            Logger.getLogger(InstructorEditProfile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String query = "UPDATE tb_instructorinfo SET info_age = ?, info_sex = ?, info_contact_number = ?, info_address = ?, info_birthday = ? WHERE info_id = ?";
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

        query = "UPDATE tb_createinstructor SET Name = ?, CvSU_Mail = ?, Department = ? WHERE EmployeeID = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name_field.getText());
            pst.setString(2, email_field.getText());
            pst.setString(3, department_cbox.getSelectedItem().toString());
            pst.setInt(4, userID);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        InstructorHome.refreshProfile();
        JOptionPane.showMessageDialog(new JFrame(), "Edit Profile Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_confirm_btnActionPerformed

    private void confirm_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_btn1ActionPerformed
        String Password;
        String RePass;       
        String ValQuestion;
        String ValAnswer; 
        String selectedQuestion = (String) question_cbox.getSelectedItem();
        String query;
        boolean isValid = true;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstructorCreateAccount2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorCreateAccount2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if ("".equals(password_field.getText().trim())) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if ("".equals(repassword_field.getText())) {
            // Check if passwords match
            JOptionPane.showMessageDialog(new JFrame(), "Please confirm password", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (!password_field.getText().equals(repassword_field.getText())) {
            // Check if passwords match
            JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if ("Select a question.".equals(selectedQuestion)) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a security question", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if ("".equals(answer_field.getText().trim())) {
            JOptionPane.showMessageDialog(new JFrame(), "Validation Answer is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            System.out.println("Selected question: " + selectedQuestion);
            isValid = false;
        } else {

            Password = password_field.getText().trim();
            ValQuestion = selectedQuestion;
            ValAnswer = answer_field.getText().trim();

            if (isValid) {
                query = "UPDATE tb_createinstructor SET Password = ?, SecurityQuestion = ?, ValidationAnswer = ? WHERE ID = ?";
                try {
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Password);
                    pst.setString(2, ValQuestion);
                    pst.setString(3, ValAnswer);
                    pst.setInt(4, userID);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(new JFrame(), "Security Setup Done!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                    new InstructorHome(userID).setVisible(true);
                    InstructorHome.setUserID(userID);
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                    JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_confirm_btn1ActionPerformed

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
            java.util.logging.Logger.getLogger(InstructorEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorEditProfile(0, InstructorHome).setVisible(true);
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
    private javax.swing.JButton confirm_btn1;
    private javax.swing.JPasswordField currentpassword_field;
    private static javax.swing.JComboBox<String> department_cbox;
    private javax.swing.JTabbedPane edit;
    private static javax.swing.JTextField email_field;
    private javax.swing.JButton exit_btn;
    private static javax.swing.JRadioButton female_rdb;
    private javax.swing.JPanel header;
    private static javax.swing.JTextField id_field;
    private javax.swing.JButton info_btn;
    private javax.swing.JLabel instructor_ID;
    private javax.swing.JLabel instructor_address;
    private javax.swing.JLabel instructor_age;
    private javax.swing.JLabel instructor_answer;
    private javax.swing.JLabel instructor_bday;
    private javax.swing.JLabel instructor_department;
    private javax.swing.JLabel instructor_email;
    private javax.swing.JLabel instructor_name;
    private javax.swing.JLabel instructor_number;
    private javax.swing.JLabel instructor_password;
    private javax.swing.JLabel instructor_password1;
    private javax.swing.JLabel instructor_question;
    private javax.swing.JLabel instructor_repassword;
    private javax.swing.JLabel instructor_sex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JRadioButton male_rdb;
    private Components.PanelMover mover;
    private static javax.swing.JTextField name_field;
    private static javax.swing.JTextField number_field;
    private static javax.swing.JRadioButton other_rdb;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JComboBox<String> question_cbox;
    private javax.swing.JPasswordField repassword_field;
    private javax.swing.JButton sec_btn;
    private javax.swing.JPanel user_information;
    private javax.swing.JPanel user_security;
    // End of variables declaration//GEN-END:variables
}
