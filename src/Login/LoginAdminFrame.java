package Login;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Home.AdminHome;
import Components.UtilityMethods.DefaultFocus;
import static Components.UtilityMethods.DefaultText;
import static Components.UtilityMethods.TransparentField;

public class LoginAdminFrame extends javax.swing.JFrame {
   
 
    public LoginAdminFrame() {
        initComponents();
        TransparentField(adminEmail_Login_Field, adminPassword_Login_Field);
    }
    
    public boolean checkLogin() {
    String enteredEmail = adminEmail_Login_Field.getText().trim();
    String enteredPassword = new String(adminPassword_Login_Field.getPassword()).trim();  // Get entered password

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", "")) {
        String query = "SELECT CvSU_Mail, Password FROM tb_createinstructor WHERE CvSU_Mail = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, enteredEmail);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String dbEmail = rs.getString("CvSU_Mail");
            String dbPassword = rs.getString("Password");

            // Check if the entered email and password match the database values
            if (enteredEmail.equals(dbEmail) && enteredPassword.equals(dbPassword)) {
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
        adminEmail_Login_Field = new javax.swing.JTextField();
        adminPassword_Login_Field = new javax.swing.JPasswordField();
        adminLogin_Button = new javax.swing.JButton();
        goBack_Button = new javax.swing.JButton();
        email = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Admin Login");
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

        adminEmail_Login_Field.setBackground(new java.awt.Color(33, 125, 23));
        adminEmail_Login_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        adminEmail_Login_Field.setForeground(new java.awt.Color(255, 255, 255));
        adminEmail_Login_Field.setText("CvSU Email");
        adminEmail_Login_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        adminEmail_Login_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminEmail_Login_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adminEmail_Login_FieldFocusLost(evt);
            }
        });
        getContentPane().add(adminEmail_Login_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 200, 30));

        adminPassword_Login_Field.setBackground(new java.awt.Color(33, 125, 23));
        adminPassword_Login_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        adminPassword_Login_Field.setForeground(new java.awt.Color(255, 255, 255));
        adminPassword_Login_Field.setText("Password");
        adminPassword_Login_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        adminPassword_Login_Field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminPassword_Login_FieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adminPassword_Login_FieldFocusLost(evt);
            }
        });
        adminPassword_Login_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPassword_Login_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(adminPassword_Login_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 180, 30));

        adminLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Button.png"))); // NOI18N
        adminLogin_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        adminLogin_Button.setBorderPainted(false);
        adminLogin_Button.setContentAreaFilled(false);
        adminLogin_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminLogin_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adminLogin_ButtonMouseReleased(evt);
            }
        });
        adminLogin_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLogin_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adminLogin_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 410, -1, -1));

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

        email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Email_Field.png"))); // NOI18N
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 290, -1, -1));

        pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fields/Password_Field.png"))); // NOI18N
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 330, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/LoginFrame.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void adminLogin_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLogin_ButtonMouseReleased
        adminLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Button.png")));
    }//GEN-LAST:event_adminLogin_ButtonMouseReleased

    private void adminLogin_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLogin_ButtonMousePressed
        adminLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_ButtonClick.png")));
    }//GEN-LAST:event_adminLogin_ButtonMousePressed

    private void adminPassword_Login_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPassword_Login_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminPassword_Login_FieldActionPerformed

    private void adminPassword_Login_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminPassword_Login_FieldFocusLost
       DefaultText(adminPassword_Login_Field, "Password", DefaultFocus.LOST);

    }//GEN-LAST:event_adminPassword_Login_FieldFocusLost

    private void adminPassword_Login_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminPassword_Login_FieldFocusGained
        DefaultText(adminPassword_Login_Field, "Password", DefaultFocus.GAINED);
    }//GEN-LAST:event_adminPassword_Login_FieldFocusGained

    private void adminEmail_Login_FieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminEmail_Login_FieldFocusLost
        DefaultText(adminEmail_Login_Field, "CvSU Email", DefaultFocus.LOST);
    }//GEN-LAST:event_adminEmail_Login_FieldFocusLost

    private void adminEmail_Login_FieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminEmail_Login_FieldFocusGained
       DefaultText(adminEmail_Login_Field, "CvSU Email", DefaultFocus.GAINED);
    }//GEN-LAST:event_adminEmail_Login_FieldFocusGained

    private void checkPassword_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPassword_CheckboxActionPerformed
        if (checkPassword_Checkbox.isSelected()) {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/showPass_Button.png")));
            adminPassword_Login_Field.setEchoChar((char) 0);
        } else {
            checkPassword_Checkbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/hidePass_Button.png")));
            adminPassword_Login_Field.setEchoChar('*');
        }
    }//GEN-LAST:event_checkPassword_CheckboxActionPerformed

    private void adminLogin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLogin_ButtonActionPerformed
        String admin = adminEmail_Login_Field.getText().trim();
        String password = String.valueOf(adminPassword_Login_Field.getPassword()).trim();

        if ("admin@cvsu.edu.ph".equalsIgnoreCase(admin) && "a1d2m3i4n5".equals(password)) {
            JOptionPane.showMessageDialog(null, "Admin Login Success!");
            dispose();
            new AdminHome(-1).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_adminLogin_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new LoginAdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminEmail_Login_Field;
    private javax.swing.JButton adminLogin_Button;
    private javax.swing.JPasswordField adminPassword_Login_Field;
    private javax.swing.JLabel background;
    private javax.swing.JCheckBox checkPassword_Checkbox;
    private javax.swing.JLabel email;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JLabel pass;
    // End of variables declaration//GEN-END:variables
}
