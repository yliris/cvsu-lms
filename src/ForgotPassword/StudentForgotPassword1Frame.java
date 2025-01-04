package ForgotPassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Login.LoginStudentFrame;

public class StudentForgotPassword1Frame extends javax.swing.JFrame {
    private String securityQuestion;
    private JComboBox<String> studentQuestion_Combobox;


    public StudentForgotPassword1Frame() {
        initComponents();
        
        studentQuestion_Combobox = new javax.swing.JComboBox<>(new String[] {
            "Select a question.",
            "What year did you start your studies at this school?",
            "Who was the school administrator during your time?",
            "Who was your adviser during your first year at CvSU?",
            "What is the name of your favorite class or course?",
            "What is the name of the first class you ever attended at your current school?",
            "What year did you graduate from your previous school?",
        });
    }
         public void SecurityQuestion(String question){
        this.securityQuestion = question;
        studentQuestion_Combobox.setSelectedItem(securityQuestion);
        
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack_Button = new javax.swing.JButton();
        student_Continue_Button = new javax.swing.JButton();
        student_Email_Reset_Field = new javax.swing.JTextField();
        student_Email_Label = new javax.swing.JLabel();
        resetInstruction_Label = new javax.swing.JLabel();
        studentResetPass_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Password Reset for Student");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        student_Continue_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Continue_Button.png"))); // NOI18N
        student_Continue_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        student_Continue_Button.setBorderPainted(false);
        student_Continue_Button.setContentAreaFilled(false);
        student_Continue_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                student_Continue_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                student_Continue_ButtonMouseReleased(evt);
            }
        });
        student_Continue_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_Continue_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(student_Continue_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        student_Email_Reset_Field.setBackground(new java.awt.Color(33, 125, 23));
        student_Email_Reset_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        student_Email_Reset_Field.setForeground(new java.awt.Color(255, 255, 255));
        student_Email_Reset_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(student_Email_Reset_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 200, 30));

        student_Email_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Email_Field.png"))); // NOI18N
        getContentPane().add(student_Email_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 260, -1, -1));

        resetInstruction_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/PasswordResetInstruction.png"))); // NOI18N
        getContentPane().add(resetInstruction_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 150, -1, -1));

        studentResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/ForgotPassword.png"))); // NOI18N
        getContentPane().add(studentResetPass_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_Continue_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_Continue_ButtonMouseReleased
        student_Continue_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Continue_Button.png")));
    }//GEN-LAST:event_student_Continue_ButtonMouseReleased

    private void student_Continue_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_Continue_ButtonMousePressed
        student_Continue_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Continue_ButtonClick.png")));
    }//GEN-LAST:event_student_Continue_ButtonMousePressed

    private void student_Continue_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_Continue_ButtonActionPerformed
        String username = student_Email_Reset_Field.getText(); // Get email input
        String securityQuestion;
        String query;
        if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter your CvSU Mail.");
        return;
    }

    try {
        // Step 2: Establish database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", "");

        // Step 3: Query the database to retrieve the security question
        query = "SELECT SecurityQuestion FROM tb_createstudent WHERE CvSU_Email = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, username); // Set the email parameter

        ResultSet rs = pst.executeQuery();

        // Step 4: Check if the user exists in the database
        if (rs.next()) {
            // If a record is found, retrieve the security question
            securityQuestion = rs.getString("SecurityQuestion");

            // Step 5: Check if the retrieved question exists in the ComboBox
            boolean questionExists = false;
            for (int i = 0; i < studentQuestion_Combobox.getItemCount(); i++) {
                if (studentQuestion_Combobox.getItemAt(i).equals(securityQuestion)) {
                    studentQuestion_Combobox.setSelectedItem(securityQuestion); // Set the selected item
                    questionExists = true;
                    break;
                }
            }
            // If question is not found in the ComboBox, show an error message
            if (!questionExists) {
                JOptionPane.showMessageDialog(null, "The security question is not available in the list.");
            } else {
                // Step 6: If everything is successful, open the next frame
                // Example: Open a new frame to proceed with 
                new StudentForgotPassword2Frame(username, securityQuestion).setVisible(true);  // New frame to handle security question validation
                dispose();  // Close the current frame (optional)
            }

        } else {
            // If no record is found for the given email
            JOptionPane.showMessageDialog(null, "Please enter a correct CvSU Mail.");
        }

        // Close resources
        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        // Handle exceptions
        e.printStackTrace(); // Print the stack trace for debugging
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
    }
        
    }//GEN-LAST:event_student_Continue_ButtonActionPerformed

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/navLeft_Button(1).png")));
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
            java.util.logging.Logger.getLogger(StudentForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new StudentForgotPassword1Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel resetInstruction_Label;
    private javax.swing.JLabel studentResetPass_Background;
    private javax.swing.JButton student_Continue_Button;
    private javax.swing.JLabel student_Email_Label;
    private javax.swing.JTextField student_Email_Reset_Field;
    // End of variables declaration//GEN-END:variables
}
