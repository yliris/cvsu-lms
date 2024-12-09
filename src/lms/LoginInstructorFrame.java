package lms;

import lms.instructorCreateForgot.InstructorForgotPassword1Frame;
import lms.instructorCreateForgot.InstructorCreateAccount1Frame;
import java.awt.Color;

public class LoginInstructorFrame extends javax.swing.JFrame {

    public LoginInstructorFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkPassword_Checkbox = new javax.swing.JCheckBox();
        instructorEmail_Login_Field = new javax.swing.JTextField();
        instructorPassword_Login_Field = new javax.swing.JPasswordField();
        instructorLogin_Button = new javax.swing.JButton();
        instructorForgotPassword_Button = new javax.swing.JButton();
        goBack_Button = new javax.swing.JButton();
        instructorEmail_Label = new javax.swing.JLabel();
        instructorPassword_Label = new javax.swing.JLabel();
        instructorCreateAccount_Button = new javax.swing.JButton();
        instructorLogin_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Instructor Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkPassword_Checkbox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/hidePass_Button.png"))); // NOI18N
        checkPassword_Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPassword_CheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(checkPassword_Checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 335, -1, -1));

        instructorEmail_Login_Field.setBackground(new java.awt.Color(33, 125, 23));
        instructorEmail_Login_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructorEmail_Login_Field.setForeground(new java.awt.Color(255, 255, 255));
        instructorEmail_Login_Field.setText("Email");
        instructorEmail_Login_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructorEmail_Login_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                instructorEmail_Login_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                instructorEmail_Login_FieldFocusLost(evt);
            }
        });
        instructorEmail_Login_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorEmail_Login_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(instructorEmail_Login_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 200, 30));

        instructorPassword_Login_Field.setBackground(new java.awt.Color(33, 125, 23));
        instructorPassword_Login_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructorPassword_Login_Field.setForeground(new java.awt.Color(255, 255, 255));
        instructorPassword_Login_Field.setText("Password");
        instructorPassword_Login_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructorPassword_Login_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                instructorPassword_Login_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                instructorPassword_Login_FieldFocusLost(evt);
            }
        });
        instructorPassword_Login_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorPassword_Login_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(instructorPassword_Login_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 180, 30));

        instructorLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Login_Button.png"))); // NOI18N
        instructorLogin_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructorLogin_Button.setBorderPainted(false);
        instructorLogin_Button.setContentAreaFilled(false);
        instructorLogin_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                instructorLogin_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instructorLogin_ButtonMouseReleased(evt);
            }
        });
        getContentPane().add(instructorLogin_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 410, -1, -1));

        instructorForgotPassword_Button.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructorForgotPassword_Button.setForeground(new java.awt.Color(255, 255, 255));
        instructorForgotPassword_Button.setText("Forgot password");
        instructorForgotPassword_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructorForgotPassword_Button.setBorderPainted(false);
        instructorForgotPassword_Button.setContentAreaFilled(false);
        instructorForgotPassword_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                instructorForgotPassword_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instructorForgotPassword_ButtonMouseReleased(evt);
            }
        });
        instructorForgotPassword_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorForgotPassword_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(instructorForgotPassword_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

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

        instructorEmail_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Email_Field.png"))); // NOI18N
        getContentPane().add(instructorEmail_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 290, -1, -1));

        instructorPassword_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Password_Field.png"))); // NOI18N
        getContentPane().add(instructorPassword_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 330, -1, -1));

        instructorCreateAccount_Button.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructorCreateAccount_Button.setForeground(new java.awt.Color(255, 255, 255));
        instructorCreateAccount_Button.setText("Create Account");
        instructorCreateAccount_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructorCreateAccount_Button.setBorderPainted(false);
        instructorCreateAccount_Button.setContentAreaFilled(false);
        instructorCreateAccount_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                instructorCreateAccount_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instructorCreateAccount_ButtonMouseReleased(evt);
            }
        });
        instructorCreateAccount_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorCreateAccount_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(instructorCreateAccount_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        instructorLogin_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/LoginFrame.png"))); // NOI18N
        getContentPane().add(instructorLogin_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new StartFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void instructorForgotPassword_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorForgotPassword_ButtonActionPerformed
        new InstructorForgotPassword1Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_instructorForgotPassword_ButtonActionPerformed

    private void instructorForgotPassword_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorForgotPassword_ButtonMouseReleased
        instructorForgotPassword_Button.setForeground(Color.white);
    }//GEN-LAST:event_instructorForgotPassword_ButtonMouseReleased

    private void instructorForgotPassword_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorForgotPassword_ButtonMousePressed
        instructorForgotPassword_Button.setForeground(Color.lightGray);
    }//GEN-LAST:event_instructorForgotPassword_ButtonMousePressed

    private void instructorLogin_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorLogin_ButtonMouseReleased
        instructorLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Login_Button.png")));
    }//GEN-LAST:event_instructorLogin_ButtonMouseReleased

    private void instructorLogin_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorLogin_ButtonMousePressed
        instructorLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Login_ButtonClick.png")));
    }//GEN-LAST:event_instructorLogin_ButtonMousePressed

    private void instructorPassword_Login_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorPassword_Login_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instructorPassword_Login_FieldActionPerformed

    private void instructorPassword_Login_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_instructorPassword_Login_FieldFocusLost
        if(instructorPassword_Login_Field.getText().equals("")){
            instructorPassword_Login_Field.setText("Password");
        }
    }//GEN-LAST:event_instructorPassword_Login_FieldFocusLost

    private void instructorPassword_Login_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_instructorPassword_Login_FieldFocusGained
        if(instructorPassword_Login_Field.getText().equals("Password")){
            instructorPassword_Login_Field.setText("");
        }
    }//GEN-LAST:event_instructorPassword_Login_FieldFocusGained

    private void instructorEmail_Login_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorEmail_Login_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instructorEmail_Login_FieldActionPerformed

    private void instructorEmail_Login_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_instructorEmail_Login_FieldFocusLost
        if(instructorEmail_Login_Field.getText().equals("")){
            instructorEmail_Login_Field.setText("Email");
        }
    }//GEN-LAST:event_instructorEmail_Login_FieldFocusLost

    private void instructorEmail_Login_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_instructorEmail_Login_FieldFocusGained
        if(instructorEmail_Login_Field.getText().equals("Email")){
            instructorEmail_Login_Field.setText("");
        }
    }//GEN-LAST:event_instructorEmail_Login_FieldFocusGained

    private void checkPassword_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassword_CheckboxActionPerformed
        if(checkPassword_Checkbox.isSelected()){
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/showPass_Button.png")));
            instructorPassword_Login_Field.setEchoChar((char)0);
        } else {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/hidePass_Button.png")));
            instructorPassword_Login_Field.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPassword_CheckboxActionPerformed

    private void instructorCreateAccount_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorCreateAccount_ButtonMousePressed
        instructorCreateAccount_Button.setForeground(Color.lightGray);
    }//GEN-LAST:event_instructorCreateAccount_ButtonMousePressed

    private void instructorCreateAccount_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorCreateAccount_ButtonMouseReleased
        instructorCreateAccount_Button.setForeground(Color.white);
    }//GEN-LAST:event_instructorCreateAccount_ButtonMouseReleased

    private void instructorCreateAccount_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorCreateAccount_ButtonActionPerformed
        new InstructorCreateAccount1Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_instructorCreateAccount_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginInstructorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInstructorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInstructorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInstructorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInstructorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkPassword_Checkbox;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JButton instructorCreateAccount_Button;
    private javax.swing.JLabel instructorEmail_Label;
    private javax.swing.JTextField instructorEmail_Login_Field;
    private javax.swing.JButton instructorForgotPassword_Button;
    private javax.swing.JLabel instructorLogin_Background;
    private javax.swing.JButton instructorLogin_Button;
    private javax.swing.JLabel instructorPassword_Label;
    private javax.swing.JPasswordField instructorPassword_Login_Field;
    // End of variables declaration//GEN-END:variables
}
