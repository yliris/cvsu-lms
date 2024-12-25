package lms.studentCreateForgot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lms.instructorCreateForgot.InstructorNewPassFrame;

public class StudentForgotPassword2Frame extends javax.swing.JFrame {

    private String username;
    private String securityQuestion = getSecurityQuestionFromDatabase(username);

    public StudentForgotPassword2Frame(String username, String securityQuestion) {
        this.username = username;
        this.securityQuestion = securityQuestion;
        initComponents();
        setSecurityQuestionInComboBox(securityQuestion);
    }

    private boolean validateAnswer(String username, String question, String answer) {
        boolean isValid = false;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", ""); 
                PreparedStatement stmt = conn.prepareStatement("SELECT ValidationAnswer FROM tb_createstudent WHERE CvSU_Email = ? AND SecurityQuestion = ?")) {

            stmt.setString(1, username);
            stmt.setString(2, question);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getString("ValidationAnswer").equals(answer)) {
                isValid = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentReset_Answer_Field = new javax.swing.JTextField();
        student_ResetPass_Button = new javax.swing.JButton();
        studentQuestion_Combobox = new javax.swing.JComboBox<>();
        label = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        student_Answer_Label = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
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
        getContentPane().add(studentReset_Answer_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 280, 20));

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

        studentQuestion_Combobox.setBackground(new java.awt.Color(33, 125, 23));
        studentQuestion_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        studentQuestion_Combobox.setForeground(new java.awt.Color(255, 255, 255));
        studentQuestion_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a question.", "What year did you start your studies at this school?", "Who was the school administrator during your time?", "Who was your adviser during your first year at CvSU?", "What is the name of your favorite class or course?", "What is the name of the first class you ever attended at your current school?", "What year did you graduate from your previous school?", " " }));
        studentQuestion_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(studentQuestion_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 560, -1));

        label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Forgot Password?");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        question.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(255, 255, 255));
        question.setText("Question:");
        getContentPane().add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 238, -1, -1));

        student_Answer_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Empty_FieldLong.png"))); // NOI18N
        getContentPane().add(student_Answer_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 305, -1, -1));

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

        studentResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/ForgotPass.png"))); // NOI18N
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
        String question = (String) studentQuestion_Combobox.getSelectedItem();
        String answer = studentReset_Answer_Field.getText();

        if (validateAnswer(username, question, answer)) {
            JOptionPane.showMessageDialog(null, "Answer validated successfully. Proceed to reset password.");
            new StudentNewPassFrame(username).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer. Please try again.");
        }
    }

    private void setSecurityQuestionInComboBox(String securityQuestion) {
        boolean questionExists = false;
        if (securityQuestion != null && !securityQuestion.isEmpty()) {
            for (int i = 0; i < studentQuestion_Combobox.getItemCount(); i++) {
                if (studentQuestion_Combobox.getItemAt(i).equals(securityQuestion)) {
                    studentQuestion_Combobox.setSelectedItem(securityQuestion);
                    questionExists = true;
                    break;
                }
            }

            if (!questionExists) {
                JOptionPane.showMessageDialog(null, "The security question is not available in the list.");
            } else {
                JOptionPane.showMessageDialog(null, "CvSU Mail confirmed, proceed to validation section.");
            }
        }
    }

    private String getSecurityQuestionFromDatabase(String username) {
        String securityQuestion = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish database connection (make sure the connection URL, username, password are correct)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", "");

            // SQL query to get the security question based on the username
            String sql = "SELECT SecurityQuestion FROM tb_createstudent WHERE CvSU_Email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username); // Set the username in the query

            rs = stmt.executeQuery();

            // If a matching record is found, retrieve the security question
            if (rs.next()) {
                securityQuestion = rs.getString("SecurityQuestion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return securityQuestion;


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
                String username = "cj@cvsu";
                String securityQuestion = "What year did you start your studies at this school?";
                new StudentForgotPassword2Frame(username, securityQuestion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answer;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel label;
    private javax.swing.JLabel question;
    private javax.swing.JComboBox<String> studentQuestion_Combobox;
    private javax.swing.JLabel studentResetPass_Background;
    private javax.swing.JTextField studentReset_Answer_Field;
    private javax.swing.JLabel student_Answer_Label;
    private javax.swing.JButton student_ResetPass_Button;
    // End of variables declaration//GEN-END:variables
}
