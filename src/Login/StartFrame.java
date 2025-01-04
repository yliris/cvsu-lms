package Login;

import Home.AdminHome;
import java.awt.Color;

public class StartFrame extends javax.swing.JFrame {

    public StartFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminLogin_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        instructorLogin_Button = new javax.swing.JButton();
        studentLogin_Button = new javax.swing.JButton();
        start_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System (LMS)");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminLogin_Button.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        adminLogin_Button.setForeground(new java.awt.Color(255, 255, 255));
        adminLogin_Button.setText("Admin");
        adminLogin_Button.setBorder(null);
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
        getContentPane().add(adminLogin_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign in as");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, -1, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login as:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 340, -1, -1));

        instructorLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Instructor_Button.png"))); // NOI18N
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
        instructorLogin_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorLogin_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(instructorLogin_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        studentLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Student_Button.png"))); // NOI18N
        studentLogin_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentLogin_Button.setBorderPainted(false);
        studentLogin_Button.setContentAreaFilled(false);
        studentLogin_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentLogin_ButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                studentLogin_ButtonMouseReleased(evt);
            }
        });
        studentLogin_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentLogin_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentLogin_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));

        start_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/StartFrame.png"))); // NOI18N
        getContentPane().add(start_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        //BUTTON MOUSE EVENT START
    private void instructorLogin_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorLogin_ButtonMousePressed
        instructorLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Instructor_ButtonClick.png")));
    }//GEN-LAST:event_instructorLogin_ButtonMousePressed

    private void instructorLogin_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorLogin_ButtonMouseReleased
        instructorLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Instructor_Button.png")));
    }//GEN-LAST:event_instructorLogin_ButtonMouseReleased

    private void studentLogin_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogin_ButtonMousePressed
        studentLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Student_ButtonClick.png")));
    }//GEN-LAST:event_studentLogin_ButtonMousePressed

    private void studentLogin_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentLogin_ButtonMouseReleased
        studentLogin_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/Login_Student_Button.png")));
    }//GEN-LAST:event_studentLogin_ButtonMouseReleased
        //BUTTON MOUSE EVENT END

    private void instructorLogin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorLogin_ButtonActionPerformed
        new LoginInstructorFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_instructorLogin_ButtonActionPerformed

    private void studentLogin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentLogin_ButtonActionPerformed
        new LoginStudentFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_studentLogin_ButtonActionPerformed

    private void adminLogin_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLogin_ButtonActionPerformed
  
        new LoginAdminFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_adminLogin_ButtonActionPerformed

    private void adminLogin_ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLogin_ButtonMousePressed
        adminLogin_Button.setForeground(Color.lightGray);
    }//GEN-LAST:event_adminLogin_ButtonMousePressed

    private void adminLogin_ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLogin_ButtonMouseReleased
        adminLogin_Button.setForeground(Color.white);
    }//GEN-LAST:event_adminLogin_ButtonMouseReleased

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
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLogin_Button;
    private javax.swing.JButton instructorLogin_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel start_Background;
    private javax.swing.JButton studentLogin_Button;
    // End of variables declaration//GEN-END:variables
}
