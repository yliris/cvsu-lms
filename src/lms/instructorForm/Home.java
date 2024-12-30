package lms.instructorForm;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import lms.instructorForm.Classes.Class1;
import lms.instructorForm.Classes.Class2;
import lms.instructorForm.Classes.Class3;
import lms.instructorForm.Classes.Class4;
import lms.instructorForm.Classes.Class5;
import lms.instructorForm.Classes.Class6;
import lms.instructorForm.Classes.Class7;
import lms.instructorForm.Classes.Class8;

public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();
        initializeButtons();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        classBackground = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        add8 = new javax.swing.JButton();
        delete8 = new javax.swing.JButton();
        view8 = new javax.swing.JButton();
        class8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        add7 = new javax.swing.JButton();
        delete7 = new javax.swing.JButton();
        view7 = new javax.swing.JButton();
        class7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        add6 = new javax.swing.JButton();
        delete6 = new javax.swing.JButton();
        view6 = new javax.swing.JButton();
        class6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        add5 = new javax.swing.JButton();
        delete5 = new javax.swing.JButton();
        view5 = new javax.swing.JButton();
        class5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        add4 = new javax.swing.JButton();
        delete4 = new javax.swing.JButton();
        view4 = new javax.swing.JButton();
        class4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        add3 = new javax.swing.JButton();
        delete3 = new javax.swing.JButton();
        view3 = new javax.swing.JButton();
        class3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        add2 = new javax.swing.JButton();
        delete2 = new javax.swing.JButton();
        view2 = new javax.swing.JButton();
        class2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        add1 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        view1 = new javax.swing.JButton();
        class1 = new javax.swing.JLabel();
        calendarBackground = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(770, 440));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jLabel3.setText("Academic Calendar");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        jLabel2.setText("Your Class (click a created class to open)");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        classBackground.setBackground(new java.awt.Color(244, 244, 244));
        classBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(202, 154, 221));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add8.setBorder(null);
        add8.setBorderPainted(false);
        add8.setContentAreaFilled(false);
        add8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add8MouseReleased(evt);
            }
        });
        jPanel8.add(add8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete8.setBorder(null);
        delete8.setBorderPainted(false);
        delete8.setContentAreaFilled(false);
        delete8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete8MouseReleased(evt);
            }
        });
        jPanel8.add(delete8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view8.setBorder(null);
        view8.setBorderPainted(false);
        view8.setContentAreaFilled(false);
        view8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view8ActionPerformed(evt);
            }
        });
        jPanel8.add(view8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class8.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class8.setForeground(new java.awt.Color(255, 255, 255));
        class8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class8.setText("empty");
        jPanel8.add(class8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 70, 70));

        jPanel7.setBackground(new java.awt.Color(25, 250, 129));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add7.setBorder(null);
        add7.setBorderPainted(false);
        add7.setContentAreaFilled(false);
        add7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add7MouseReleased(evt);
            }
        });
        jPanel7.add(add7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete7.setBorder(null);
        delete7.setBorderPainted(false);
        delete7.setContentAreaFilled(false);
        delete7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete7MouseReleased(evt);
            }
        });
        jPanel7.add(delete7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view7.setBorder(null);
        view7.setBorderPainted(false);
        view7.setContentAreaFilled(false);
        view7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view7ActionPerformed(evt);
            }
        });
        jPanel7.add(view7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class7.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class7.setForeground(new java.awt.Color(255, 255, 255));
        class7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class7.setText("empty");
        jPanel7.add(class7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 70, 70));

        jPanel6.setBackground(new java.awt.Color(202, 154, 221));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add6.setBorder(null);
        add6.setBorderPainted(false);
        add6.setContentAreaFilled(false);
        add6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add6MouseReleased(evt);
            }
        });
        jPanel6.add(add6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete6.setBorder(null);
        delete6.setBorderPainted(false);
        delete6.setContentAreaFilled(false);
        delete6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete6MouseReleased(evt);
            }
        });
        jPanel6.add(delete6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view6.setBorder(null);
        view6.setBorderPainted(false);
        view6.setContentAreaFilled(false);
        view6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view6ActionPerformed(evt);
            }
        });
        jPanel6.add(view6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class6.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class6.setForeground(new java.awt.Color(255, 255, 255));
        class6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class6.setText("empty");
        jPanel6.add(class6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 70, 70));

        jPanel5.setBackground(new java.awt.Color(25, 250, 129));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add5.setBorder(null);
        add5.setBorderPainted(false);
        add5.setContentAreaFilled(false);
        add5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add5MouseReleased(evt);
            }
        });
        jPanel5.add(add5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete5.setBorder(null);
        delete5.setBorderPainted(false);
        delete5.setContentAreaFilled(false);
        delete5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete5MouseReleased(evt);
            }
        });
        jPanel5.add(delete5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view5.setBorder(null);
        view5.setBorderPainted(false);
        view5.setContentAreaFilled(false);
        view5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view5ActionPerformed(evt);
            }
        });
        jPanel5.add(view5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class5.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class5.setForeground(new java.awt.Color(255, 255, 255));
        class5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class5.setText("empty");
        jPanel5.add(class5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 70, 70));

        jPanel4.setBackground(new java.awt.Color(202, 154, 221));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add4.setBorder(null);
        add4.setBorderPainted(false);
        add4.setContentAreaFilled(false);
        add4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add4MouseReleased(evt);
            }
        });
        jPanel4.add(add4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete4.setBorder(null);
        delete4.setBorderPainted(false);
        delete4.setContentAreaFilled(false);
        delete4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete4MouseReleased(evt);
            }
        });
        jPanel4.add(delete4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view4.setBorder(null);
        view4.setBorderPainted(false);
        view4.setContentAreaFilled(false);
        view4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view4ActionPerformed(evt);
            }
        });
        jPanel4.add(view4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class4.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class4.setForeground(new java.awt.Color(255, 255, 255));
        class4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class4.setText("empty");
        jPanel4.add(class4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 70, 70));

        jPanel3.setBackground(new java.awt.Color(25, 250, 129));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add3.setBorder(null);
        add3.setBorderPainted(false);
        add3.setContentAreaFilled(false);
        add3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add3MouseReleased(evt);
            }
        });
        jPanel3.add(add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete3.setBorder(null);
        delete3.setBorderPainted(false);
        delete3.setContentAreaFilled(false);
        delete3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete3MouseReleased(evt);
            }
        });
        jPanel3.add(delete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view3.setBorder(null);
        view3.setBorderPainted(false);
        view3.setContentAreaFilled(false);
        view3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view3ActionPerformed(evt);
            }
        });
        jPanel3.add(view3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class3.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class3.setForeground(new java.awt.Color(255, 255, 255));
        class3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class3.setText("empty");
        jPanel3.add(class3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 70));

        jPanel2.setBackground(new java.awt.Color(202, 154, 221));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add2.setBorder(null);
        add2.setBorderPainted(false);
        add2.setContentAreaFilled(false);
        add2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add2MouseReleased(evt);
            }
        });
        jPanel2.add(add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete2.setBorder(null);
        delete2.setBorderPainted(false);
        delete2.setContentAreaFilled(false);
        delete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete2MouseReleased(evt);
            }
        });
        jPanel2.add(delete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view2.setBorder(null);
        view2.setBorderPainted(false);
        view2.setContentAreaFilled(false);
        view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view2ActionPerformed(evt);
            }
        });
        jPanel2.add(view2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class2.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class2.setForeground(new java.awt.Color(255, 255, 255));
        class2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class2.setText("empty");
        jPanel2.add(class2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 70, 70));

        jPanel1.setBackground(new java.awt.Color(25, 250, 129));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png"))); // NOI18N
        add1.setBorder(null);
        add1.setBorderPainted(false);
        add1.setContentAreaFilled(false);
        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add1MouseReleased(evt);
            }
        });
        jPanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 30, 30));

        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png"))); // NOI18N
        delete1.setBorder(null);
        delete1.setBorderPainted(false);
        delete1.setContentAreaFilled(false);
        delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete1MouseReleased(evt);
            }
        });
        jPanel1.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, 20));

        view1.setBorder(null);
        view1.setBorderPainted(false);
        view1.setContentAreaFilled(false);
        view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view1ActionPerformed(evt);
            }
        });
        jPanel1.add(view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        class1.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        class1.setForeground(new java.awt.Color(255, 255, 255));
        class1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class1.setText("empty");
        jPanel1.add(class1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, -1));

        classBackground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 70));

        background.add(classBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 30, 720, 90));

        calendarBackground.setBackground(new java.awt.Color(25, 250, 129));
        calendarBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("10");
        calendarBackground.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 360, 20));

        jLabel11.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("27-Feb 15");
        calendarBackground.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 290, 20));

        jLabel10.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("23");
        calendarBackground.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 640, 20));

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("February");
        calendarBackground.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 80, 40));

        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("September");
        calendarBackground.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 80, 40));

        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("October");
        calendarBackground.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 80, 40));

        jLabel7.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("November");
        calendarBackground.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 80, 50));

        jLabel8.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("December");
        calendarBackground.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 80, 40));

        jLabel9.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("January");
        calendarBackground.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 80, 50));

        jLabel13.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("3");
        calendarBackground.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 280, 20));

        jLabel14.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("11-16");
        calendarBackground.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, 20));

        jLabel15.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("18-29");
        calendarBackground.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 260, 20));

        jLabel16.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("8");
        calendarBackground.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 640, 20));

        jLabel17.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("21");
        calendarBackground.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 250, 20));

        jLabel18.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("6");
        calendarBackground.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 110, 20));

        jLabel19.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("13-18");
        calendarBackground.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 120, 20));

        jLabel20.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("20-25");
        calendarBackground.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 120, 20));

        jLabel22.setFont(new java.awt.Font("JetBrains Mono", 0, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("16");
        calendarBackground.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 640, 20));

        jLabel23.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Final examination");
        calendarBackground.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 120, 10));

        jLabel24.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Last day of filling of application for graduation");
        calendarBackground.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 360, 20));

        jLabel25.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Midterm examination");
        calendarBackground.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, 20));

        jLabel26.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("of class observation");
        calendarBackground.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 260, 10));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        calendarBackground.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 730, 20));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 20, 50));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        calendarBackground.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 730, 20));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        calendarBackground.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 730, 20));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        calendarBackground.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 730, 20));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        calendarBackground.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 730, 20));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 20, 260));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 20, 40));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 20, 50));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 20, 50));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 20, 50));

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        calendarBackground.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 20, 50));

        jLabel27.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Submission of complete list of qualified");
        calendarBackground.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 250, 20));

        jLabel28.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Last day of adding and dropping subjects");
        calendarBackground.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 280, 20));

        jLabel30.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("candidates");
        calendarBackground.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 250, 10));

        jLabel31.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Student evaluation for teachers and start");
        calendarBackground.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 260, 20));

        jLabel33.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Beginning of classes");
        calendarBackground.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 640, 20));

        jLabel34.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Start of Christmas break");
        calendarBackground.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 640, 20));

        jLabel35.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Last day of submission and uploading of grades");
        calendarBackground.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 640, 20));

        jLabel36.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Semestral break");
        calendarBackground.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 290, 30));

        jLabel37.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Return of classes");
        calendarBackground.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 110, 20));

        jLabel38.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("(Non-graduating)");
        calendarBackground.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 120, 20));

        jLabel39.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Final examination");
        calendarBackground.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 120, 10));

        jLabel40.setFont(new java.awt.Font("JetBrains Mono Light", 0, 10)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("(Graduating)");
        calendarBackground.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 120, 20));

        background.add(calendarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 730, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void handleAddButtonAction(JButton addButton, JButton deleteButton, JButton viewButton, JLabel label) {
        String className = "";
        boolean isValid = false;

        while (!isValid) {
            className = JOptionPane.showInputDialog("Enter class name:");
            if (className == null) {
                return;
            }
            if (className.trim().isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Class name cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (className.length() > 8) {
                JOptionPane.showMessageDialog(null, "Class name cannot exceed 8 characters. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                isValid = true;
            }
        }

        label.setText(className);
        JOptionPane.showMessageDialog(null, "Class " + className + " created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        addButton.setVisible(false);
        deleteButton.setVisible(true);
        viewButton.setVisible(true);
    }
    
    private void initializeButtons() {
        JButton[] addButtons = {add1, add2, add3, add4, add5, add6, add7, add8};
        JButton[] deleteButtons = {delete1, delete2, delete3, delete4, delete5, delete6, delete7, delete8};
        JButton[] viewButtons = {view1, view2, view3, view4, view5, view6, view7, view8};
        JLabel[] labels = {class1, class2, class3, class4, class5, class6, class7, class8};

        for (int i = 0; i < addButtons.length; i++) {
            int index = i;
            JButton addButton = addButtons[index];
            JButton deleteButton = deleteButtons[index];
            JButton viewButton = viewButtons[index];
            JLabel label = labels[index];
            
            deleteButton.setVisible(false);
            viewButton.setVisible(false);
            
            addButton.addActionListener(evt -> handleAddButtonAction(addButton, deleteButton, viewButton, label));
            
            deleteButton.addActionListener(evt -> {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this class?", "Warning",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if(confirm == JOptionPane.OK_OPTION){
                    label.setText("empty");
                    addButton.setVisible(true);
                    deleteButton.setVisible(false);
                    viewButton.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Class deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }
    
    private void add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseEntered
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add1MouseEntered

    private void add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseExited
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add1MouseExited

    private void add1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MousePressed
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add1MousePressed

    private void add1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseReleased
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add1MouseReleased

    private void add2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseEntered
        add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add2MouseEntered

    private void add2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseExited
        add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add2MouseExited
        
    private void add2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MousePressed
        add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add2MousePressed

    private void add2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseReleased
        add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add2MouseReleased

    private void add3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseEntered
        add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add3MouseEntered
        
    private void add3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseExited
        add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add3MouseExited

    private void add3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MousePressed
        add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add3MousePressed

    private void add3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseReleased
        add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add3MouseReleased

    private void add4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MouseEntered
        add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add4MouseEntered

    private void add4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MouseExited
        add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add4MouseExited

    private void add4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MousePressed
        add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add4MousePressed

    private void add4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MouseReleased
        add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add4MouseReleased

    private void add5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseEntered
        add5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add5MouseEntered

    private void add5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseExited
        add5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add5MouseExited

    private void add5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MousePressed
        add5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add5MousePressed

    private void add5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseReleased
        add5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add5MouseReleased

    private void add6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MouseEntered
        add6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add6MouseEntered

    private void add6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MouseExited
        add6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add6MouseExited

    private void add6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MousePressed
        add6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add6MousePressed

    private void add6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MouseReleased
        add6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add6MouseReleased

    private void add7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MouseEntered
        add7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add7MouseEntered

    private void add7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MouseExited
        add7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add7MouseExited

    private void add7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MousePressed
        add7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add7MousePressed

    private void add7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MouseReleased
        add7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add7MouseReleased

    private void add8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add8MouseEntered
        add8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add8MouseEntered

    private void add8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add8MouseExited
        add8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/add.png")));
    }//GEN-LAST:event_add8MouseExited

    private void add8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add8MousePressed
        add8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addClick.png")));
    }//GEN-LAST:event_add8MousePressed

    private void add8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add8MouseReleased
        add8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/addHover.png")));
    }//GEN-LAST:event_add8MouseReleased

    private void delete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MouseEntered
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete1MouseEntered

    private void delete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MouseExited
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete1MouseExited

    private void delete1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MousePressed
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete1MousePressed

    private void delete1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MouseReleased
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete1MouseReleased

    private void delete2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MouseEntered
        delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete2MouseEntered

    private void delete2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MouseExited
        delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete2MouseExited

    private void delete2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MousePressed
        delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete2MousePressed

    private void delete2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MouseReleased
        delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete2MouseReleased

    private void delete3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete3MouseEntered
        delete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete3MouseEntered

    private void delete3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete3MouseExited
        delete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete3MouseExited

    private void delete3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete3MousePressed
        delete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete3MousePressed

    private void delete3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete3MouseReleased
        delete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete3MouseReleased

    private void delete4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete4MouseEntered
        delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete4MouseEntered

    private void delete4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete4MouseExited
        delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete4MouseExited

    private void delete4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete4MousePressed
        delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete4MousePressed

    private void delete4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete4MouseReleased
        delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete4MouseReleased

    private void delete5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete5MouseEntered
        delete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete5MouseEntered

    private void delete5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete5MouseExited
        delete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete5MouseExited

    private void delete5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete5MousePressed
        delete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete5MousePressed

    private void delete5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete5MouseReleased
        delete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete5MouseReleased

    private void delete6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete6MouseEntered
        delete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete6MouseEntered

    private void delete6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete6MouseExited
        delete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete6MouseExited

    private void delete6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete6MousePressed
        delete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete6MousePressed

    private void delete6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete6MouseReleased
        delete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete6MouseReleased

    private void delete7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete7MouseEntered
        delete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete7MouseEntered

    private void delete7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete7MouseExited
        delete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete7MouseExited

    private void delete7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete7MousePressed
        delete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete7MousePressed

    private void delete7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete7MouseReleased
        delete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete7MouseReleased

    private void delete8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete8MouseEntered
        delete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete8MouseEntered

    private void delete8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete8MouseExited
        delete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/delete.png")));
    }//GEN-LAST:event_delete8MouseExited

    private void delete8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete8MousePressed
        delete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteClick.png")));
    }//GEN-LAST:event_delete8MousePressed

    private void delete8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete8MouseReleased
        delete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lms/resources/images/buttons/deleteHover.png")));
    }//GEN-LAST:event_delete8MouseReleased

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1ActionPerformed
        new Class1().setVisible(true);
    }//GEN-LAST:event_view1ActionPerformed

    private void view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view2ActionPerformed
        new Class2().setVisible(true);
    }//GEN-LAST:event_view2ActionPerformed

    private void view3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view3ActionPerformed
        new Class3().setVisible(true);
    }//GEN-LAST:event_view3ActionPerformed

    private void view4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view4ActionPerformed
        new Class4().setVisible(true);
    }//GEN-LAST:event_view4ActionPerformed

    private void view5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view5ActionPerformed
        new Class5().setVisible(true);
    }//GEN-LAST:event_view5ActionPerformed

    private void view6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view6ActionPerformed
        new Class6().setVisible(true);
    }//GEN-LAST:event_view6ActionPerformed

    private void view7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view7ActionPerformed
        new Class7().setVisible(true);
    }//GEN-LAST:event_view7ActionPerformed

    private void view8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view8ActionPerformed
        new Class8().setVisible(true);
    }//GEN-LAST:event_view8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.JButton add4;
    private javax.swing.JButton add5;
    private javax.swing.JButton add6;
    private javax.swing.JButton add7;
    private javax.swing.JButton add8;
    private javax.swing.JPanel background;
    private javax.swing.JPanel calendarBackground;
    private javax.swing.JLabel class1;
    private javax.swing.JLabel class2;
    private javax.swing.JLabel class3;
    private javax.swing.JLabel class4;
    private javax.swing.JLabel class5;
    private javax.swing.JLabel class6;
    private javax.swing.JLabel class7;
    private javax.swing.JLabel class8;
    private javax.swing.JPanel classBackground;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JButton delete3;
    private javax.swing.JButton delete4;
    private javax.swing.JButton delete5;
    private javax.swing.JButton delete6;
    private javax.swing.JButton delete7;
    private javax.swing.JButton delete8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton view1;
    private javax.swing.JButton view2;
    private javax.swing.JButton view3;
    private javax.swing.JButton view4;
    private javax.swing.JButton view5;
    private javax.swing.JButton view6;
    private javax.swing.JButton view7;
    private javax.swing.JButton view8;
    // End of variables declaration//GEN-END:variables
}
