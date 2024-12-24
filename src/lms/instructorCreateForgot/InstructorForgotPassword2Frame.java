package lms.instructorCreateForgot;

public class InstructorForgotPassword2Frame extends javax.swing.JFrame {

    public InstructorForgotPassword2Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructorReset_Answer_Field = new javax.swing.JTextField();
        instructor_ResetPass_Button = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        instructor_Answer_Label = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        instructorQuestion_Combobox = new javax.swing.JComboBox<>();
        instructorResetPass_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Password Reset for Instructor");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructorReset_Answer_Field.setBackground(new java.awt.Color(33, 125, 23));
        instructorReset_Answer_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructorReset_Answer_Field.setForeground(new java.awt.Color(255, 255, 255));
        instructorReset_Answer_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(instructorReset_Answer_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 280, 20));

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

        label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Forgot Password?");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        question.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(255, 255, 255));
        question.setText("Question:");
        getContentPane().add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 238, -1, -1));

        instructor_Answer_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(instructor_Answer_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 305, -1, -1));

        answer.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        answer.setForeground(new java.awt.Color(255, 255, 255));
        answer.setText("Answer:");
        getContentPane().add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

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

        instructorQuestion_Combobox.setBackground(new java.awt.Color(33, 125, 23));
        instructorQuestion_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructorQuestion_Combobox.setForeground(new java.awt.Color(255, 255, 255));
        instructorQuestion_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is the name of the school where you completed your student teaching?", "What was the name of the first school where you taught?", "What year did you start working at CvSU?", "Who was the school administrator on your first year working at CvSU?", "What was your first advisory section?", "What was grade level of your first teaching position?", "What is the name of your favorite subject to teach?", "What was the title of the first course you taught?", " " }));
        instructorQuestion_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(instructorQuestion_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 560, -1));

        instructorResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/ForgotPass.png"))); // NOI18N
        getContentPane().add(instructorResetPass_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void instructor_ResetPass_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructor_ResetPass_ButtonMousePressed
        instructor_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_ButtonClick.png")));
    }//GEN-LAST:event_instructor_ResetPass_ButtonMousePressed

    private void instructor_ResetPass_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructor_ResetPass_ButtonMouseReleased
        instructor_ResetPass_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/ResetPassword_Button.png")));
    }//GEN-LAST:event_instructor_ResetPass_ButtonMouseReleased

    private void instructor_ResetPass_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructor_ResetPass_ButtonActionPerformed
        new InstructorNewPassFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_instructor_ResetPass_ButtonActionPerformed

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new InstructorForgotPassword1Frame().setVisible(true);
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
            java.util.logging.Logger.getLogger(InstructorForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorForgotPassword2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorForgotPassword2Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answer;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JComboBox<String> instructorQuestion_Combobox;
    private javax.swing.JLabel instructorResetPass_Background;
    private javax.swing.JTextField instructorReset_Answer_Field;
    private javax.swing.JLabel instructor_Answer_Label;
    private javax.swing.JButton instructor_ResetPass_Button;
    private javax.swing.JLabel label;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
