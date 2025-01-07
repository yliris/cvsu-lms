package Signup;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import Home.StudentHome;
import Components.UtilityMethods.DefaultFocus;
import static Components.UtilityMethods.DefaultText;
import static Components.UtilityMethods.TransparentField;
import static Components.UtilityMethods.getUserID;

public class StudentCreateAccount2Frame extends javax.swing.JFrame {

    private String StudName;
    private String StudNum;
    private String StudMail;
    private String StudCourse;
    private int primaryID;

    public StudentCreateAccount2Frame(String StudName, String StudNum, String StudMail, String StudCourse, int primaryID) {
        initComponents();
        this.StudName = StudName;
        this.StudNum = StudNum;
        this.StudMail = StudMail;
        this.StudCourse = StudCourse;
        this.primaryID = primaryID;

        studentQuestion_Combobox.setModel(new DefaultComboBoxModel<>(new String[]{
            "Select a question.",
            "What year did you start your studies at this school?",
            "Who was the school administrator during your time?",
            "Who was your adviser during your first year at CvSU?",
            "What is the name of your favorite class or course?",
            "What is the name of the first class you ever attended at your current school?",
            "What year did you graduate from your previous school?"

        }));
        TransparentField(createStudentPassword_Field, student_AnswerCreate_Field);
    }

