package lms.studentCreateForgot;

public class StudentForgotPassword2Frame extends javax.swing.JFrame {

    public StudentForgotPassword2Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentReset_Answer_Field = new javax.swing.JTextField();
        student_ResetPass_Button = new javax.swing.JButton();
        answer = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        student_Answer_Label = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        studentResetPass_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Password Reset for Student");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentReset_Answer_Field.setBackground(new java.awt.Color(33, 125, 23));
        studentReset_Answer_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentReset_Answer_Field.setForeground(new java.awt.Color(255, 255, 255));
        studentReset_Answer_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(studentReset_Answer_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 280, 20));

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
        getContentPane().add(student_ResetPass_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 320, -1, -1));

        answer.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        answer.setForeground(new java.awt.Color(255, 255, 255));
        answer.setText("Answer:");
        getContentPane().add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        question.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(255, 255, 255));
        question.setText("Question:");
        getContentPane().add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 170, -1, -1));

        student_Answer_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(student_Answer_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 215, -1, -1));

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

        studentResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/ForgotPassword.png"))); // NOI18N
        getContentPane().add(studentResetPass_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_ResetPass_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_ResetPass_ButtonMousePressed
        student_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_ButtonClick.png")));
    }//GEN-LAST:event_student_ResetPass_ButtonMousePressed

    private void student_ResetPass_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_ResetPass_ButtonMouseReleased
        student_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_Button.png")));
    }//GEN-LAST:event_student_ResetPass_ButtonMouseReleased

    private void student_ResetPass_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_ResetPass_ButtonActionPerformed
        
    }//GEN-LAST:event_student_ResetPass_ButtonActionPerformed

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new StudentForgotPassword1Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBack_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new StudentForgotPassword2Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answer;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel question;
    private javax.swing.JLabel studentResetPass_Background;
    private javax.swing.JTextField studentReset_Answer_Field;
    private javax.swing.JLabel student_Answer_Label;
    private javax.swing.JButton student_ResetPass_Button;
    // End of variables declaration//GEN-END:variables
}
