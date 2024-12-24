package lms.studentCreateForgot;

import lms.StudentHomeFrame;
import lms.UtilityMethods.DefaultFocus;
import static lms.UtilityMethods.DefaultText;

public class StudentNewPassFrame extends javax.swing.JFrame {

    public StudentNewPassFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkPassword_Checkbox = new javax.swing.JCheckBox();
        studentNewPass_Field = new javax.swing.JPasswordField();
        studentConfirmPass_Field = new javax.swing.JPasswordField();
        student_ResetPass_Button = new javax.swing.JButton();
        newpass = new javax.swing.JLabel();
        student_Pass_Label = new javax.swing.JLabel();
        confirmpass = new javax.swing.JLabel();
        student_Pass_Label1 = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        studentResetPass_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Password Reset for Student");
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

        studentNewPass_Field.setBackground(new java.awt.Color(33, 125, 23));
        studentNewPass_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentNewPass_Field.setForeground(new java.awt.Color(255, 255, 255));
        studentNewPass_Field.setText("Password");
        studentNewPass_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentNewPass_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentNewPass_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentNewPass_FieldFocusLost(evt);
            }
        });
        getContentPane().add(studentNewPass_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 260, 20));

        studentConfirmPass_Field.setBackground(new java.awt.Color(33, 125, 23));
        studentConfirmPass_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentConfirmPass_Field.setForeground(new java.awt.Color(255, 255, 255));
        studentConfirmPass_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentConfirmPass_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentConfirmPass_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentConfirmPass_FieldFocusLost(evt);
            }
        });
        getContentPane().add(studentConfirmPass_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 260, -1));

        student_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_Button.png"))); // NOI18N
        student_ResetPass_Button.setToolTipText("");
        student_ResetPass_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        student_ResetPass_Button.setBorderPainted(false);
        student_ResetPass_Button.setContentAreaFilled(false);
        student_ResetPass_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                student_ResetPass_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                student_ResetPass_ButtonMouseReleased(evt);
            }
        });
        student_ResetPass_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_ResetPass_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(student_ResetPass_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        newpass.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        newpass.setForeground(new java.awt.Color(255, 255, 255));
        newpass.setText("New password:");
        getContentPane().add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        student_Pass_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(student_Pass_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 235, -1, -1));

        confirmpass.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        confirmpass.setForeground(new java.awt.Color(255, 255, 255));
        confirmpass.setText("Confirm password:");
        getContentPane().add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        student_Pass_Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(student_Pass_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 285, -1, -1));

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

        studentResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/ForgotPass.png"))); // NOI18N
        getContentPane().add(studentResetPass_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        new StudentForgotPassword2Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

    private void checkPassword_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassword_CheckboxActionPerformed
        if (checkPassword_Checkbox.isSelected()) {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/showPass_Button.png")));
            studentNewPass_Field.setEchoChar((char) 0);
            studentConfirmPass_Field.setEchoChar((char) 0);
        } else {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/hidePass_Button.png")));
            studentNewPass_Field.setEchoChar('*');
            studentConfirmPass_Field.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPassword_CheckboxActionPerformed

    private void studentNewPass_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentNewPass_FieldFocusGained
        DefaultText(studentNewPass_Field, "Password", DefaultFocus.GAINED);
    }//GEN-LAST:event_studentNewPass_FieldFocusGained

    private void studentNewPass_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentNewPass_FieldFocusLost
        DefaultText(studentNewPass_Field, "Password", DefaultFocus.LOST);
    }//GEN-LAST:event_studentNewPass_FieldFocusLost

    private void studentConfirmPass_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentConfirmPass_FieldFocusGained

    }//GEN-LAST:event_studentConfirmPass_FieldFocusGained

    private void studentConfirmPass_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentConfirmPass_FieldFocusLost

    }//GEN-LAST:event_studentConfirmPass_FieldFocusLost

    private void student_ResetPass_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_ResetPass_ButtonActionPerformed
        new StudentHomeFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_student_ResetPass_ButtonActionPerformed

    private void student_ResetPass_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_ResetPass_ButtonMouseReleased
        student_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_Button.png")));
    }//GEN-LAST:event_student_ResetPass_ButtonMouseReleased

    private void student_ResetPass_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_ResetPass_ButtonMousePressed
        student_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_ButtonClick.png")));
    }//GEN-LAST:event_student_ResetPass_ButtonMousePressed

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
            java.util.logging.Logger.getLogger(StudentNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentNewPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new StudentNewPassFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkPassword_Checkbox;
    private javax.swing.JLabel confirmpass;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel newpass;
    private javax.swing.JPasswordField studentConfirmPass_Field;
    private javax.swing.JPasswordField studentNewPass_Field;
    private javax.swing.JLabel studentResetPass_Background;
    private javax.swing.JLabel student_Pass_Label;
    private javax.swing.JLabel student_Pass_Label1;
    private javax.swing.JButton student_ResetPass_Button;
    // End of variables declaration//GEN-END:variables
}