    private StudentCreateAccount2Frame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkPassword_Checkbox = new javax.swing.JCheckBox();
        studentQuestion_Combobox = new javax.swing.JComboBox<>();
        student_AnswerCreate_Field = new javax.swing.JTextField();
        student_Submit_Button = new javax.swing.JButton();
        createStudentPassword_Field1 = new javax.swing.JPasswordField();
        createStudentPassword_Field = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        createAccount_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Create Account as Student");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkPassword_Checkbox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/hidePass_Button.png"))); // NOI18N
        checkPassword_Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPassword_CheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(checkPassword_Checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        studentQuestion_Combobox.setBackground(new java.awt.Color(33, 125, 23));
        studentQuestion_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentQuestion_Combobox.setForeground(new java.awt.Color(255, 255, 255));
        studentQuestion_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a question.", "What year did you start your studies at this school?", "Who was the school administrator during your time?", "Who was your adviser during your first year at CvSU?", "What is the name of your favorite class or course?", "What is the name of the first class you ever attended at your current school?", "What year did you graduate from your previous school?", "", "" }));
        studentQuestion_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(studentQuestion_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 560, -1));

        student_AnswerCreate_Field.setBackground(new java.awt.Color(33, 125, 23));
        student_AnswerCreate_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        student_AnswerCreate_Field.setForeground(new java.awt.Color(255, 255, 255));
        student_AnswerCreate_Field.setText("Enter Answer");
        student_AnswerCreate_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        student_AnswerCreate_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                student_AnswerCreate_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                student_AnswerCreate_FieldFocusLost(evt);
            }
        });
        getContentPane().add(student_AnswerCreate_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 355, 280, -1));

        student_Submit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Create&Login_Button.png"))); // NOI18N
        student_Submit_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        student_Submit_Button.setBorderPainted(false);
        student_Submit_Button.setContentAreaFilled(false);
        student_Submit_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                student_Submit_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                student_Submit_ButtonMouseReleased(evt);
            }
        });
        student_Submit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_Submit_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(student_Submit_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, -1));

        createStudentPassword_Field1.setBackground(new java.awt.Color(33, 125, 23));
        createStudentPassword_Field1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentPassword_Field1.setForeground(new java.awt.Color(255, 255, 255));
        createStudentPassword_Field1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createStudentPassword_Field1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                createStudentPassword_Field1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                createStudentPassword_Field1FocusLost(evt);
            }
        });
        getContentPane().add(createStudentPassword_Field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 191, 230, -1));

        createStudentPassword_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentPassword_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentPassword_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentPassword_Field.setText("Password");
        createStudentPassword_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createStudentPassword_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                createStudentPassword_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                createStudentPassword_FieldFocusLost(evt);
            }
        });
        getContentPane().add(createStudentPassword_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 210, -1));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Create Account");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Re-enter Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Empty_Field.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 185, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Empty_Field.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 145, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_Button(1).png"))); // NOI18N
        goBack_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        goBack_Button.setBorderPainted(false);
        goBack_Button.setContentAreaFilled(false);
        goBack_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                goBack_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                goBack_ButtonMouseReleased(evt);
            }
        });
        goBack_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBack_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goBack_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        createAccount_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/CreateAccount2.png"))); // NOI18N
        getContentPane().add(createAccount_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_Submit_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_Submit_ButtonMousePressed
        student_Submit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Create&Login_ButtonClick.png")));
    }//GEN-LAST:event_student_Submit_ButtonMousePressed

    private void student_Submit_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_Submit_ButtonMouseReleased
        student_Submit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Create&Login_Button.png")));
    }//GEN-LAST:event_student_Submit_ButtonMouseReleased

    private void student_Submit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_Submit_ButtonActionPerformed
        String Password = createStudentPassword_Field.getText();
        String ValAnswer = student_AnswerCreate_Field.getText();
        String ValQuestion = (String) studentQuestion_Combobox.getSelectedItem();
        String query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentCreateAccount2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";
        boolean isValid = true;

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(StudentCreateAccount2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if ("".equals(createStudentPassword_Field.getText().trim())) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if ("".equals(createStudentPassword_Field1.getText())) {
            // Check if passwords match
            JOptionPane.showMessageDialog(new JFrame(), "Please confirm password", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (!createStudentPassword_Field.getText().equals(createStudentPassword_Field1.getText())) {
            // Check if passwords match
            JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if ("".equals((String) studentQuestion_Combobox.getSelectedItem())) {
            JOptionPane.showMessageDialog(new JFrame(), "Validation Question is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if ("".equals(student_AnswerCreate_Field.getText().trim())) {
            JOptionPane.showMessageDialog(new JFrame(), "Validation Answer is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else {

            Password = createStudentPassword_Field.getText().trim().trim();
            ValQuestion = (String) studentQuestion_Combobox.getSelectedItem();
            ValAnswer = student_AnswerCreate_Field.getText().trim().trim();

            query = "UPDATE tb_createstudent SET Password = ?, SecurityQuestion = ?, ValidationAnswer = ? WHERE ID = ?";
            try {
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, Password);
                pst.setString(2, ValQuestion);
                pst.setString(3, ValAnswer);
                pst.setInt(4, primaryID);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(new JFrame(), "Welcome, Kabsuhenyo!", "Success", JOptionPane.INFORMATION_MESSAGE);

                dispose();
                int userID = getUserID("StudentNumber", "tb_createstudent", "ID", String.valueOf(primaryID));
                new StudentHome(userID).setVisible(true);
                StudentHome.setUserID(userID);

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
                JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_student_Submit_ButtonActionPerformed

    private void checkPassword_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassword_CheckboxActionPerformed
        if (checkPassword_Checkbox.isSelected()) {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/showPass_Button.png")));
            createStudentPassword_Field.setEchoChar((char) 0);
            createStudentPassword_Field1.setEchoChar((char) 0);
        } else {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/hidePass_Button.png")));
            createStudentPassword_Field.setEchoChar('*');
            createStudentPassword_Field1.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPassword_CheckboxActionPerformed

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new StudentCreateAccount1Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

    private void createStudentPassword_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentPassword_FieldFocusGained
        DefaultText(createStudentPassword_Field, "Password", DefaultFocus.GAINED);
    }//GEN-LAST:event_createStudentPassword_FieldFocusGained

    private void createStudentPassword_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentPassword_FieldFocusLost
        DefaultText(createStudentPassword_Field, "Password", DefaultFocus.LOST);
    }//GEN-LAST:event_createStudentPassword_FieldFocusLost

    private void createStudentPassword_Field1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentPassword_Field1FocusGained

    }//GEN-LAST:event_createStudentPassword_Field1FocusGained

    private void createStudentPassword_Field1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentPassword_Field1FocusLost

    }//GEN-LAST:event_createStudentPassword_Field1FocusLost

    private void student_AnswerCreate_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_student_AnswerCreate_FieldFocusGained
        DefaultText(student_AnswerCreate_Field, "Enter Answer", DefaultFocus.GAINED);

    }//GEN-LAST:event_student_AnswerCreate_FieldFocusGained

    private void student_AnswerCreate_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_student_AnswerCreate_FieldFocusLost
        DefaultText(student_AnswerCreate_Field, "Enter Answer", DefaultFocus.LOST);

    }//GEN-LAST:event_student_AnswerCreate_FieldFocusLost

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
            java.util.logging.Logger.getLogger(StudentCreateAccount2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentCreateAccount2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentCreateAccount2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentCreateAccount2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentCreateAccount2Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkPassword_Checkbox;
    private javax.swing.JLabel createAccount_Background;
    private javax.swing.JPasswordField createStudentPassword_Field;
    private javax.swing.JPasswordField createStudentPassword_Field1;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> studentQuestion_Combobox;
    private javax.swing.JTextField student_AnswerCreate_Field;
    private javax.swing.JButton student_Submit_Button;
    // End of variables declaration//GEN-END:variables
}
