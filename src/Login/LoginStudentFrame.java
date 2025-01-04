package Login;

import ForgotPassword.StudentForgotPassword1Frame;
import Signup.StudentCreateAccount1Frame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Home.StudentHome;
import Components.UtilityMethods.*;
import static Components.UtilityMethods.DefaultText;
import static Components.UtilityMethods.TransparentField;



public class LoginStudentFrame extends javax.swing.JFrame {

    public LoginStudentFrame() {
        initComponents();
        TransparentField(studentEmail_Login_Field, studentPassword_Login_Field);   
    }
    public boolean checkLogin() {
    String enteredEmail = studentEmail_Login_Field.getText().trim();
    String enteredPassword = new String(studentPassword_Login_Field.getPassword()).trim();  // Get entered password

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", "")) {
        String query = "SELECT CvSU_Email, Password FROM tb_createstudent WHERE CvSU_Email = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, enteredEmail);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String dbEmail = rs.getString("CvSU_Email");
            String dbPassword = rs.getString("Password");

            // Check if the entered email and password match the database values
            if (enteredEmail.equalsIgnoreCase(dbEmail) && enteredPassword.equals(dbPassword)) {
                return true;  // Login successful
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;  // Login failed
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkPassword_Checkbox = new javax.swing.JCheckBox();
        studentEmail_Login_Field = new javax.swing.JTextField();
        studentPassword_Login_Field = new javax.swing.JPasswordField();
        studentLogin_Button = new javax.swing.JButton();
        studentForgotPassword_Button = new javax.swing.JButton();
        goBack_Button = new javax.swing.JButton();
        studentEmail_Label = new javax.swing.JLabel();
        studentPassword_Label = new javax.swing.JLabel();
        studentLogin_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System (LMS) - Student Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkPassword_Checkbox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/hidePass_Button.png"))); // NOI18N
        checkPassword_Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPassword_CheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(checkPassword_Checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 335, -1, -1));

        studentEmail_Login_Field.setBackground(new java.awt.Color(33, 125, 23));
        studentEmail_Login_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentEmail_Login_Field.setForeground(new java.awt.Color(255, 255, 255));
        studentEmail_Login_Field.setText("CvSU Email");
        studentEmail_Login_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentEmail_Login_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentEmail_Login_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentEmail_Login_FieldFocusLost(evt);
            }
        });
        studentEmail_Login_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentEmail_Login_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(studentEmail_Login_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 200, 30));

        studentPassword_Login_Field.setBackground(new java.awt.Color(33, 125, 23));
        studentPassword_Login_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentPassword_Login_Field.setForeground(new java.awt.Color(255, 255, 255));
        studentPassword_Login_Field.setText("Password");
        studentPassword_Login_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentPassword_Login_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentPassword_Login_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentPassword_Login_FieldFocusLost(evt);
            }
        });
        studentPassword_Login_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentPassword_Login_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(studentPassword_Login_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 180, 30));

        studentLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Button.png"))); // NOI18N
        studentLogin_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentLogin_Button.setBorderPainted(false);
        studentLogin_Button.setContentAreaFilled(false);
        studentLogin_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentLogin_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                studentLogin_ButtonMouseReleased(evt);
            }
        });
        studentLogin_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentLogin_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentLogin_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 410, -1, -1));

        studentForgotPassword_Button.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentForgotPassword_Button.setForeground(new java.awt.Color(255, 255, 255));
        studentForgotPassword_Button.setText("Forgot password");
        studentForgotPassword_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentForgotPassword_Button.setBorderPainted(false);
        studentForgotPassword_Button.setContentAreaFilled(false);
        studentForgotPassword_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentForgotPassword_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                studentForgotPassword_ButtonMouseReleased(evt);
            }
        });
        studentForgotPassword_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentForgotPassword_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentForgotPassword_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

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

        studentEmail_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Email_Field.png"))); // NOI18N
        getContentPane().add(studentEmail_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 290, -1, -1));

        studentPassword_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Password_Field.png"))); // NOI18N
        getContentPane().add(studentPassword_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 330, -1, -1));

        studentLogin_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/LoginFrame.png"))); // NOI18N
        getContentPane().add(studentLogin_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new StartFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void studentForgotPassword_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentForgotPassword_ButtonActionPerformed
        new StudentForgotPassword1Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_studentForgotPassword_ButtonActionPerformed

    private void studentForgotPassword_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentForgotPassword_ButtonMouseReleased
        studentForgotPassword_Button.setForeground(Color.white);
    }//GEN-LAST:event_studentForgotPassword_ButtonMouseReleased

    private void studentForgotPassword_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentForgotPassword_ButtonMousePressed
        studentForgotPassword_Button.setForeground(Color.lightGray);
    }//GEN-LAST:event_studentForgotPassword_ButtonMousePressed

    private void studentLogin_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogin_ButtonMouseReleased
        studentLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Button.png")));
    }//GEN-LAST:event_studentLogin_ButtonMouseReleased

    private void studentLogin_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogin_ButtonMousePressed
        studentLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_ButtonClick.png")));
    }//GEN-LAST:event_studentLogin_ButtonMousePressed

    private void studentPassword_Login_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentPassword_Login_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPassword_Login_FieldActionPerformed

    private void studentPassword_Login_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPassword_Login_FieldFocusLost
         DefaultText(studentPassword_Login_Field, "Password", DefaultFocus.LOST);
    }//GEN-LAST:event_studentPassword_Login_FieldFocusLost

    private void studentPassword_Login_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentPassword_Login_FieldFocusGained
         DefaultText(studentPassword_Login_Field, "Password", DefaultFocus.GAINED);
    }//GEN-LAST:event_studentPassword_Login_FieldFocusGained

    private void studentEmail_Login_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentEmail_Login_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentEmail_Login_FieldActionPerformed

    private void studentEmail_Login_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentEmail_Login_FieldFocusLost
         DefaultText(studentEmail_Login_Field, "CvSU Email", DefaultFocus.LOST);
    }//GEN-LAST:event_studentEmail_Login_FieldFocusLost

    private void studentEmail_Login_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentEmail_Login_FieldFocusGained
            DefaultText(studentEmail_Login_Field, "CvSU Email", DefaultFocus.GAINED);
    }//GEN-LAST:event_studentEmail_Login_FieldFocusGained

    private void checkPassword_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassword_CheckboxActionPerformed
        if(checkPassword_Checkbox.isSelected()){
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/showPass_Button.png")));
            studentPassword_Login_Field.setEchoChar((char)0);
        } else {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/hidePass_Button.png")));
            studentPassword_Login_Field.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPassword_CheckboxActionPerformed

    private void studentLogin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentLogin_ButtonActionPerformed
        if (checkLogin()) {
        dispose();
        new StudentHome().setVisible(true);
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "CvSU Email and Password do not match.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_studentLogin_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginStudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkPassword_Checkbox;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel studentEmail_Label;
    private javax.swing.JTextField studentEmail_Login_Field;
    private javax.swing.JButton studentForgotPassword_Button;
    private javax.swing.JLabel studentLogin_Background;
    private javax.swing.JButton studentLogin_Button;
    private javax.swing.JLabel studentPassword_Label;
    private javax.swing.JPasswordField studentPassword_Login_Field;
    // End of variables declaration//GEN-END:variables
}
