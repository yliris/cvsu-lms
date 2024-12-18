package lms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import lms.homeMenu.MenuItem;
import lms.studentForm.About;
import lms.studentForm.Subjects;
import lms.studentForm.Dashboard1;
import lms.studentForm.Dashboard2;
import lms.studentForm.Dashboard3;
import lms.studentForm.Home;
import lms.studentForm.Profile;

public class StudentHomeFrame extends javax.swing.JFrame {

    public StudentHomeFrame() {
        initComponents();
        execute();
    }
    
    private void execute(){
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/lms/homeMenu/home.png"));
        ImageIcon iconDashboard = new ImageIcon(getClass().getResource("/lms/homeMenu/dashboard.png"));
        ImageIcon iconSubjects = new ImageIcon(getClass().getResource("/lms/homeMenu/subjects.png"));
        ImageIcon iconProfile = new ImageIcon(getClass().getResource("/lms/homeMenu/profile.png"));
        ImageIcon iconAbout = new ImageIcon(getClass().getResource("/lms/homeMenu/about.png"));
        ImageIcon iconLogout = new ImageIcon(getClass().getResource("/lms/homeMenu/logout.png"));
        ImageIcon iconSubmenu = new ImageIcon(getClass().getResource("/lms/homeMenu/submenu.png"));
        
        //SUBMENU FOR DASHBOARD (ADJUST IF NEEDED)
        MenuItem menuDashboard1 = new MenuItem(iconSubmenu, "Dashboard 001", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new Dashboard1());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuDashboard2 = new MenuItem(iconSubmenu, "Dashboard 002", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Dashboard2());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuDashboard3 = new MenuItem(iconSubmenu, "Dashboard 003", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Dashboard3());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuHome = new MenuItem(iconHome, "Home", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Home());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuDashboard = new MenuItem(iconDashboard, "Dashboard", null, menuDashboard1, menuDashboard2, menuDashboard3);
        
        MenuItem menuSubjects = new MenuItem(iconSubjects, "Subjects", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Subjects());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuProfile = new MenuItem(iconProfile, "Profile", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new Profile());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuAbout = new MenuItem(iconAbout, "About", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new About());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuLogout = new MenuItem(iconLogout, "Logout", null);
        addMenu(menuHome, menuDashboard, menuSubjects, menuProfile, menuAbout, menuLogout);
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
        panelMenu = new javax.swing.JPanel();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Home");
        setResizable(false);

        panelHeader.setBackground(new java.awt.Color(148, 96, 185));
        panelHeader.setPreferredSize(new java.awt.Dimension(980, 50));

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(180, 490));

        menus.setBackground(new java.awt.Color(255, 255, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menus, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(33, 125, 25));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
