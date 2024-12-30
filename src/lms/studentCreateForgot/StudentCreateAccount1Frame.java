package lms.studentCreateForgot;

import lms.LoginStudentFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static lms.UtilityMethods.*;

public class StudentCreateAccount1Frame extends javax.swing.JFrame {

    public StudentCreateAccount1Frame() {
        initComponents();
        
        TransparentField(createStudentName_Field, createStudentNum_Field, createStudentMail_Field);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentName_Label = new javax.swing.JLabel();
        studentMail_Label = new javax.swing.JLabel();
        studentID_Label = new javax.swing.JLabel();
        studentCourse_Combobox = new javax.swing.JComboBox<>();
        createStudentName_Field = new javax.swing.JTextField();
        createStudentNum_Field = new javax.swing.JTextField();
        createStudentMail_Field = new javax.swing.JTextField();
        next_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        createAccount_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Create Account as Student");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentName_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentName_Label.setForeground(new java.awt.Color(255, 255, 255));
        studentName_Label.setText("Name:");
        getContentPane().add(studentName_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 175, -1, -1));

        studentMail_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentMail_Label.setForeground(new java.awt.Color(255, 255, 255));
        studentMail_Label.setText("CvSU Mail:");
        getContentPane().add(studentMail_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 257, -1, -1));

        studentID_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentID_Label.setForeground(new java.awt.Color(255, 255, 255));
        studentID_Label.setText("Student Number:");
        getContentPane().add(studentID_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 215, -1, -1));

        studentCourse_Combobox.setBackground(new java.awt.Color(33, 125, 23));
        studentCourse_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentCourse_Combobox.setForeground(new java.awt.Color(255, 255, 255));
        studentCourse_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS in Computer Science" }));
        studentCourse_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(studentCourse_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 300, -1));

        createStudentName_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentName_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentName_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentName_Field.setText("Enter Name");
        createStudentName_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createStudentName_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                createStudentName_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                createStudentName_FieldFocusLost(evt);
            }
        });
        getContentPane().add(createStudentName_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 175, 280, -1));

        createStudentNum_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentNum_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentNum_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentNum_Field.setText("Enter Student Number");
        createStudentNum_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createStudentNum_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                createStudentNum_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                createStudentNum_FieldFocusLost(evt);
            }
        });
        createStudentNum_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                createStudentNum_FieldKeyTyped(evt);
            }
        });
        getContentPane().add(createStudentNum_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 215, 280, -1));

        createStudentMail_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentMail_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentMail_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentMail_Field.setText("Enter CvSU Mail");
        createStudentMail_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createStudentMail_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                createStudentMail_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                createStudentMail_FieldFocusLost(evt);
            }
        });
        getContentPane().add(createStudentMail_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 255, 280, -1));

        next_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Next_Button.png"))); // NOI18N
        next_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        next_Button.setBorderPainted(false);
        next_Button.setContentAreaFilled(false);
        next_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                next_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                next_ButtonMouseReleased(evt);
            }
        });
        next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 303, -1, -1));

        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png"))); // NOI18N
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

        createAccount_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/CreateAccount1.png"))); // NOI18N
        getContentPane().add(createAccount_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void next_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_ButtonMousePressed
        next_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Next_ButtonClick.png")));
    }//GEN-LAST:event_next_ButtonMousePressed

    private void next_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_ButtonMouseReleased
        next_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Next_Button.png")));
    }//GEN-LAST:event_next_ButtonMouseReleased

    private void next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_ButtonActionPerformed
        String StudName;
        String StudNum;
        String StudMail;
        String StudCourse;
        String query;
        
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (createStudentName_Field.getText().trim().isEmpty() || createStudentName_Field.getText().equals("Enter Name")) {
            JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (createStudentNum_Field.getText().trim().isEmpty() || createStudentNum_Field.getText().equals("Enter Student Number")) {
            JOptionPane.showMessageDialog(new JFrame(), "Student Number is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (createStudentMail_Field.getText().trim().isEmpty() || createStudentMail_Field.getText().equals("Enter CvSU Mail")) {
            JOptionPane.showMessageDialog(new JFrame(), " CvSU Email is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }  
            else {
            String email = createStudentMail_Field.getText().trim();
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@cvsu\\.edu\\.ph$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid email format. Please enter a valid CvSU email.", "Dialog", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

        else if (studentCourse_Combobox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Course is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        
            if (isValid) {
                StudName = createStudentName_Field.getText().trim();
                StudNum = createStudentNum_Field.getText().trim();
                StudMail = createStudentMail_Field.getText().trim();
                StudCourse = (String) studentCourse_Combobox.getSelectedItem();
                
            query = "INSERT INTO tb_createstudent(Name, StudentNumber, CvSU_Email, Course) VALUES (?, ?, ?, ?)";
                try {
                    PreparedStatement pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                    pst.setString(1, StudName);
                    pst.setString(2, StudNum);
                    pst.setString(3, StudMail);
                    pst.setString(4, StudCourse);

                pst.executeUpdate();
                
                 int primaryID = -1;

                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    primaryID = generatedKeys.getInt(1);
                }

                JOptionPane.showMessageDialog(new JFrame(), "Proceed to Password Section", "Success", JOptionPane.INFORMATION_MESSAGE);

                new StudentCreateAccount2Frame(StudName, StudNum, StudMail, StudCourse, primaryID).setVisible(true);
                dispose();
                
                } catch (SQLException e) {
                System.out.println("Error " + e.getMessage());
                JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
            }
        }
    }//GEN-LAST:event_next_ButtonActionPerformed

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new LoginStudentFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

    private void createStudentName_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentName_FieldFocusGained
        DefaultText(createStudentName_Field, "Enter Name", DefaultFocus.GAINED);
    }//GEN-LAST:event_createStudentName_FieldFocusGained

    private void createStudentName_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentName_FieldFocusLost
        DefaultText(createStudentName_Field, "Enter Name", DefaultFocus.LOST);
    }//GEN-LAST:event_createStudentName_FieldFocusLost

    private void createStudentNum_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentNum_FieldFocusGained
        DefaultText(createStudentNum_Field, "Enter Student Number", DefaultFocus.GAINED);
    }//GEN-LAST:event_createStudentNum_FieldFocusGained

    private void createStudentNum_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentNum_FieldFocusLost
        DefaultText(createStudentNum_Field, "Enter Student Number", DefaultFocus.LOST);
    }//GEN-LAST:event_createStudentNum_FieldFocusLost

    private void createStudentMail_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentMail_FieldFocusGained
        DefaultText(createStudentMail_Field, "Enter CvSU Mail", DefaultFocus.GAINED);
    }//GEN-LAST:event_createStudentMail_FieldFocusGained

    private void createStudentMail_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_createStudentMail_FieldFocusLost
       DefaultText(createStudentMail_Field, "Enter CvSU Mail", DefaultFocus.LOST);
    }//GEN-LAST:event_createStudentMail_FieldFocusLost

    private void createStudentNum_FieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createStudentNum_FieldKeyTyped
        NumbersOnly(evt);
    }//GEN-LAST:event_createStudentNum_FieldKeyTyped

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
            java.util.logging.Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentCreateAccount1Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createAccount_Background;
    private javax.swing.JTextField createStudentMail_Field;
    private javax.swing.JTextField createStudentName_Field;
    private javax.swing.JTextField createStudentNum_Field;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton next_Button;
    private javax.swing.JComboBox<String> studentCourse_Combobox;
    private javax.swing.JLabel studentID_Label;
    private javax.swing.JLabel studentMail_Label;
    private javax.swing.JLabel studentName_Label;
    // End of variables declaration//GEN-END:variables
}
