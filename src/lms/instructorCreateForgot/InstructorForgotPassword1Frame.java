package lms.instructorCreateForgot;

import lms.LoginInstructorFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import lms.instructorCreateForgot.InstructorForgotPassword2Frame;



public class InstructorForgotPassword1Frame extends javax.swing.JFrame {
    private String securityQuestion;
    private JComboBox<String> instructorQuestion_Combobox;

    public InstructorForgotPassword1Frame() {
        initComponents();
        
        instructorQuestion_Combobox = new javax.swing.JComboBox<>(new String[] {
            "Select a question.",
            "What is the name of the school where you completed your student teaching?",
            "What was the name of the first school where you taught?",
            "What year did you start working at CvSU?",
            "Who was the school administrator on your first year working at CvSU?",
            "What was your first advisory section?",
            "What was grade level of your first teaching position?",
            "What is the name of your favorite subject to teach?",
            "What was the title of the first course you taught?"
        });
    }
    public void SecurityQuestion(String question){
        this.securityQuestion = question;
        instructorQuestion_Combobox.setSelectedItem(securityQuestion);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack_Button = new javax.swing.JButton();
        instructor_Continue_Button = new javax.swing.JButton();
        instructor_Email_Reset_Field = new javax.swing.JTextField();
        instructor_Email_Label = new javax.swing.JLabel();
        resetInstruction_Label = new javax.swing.JLabel();
        instructorResetPass_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Password Reset for Instructor");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        instructor_Continue_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Continue_Button.png"))); // NOI18N
        instructor_Continue_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        instructor_Continue_Button.setBorderPainted(false);
        instructor_Continue_Button.setContentAreaFilled(false);
        instructor_Continue_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                instructor_Continue_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instructor_Continue_ButtonMouseReleased(evt);
            }
        });
        instructor_Continue_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructor_Continue_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(instructor_Continue_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        instructor_Email_Reset_Field.setBackground(new java.awt.Color(33, 125, 23));
        instructor_Email_Reset_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        instructor_Email_Reset_Field.setForeground(new java.awt.Color(255, 255, 255));
        instructor_Email_Reset_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(instructor_Email_Reset_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 200, 30));

        instructor_Email_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/field/Email_Field.png"))); // NOI18N
        getContentPane().add(instructor_Email_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 260, -1, -1));

        resetInstruction_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/PasswordResetInstruction.png"))); // NOI18N
        getContentPane().add(resetInstruction_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 150, -1, -1));

        instructorResetPass_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/ForgotPassword.png"))); // NOI18N
        getContentPane().add(instructorResetPass_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void instructor_Continue_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructor_Continue_ButtonMouseReleased
        instructor_Continue_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Continue_Button.png")));
    }//GEN-LAST:event_instructor_Continue_ButtonMouseReleased

    private void instructor_Continue_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructor_Continue_ButtonMousePressed
        instructor_Continue_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/Continue_ButtonClick.png")));
    }//GEN-LAST:event_instructor_Continue_ButtonMousePressed

    private void instructor_Continue_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructor_Continue_ButtonActionPerformed
        String username = instructor_Email_Reset_Field.getText(); // Get email input
        String securityQuestion;
        String query;

    // Step 1: Validate if the email field is empty
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter your CvSU Mail.");
        return;
    }

    try {
        // Step 2: Establish database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", "");

        // Step 3: Query the database to retrieve the security question
        query = "SELECT SecurityQuestion FROM tb_createinstructor WHERE CvSU_Mail = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, username); // Set the email parameter

        ResultSet rs = pst.executeQuery();

        // Step 4: Check if the user exists in the database
        if (rs.next()) {
            // If a record is found, retrieve the security question
            securityQuestion = rs.getString("SecurityQuestion");

            // Step 5: Check if the retrieved question exists in the ComboBox
            boolean questionExists = false;
            for (int i = 0; i < instructorQuestion_Combobox.getItemCount(); i++) {
                if (instructorQuestion_Combobox.getItemAt(i).equals(securityQuestion)) {
                    instructorQuestion_Combobox.setSelectedItem(securityQuestion); // Set the selected item
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
                new InstructorForgotPassword2Frame(username, securityQuestion).setVisible(true);  // New frame to handle security question validation
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

    }//GEN-LAST:event_instructor_Continue_ButtonActionPerformed

    private void goBack_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMousePressed
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_ButtonClick(1).png")));
    }//GEN-LAST:event_goBack_ButtonMousePressed

    private void goBack_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_ButtonMouseReleased
        goBack_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/navLeft_Button(1).png")));
    }//GEN-LAST:event_goBack_ButtonMouseReleased

    private void goBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBack_ButtonActionPerformed
        new LoginInstructorFrame().setVisible(true);
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
            java.util.logging.Logger.getLogger(InstructorForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorForgotPassword1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
//    InstructorForgotPassword2Frame secondFrame = new InstructorForgotPassword2Frame();
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorForgotPassword1Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel instructorResetPass_Background;
    private javax.swing.JButton instructor_Continue_Button;
    private javax.swing.JLabel instructor_Email_Label;
    private javax.swing.JTextField instructor_Email_Reset_Field;
    private javax.swing.JLabel resetInstruction_Label;
    // End of variables declaration//GEN-END:variables
}
