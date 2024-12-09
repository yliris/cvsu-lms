package lms.instructorCreateForgot;
import lms.LoginInstructorFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InstructorCreateAccount1Frame extends javax.swing.JFrame {

    public InstructorCreateAccount1Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructorName_Label = new javax.swing.JLabel();
        instructorMail_Label = new javax.swing.JLabel();
        instructorID_Label = new javax.swing.JLabel();
        instructorDept_Combobox = new javax.swing.JComboBox<>();
        createInstructorName_Field = new javax.swing.JTextField();
        createInstructorMail_Field = new javax.swing.JTextField();
        createInstructorID_Field = new javax.swing.JTextField();
        next_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        goBack_Button = new javax.swing.JButton();
        createAccount_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Create Account as Instructor");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructorName_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        instructorName_Label.setForeground(new java.awt.Color(255, 255, 255));
        instructorName_Label.setText("Name:");
        getContentPane().add(instructorName_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 175, -1, -1));

        instructorMail_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        instructorMail_Label.setForeground(new java.awt.Color(255, 255, 255));
        instructorMail_Label.setText("CvSU Mail:");
        getContentPane().add(instructorMail_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 217, -1, -1));

        instructorID_Label.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        instructorID_Label.setForeground(new java.awt.Color(255, 255, 255));
        instructorID_Label.setText("Employee ID:");
        getContentPane().add(instructorID_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 257, -1, -1));

        instructorDept_Combobox.setBackground(new java.awt.Color(33, 125, 23));
        instructorDept_Combobox.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        instructorDept_Combobox.setForeground(new java.awt.Color(255, 255, 255));
        instructorDept_Combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIT" }));
        instructorDept_Combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(instructorDept_Combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 300, -1));

        createInstructorName_Field.setBackground(new java.awt.Color(33, 125, 23));
        createInstructorName_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createInstructorName_Field.setForeground(new java.awt.Color(255, 255, 255));
        createInstructorName_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(createInstructorName_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 175, 280, -1));

        createInstructorMail_Field.setBackground(new java.awt.Color(33, 125, 23));
        createInstructorMail_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createInstructorMail_Field.setForeground(new java.awt.Color(255, 255, 255));
        createInstructorMail_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(createInstructorMail_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 215, 280, -1));

        createInstructorID_Field.setBackground(new java.awt.Color(33, 125, 23));
        createInstructorID_Field.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        createInstructorID_Field.setForeground(new java.awt.Color(255, 255, 255));
        createInstructorID_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(createInstructorID_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 255, 280, -1));

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
        jLabel4.setText("Department:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 302, -1, -1));

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
            String InstName;
            String InstMail;
            String InstID;
            String InstDept;
            String query;

             try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
               
               String url = "jdbc:mysql://localhost:3306/lms_project";
               String user = "root";
               String pass = "";
               
               boolean isValid = true;
               
               Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
               if("".equals(createInstructorName_Field.getText().trim())){
                   JOptionPane.showMessageDialog(new JFrame(), "Name is required", "Dialog", JOptionPane.ERROR_MESSAGE);
                   isValid = false;
               }
               else if("".equals(createInstructorMail_Field.getText().trim())){
                   JOptionPane.showMessageDialog(new JFrame(), "CvSU Mail is required", "Dialog", JOptionPane.ERROR_MESSAGE);
                   isValid = false;
               }
               else if("".equals(createInstructorID_Field.getText().trim())){
                   JOptionPane.showMessageDialog(new JFrame(), "ID is required", "Dialog", JOptionPane.ERROR_MESSAGE);
                   isValid = false;
               }
               else if("".equals((String) instructorDept_Combobox.getSelectedItem())){
                   JOptionPane.showMessageDialog(new JFrame(), "Department is required", "Dialog", JOptionPane.ERROR_MESSAGE);
                   isValid = false;
               }
        
               else {
                   InstName = createInstructorName_Field.getText().trim();
                   InstMail = createInstructorMail_Field.getText().trim();
                   InstID = createInstructorID_Field.getText().trim();
                   InstDept = (String) instructorDept_Combobox.getSelectedItem();
        
                   query = "INSERT INTO tb_createinstructor(Name, CvSU_Mail, EmployeeID, Department) VALUES (?, ?, ?, ?)";
               try {
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, InstName);
                        pst.setString(2, InstMail);
                        pst.setString(3, InstID);
                        pst.setString(4, InstDept);
                        
                        pst.executeUpdate();
                                              
                     JOptionPane.showMessageDialog(new JFrame(), "Proceed to Password Section", "Success", JOptionPane.INFORMATION_MESSAGE);
                     
                     new InstructorCreateAccount2Frame(InstName, InstMail, InstID, InstDept).setVisible(true);
                      dispose();
                      
                     } catch (Exception e){
                        System.out.println("Error "+ e.getMessage());
                        JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
                     }}
    }//GEN-LAST:event_next_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorCreateAccount1Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createAccount_Background;
    private javax.swing.JTextField createInstructorID_Field;
    private javax.swing.JTextField createInstructorMail_Field;
    private javax.swing.JTextField createInstructorName_Field;
    private javax.swing.JButton goBack_Button;
    private javax.swing.JComboBox<String> instructorDept_Combobox;
    private javax.swing.JLabel instructorID_Label;
    private javax.swing.JLabel instructorMail_Label;
    private javax.swing.JLabel instructorName_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton next_Button;
    // End of variables declaration//GEN-END:variables
}
