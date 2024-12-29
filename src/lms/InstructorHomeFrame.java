package lms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import lms.homeMenu.MenuItem;
import lms.instructorForm.About;
import lms.instructorForm.Courses;
import lms.instructorForm.Class;
import lms.instructorForm.Dashboard1;
import lms.instructorForm.Dashboard2;
import lms.instructorForm.Dashboard3;
import lms.instructorForm.Home;
import lms.instructorForm.Profile;

public class InstructorHomeFrame extends javax.swing.JFrame {

    public InstructorHomeFrame() {
        initComponents();
        execute();
    }
    
    private void execute(){
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/lms/homeMenu/home.png"));
        ImageIcon iconDashboard = new ImageIcon(getClass().getResource("/lms/homeMenu/dashboard.png"));
        ImageIcon iconCourses = new ImageIcon(getClass().getResource("/lms/homeMenu/course.png"));
        ImageIcon iconClass = new ImageIcon(getClass().getResource("/lms/homeMenu/class.png"));
        ImageIcon iconProfile = new ImageIcon(getClass().getResource("/lms/homeMenu/profile.png"));
        ImageIcon iconAbout = new ImageIcon(getClass().getResource("/lms/homeMenu/about.png"));
        ImageIcon iconLogout = new ImageIcon(getClass().getResource("/lms/homeMenu/logout.png"));
        ImageIcon iconSubmenu = new ImageIcon(getClass().getResource("/lms/homeMenu/submenu.png"));
        
        //SUBMENU FOR DASHBOARD (ADJUST IF NEEDED)
        MenuItem menuDashboard1 = new MenuItem(iconSubmenu, "DASHBOARD 001", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new Dashboard1());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuDashboard2 = new MenuItem(iconSubmenu, "DASHBOARD 002", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Dashboard2());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuDashboard3 = new MenuItem(iconSubmenu, "DASHBOARD 003", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Dashboard3());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuHome = new MenuItem(iconHome, "HOME", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Home());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuDashboard = new MenuItem(iconDashboard, "DASHBOARD", null, menuDashboard1, menuDashboard2, menuDashboard3);
        
        MenuItem menuCourses = new MenuItem(iconCourses, "COURSES", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Courses());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuClass = new MenuItem(iconClass, "CLASS", new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Class());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuProfile = new MenuItem(iconProfile, "PROFILE", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Profile());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuAbout = new MenuItem(iconAbout, "ABOUT", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new About());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuLogout = new MenuItem(iconLogout, "LOGOUT", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                InstructorHomeFrame.this.dispose();
                new StartFrame().setVisible(true);
            }
        });
        
        addMenu(menuHome, menuDashboard, menuCourses, menuClass, menuProfile, menuAbout, menuLogout);
    }
    
    private void addMenu(MenuItem...menu){
        for(int i = 0; i < menu.length; i++){
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instructor Home");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeader.setBackground(new java.awt.Color(202, 154, 221));
        panelHeader.setPreferredSize(new java.awt.Dimension(980, 50));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("JetBrains Mono ExtraLight", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome,");
        panelHeader.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("JetBrains Mono ExtraLight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("(instructor name)");
        panelHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 15, 360, -1));

        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Education is key to success, so learn more.");
        panelHeader.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        getContentPane().add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        panelMenu.setBackground(new java.awt.Color(202, 154, 221));
        panelMenu.setPreferredSize(new java.awt.Dimension(180, 450));

        menus.setBackground(new java.awt.Color(202, 154, 221));
        menus.setPreferredSize(new java.awt.Dimension(180, 540));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, 200, 400));

        panelBody.setBackground(new java.awt.Color(255, 255, 255));
        panelBody.setPreferredSize(new java.awt.Dimension(770, 430));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 85, 770, 420));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        setSize(new java.awt.Dimension(996, 548));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
