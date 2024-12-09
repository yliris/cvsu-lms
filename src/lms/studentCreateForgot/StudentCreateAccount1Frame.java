package lms.studentCreateForgot;

import lms.LoginStudentFrame;

public class StudentCreateAccount1Frame extends javax.swing.JFrame {

    public StudentCreateAccount1Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentName_Label = new javax.swing.JLabel();
        studentMail_Label = new javax.swing.JLabel();
        studentID_Label = new javax.swing.JLabel();
        studentDept_Combobox = new javax.swing.JComboBox<>();
        createStudentName_Field = new javax.swing.JTextField();
        createStudentMail_Field = new javax.swing.JTextField();
        createStudentID_Field = new javax.swing.JTextField();
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

        studentDept_Combobox.setBackground(new java.awt.Color(33, 125, 23));
        studentDept_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        studentDept_Combobox.setForeground(new java.awt.Color(255, 255, 255));
        studentDept_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS in Computer Science" }));
        studentDept_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(studentDept_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 300, -1));

        createStudentName_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentName_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentName_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentName_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(createStudentName_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 175, 280, -1));

        createStudentMail_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentMail_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentMail_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentMail_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(createStudentMail_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 215, 280, -1));

        createStudentID_Field.setBackground(new java.awt.Color(33, 125, 23));
        createStudentID_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createStudentID_Field.setForeground(new java.awt.Color(255, 255, 255));
        createStudentID_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(createStudentID_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 255, 280, -1));

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
        new StudentCreateAccount2Frame().setVisible(true);
        dispose();
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
    private javax.swing.JTextField createStudentID_Field;
    private javax.swing.JTextField createStudentMail_Field;
    private javax.swing.JTextField createStudentName_Field;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton next_Button;
    private javax.swing.JComboBox<String> studentDept_Combobox;
    private javax.swing.JLabel studentID_Label;
    private javax.swing.JLabel studentMail_Label;
    private javax.swing.JLabel studentName_Label;
    // End of variables declaration//GEN-END:variables
}
