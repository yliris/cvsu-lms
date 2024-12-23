package lms.instructorCreateForgot;

import lms.InstructorHomeFrame;
import lms.UtilityMethods.DefaultFocus;
import static lms.UtilityMethods.DefaultText;

public class InstructorNewPassFrame extends javax.swing.JFrame {

    public InstructorNewPassFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkPassword_Checkbox = new javax.swing.JCheckBox();
        InstructorNewPass_Field = new javax.swing.JPasswordField();
        InstructorConfirmPass_Field = new javax.swing.JPasswordField();
        instructor_ResetPass_Button = new javax.swing.JButton();
        newpass = new javax.swing.JLabel();
        instructor_Pass_Label = new javax.swing.JLabel();
        confirmpass = new javax.swing.JLabel();
        instructor_Pass_Label1 = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        instructorResetPass_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Password Reset for Instructor");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkPassword_Checkbox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/hidePass_Button.png"))); // NOI18N
        checkPassword_Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPassword_CheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(checkPassword_Checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 240, -1, -1));

        InstructorNewPass_Field.setBackground(new java.awt.Color(33, 125, 23));
        InstructorNewPass_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        InstructorNewPass_Field.setForeground(new java.awt.Color(255, 255, 255));
        InstructorNewPass_Field.setText("Password");
        InstructorNewPass_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        InstructorNewPass_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InstructorNewPass_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InstructorNewPass_FieldFocusLost(evt);
            }
        });
        getContentPane().add(InstructorNewPass_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 260, 20));

        InstructorConfirmPass_Field.setBackground(new java.awt.Color(33, 125, 23));
        InstructorConfirmPass_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        InstructorConfirmPass_Field.setForeground(new java.awt.Color(255, 255, 255));
        InstructorConfirmPass_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        InstructorConfirmPass_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InstructorConfirmPass_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InstructorConfirmPass_FieldFocusLost(evt);
            }
        });
        getContentPane().add(InstructorConfirmPass_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 260, -1));

        instructor_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_Button.png"))); // NOI18N
        instructor_ResetPass_Button.setToolTipText("");
        instructor_ResetPass_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructor_ResetPass_Button.setBorderPainted(false);
        instructor_ResetPass_Button.setContentAreaFilled(false);
        instructor_ResetPass_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                instructor_ResetPass_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instructor_ResetPass_ButtonMouseReleased(evt);
            }
        });
        instructor_ResetPass_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructor_ResetPass_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(instructor_ResetPass_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        newpass.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        newpass.setForeground(new java.awt.Color(255, 255, 255));
        newpass.setText("New password:");
        getContentPane().add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        instructor_Pass_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(instructor_Pass_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 235, -1, -1));

        confirmpass.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        confirmpass.setForeground(new java.awt.Color(255, 255, 255));
        confirmpass.setText("Confirm password:");
        getContentPane().add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        instructor_Pass_Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(instructor_Pass_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 285, -1, -1));

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

        instructorResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/ForgotPass.png"))); // NOI18N
        getContentPane().add(instructorResetPass_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new InstructorForgotPassword2Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

    private void checkPassword_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassword_CheckboxActionPerformed
        if (checkPassword_Checkbox.isSelected()) {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/showPass_Button.png")));
            InstructorNewPass_Field.setEchoChar((char) 0);
            InstructorConfirmPass_Field.setEchoChar((char) 0);
        } else {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/hidePass_Button.png")));
            InstructorNewPass_Field.setEchoChar('*');
            InstructorConfirmPass_Field.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPassword_CheckboxActionPerformed

    private void InstructorNewPass_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InstructorNewPass_FieldFocusGained
        DefaultText(InstructorNewPass_Field, "Password", DefaultFocus.GAINED);
    }//GEN-LAST:event_InstructorNewPass_FieldFocusGained

    private void InstructorNewPass_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InstructorNewPass_FieldFocusLost
        DefaultText(InstructorNewPass_Field, "Password", DefaultFocus.LOST);
    }//GEN-LAST:event_InstructorNewPass_FieldFocusLost

    private void InstructorConfirmPass_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InstructorConfirmPass_FieldFocusGained

    }//GEN-LAST:event_InstructorConfirmPass_FieldFocusGained

    private void InstructorConfirmPass_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InstructorConfirmPass_FieldFocusLost

    }//GEN-LAST:event_InstructorConfirmPass_FieldFocusLost

    private void instructor_ResetPass_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructor_ResetPass_ButtonActionPerformed
        new InstructorHomeFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_instructor_ResetPass_ButtonActionPerformed

    private void instructor_ResetPass_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructor_ResetPass_ButtonMouseReleased
        instructor_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_Button.png")));
    }//GEN-LAST:event_instructor_ResetPass_ButtonMouseReleased

    private void instructor_ResetPass_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructor_ResetPass_ButtonMousePressed
        instructor_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_ButtonClick.png")));
    }//GEN-LAST:event_instructor_ResetPass_ButtonMousePressed

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
            java.util.logging.Logger.getLogger(InstructorNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new InstructorNewPassFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField InstructorConfirmPass_Field;
    private javax.swing.JPasswordField InstructorNewPass_Field;
    private javax.swing.JCheckBox checkPassword_Checkbox;
    private javax.swing.JLabel confirmpass;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel instructorResetPass_Background;
    private javax.swing.JLabel instructor_Pass_Label;
    private javax.swing.JLabel instructor_Pass_Label1;
    private javax.swing.JButton instructor_ResetPass_Button;
    private javax.swing.JLabel newpass;
    // End of variables declaration//GEN-END:variables
}
