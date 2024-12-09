package lms;

public class InstructorHomeFrame extends javax.swing.JFrame {

    public InstructorHomeFrame() {
        initComponents();
        view_Profile_Label.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profile_Button = new javax.swing.JButton();
        view_Profile_Label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        instructor_Home_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_Button.setText("wala pa design");
        profile_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_ButtonMouseExited(evt);
            }
        });
        jPanel1.add(profile_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 70));

        view_Profile_Label.setBackground(new java.awt.Color(255, 255, 255));
        view_Profile_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 11)); // NOI18N
        view_Profile_Label.setForeground(new java.awt.Color(255, 255, 255));
        view_Profile_Label.setText("Click to view profile");
        jPanel1.add(view_Profile_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 80, -1, -1));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 540));

        instructor_Home_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/background/HomePage.png"))); // NOI18N
        getContentPane().add(instructor_Home_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(996, 548));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void profile_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_ButtonMouseEntered
        view_Profile_Label.setVisible(true);
    }//GEN-LAST:event_profile_ButtonMouseEntered

    private void profile_ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_ButtonMouseExited
        view_Profile_Label.setVisible(false);
    }//GEN-LAST:event_profile_ButtonMouseExited

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
            java.util.logging.Logger.getLogger(InstructorHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorHomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel instructor_Home_Background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton profile_Button;
    private javax.swing.JLabel view_Profile_Label;
    // End of variables declaration//GEN-END:variables
}
