package lms.homeMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

public class MenuItem extends javax.swing.JPanel {
    
    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }

    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;
    
    public MenuItem(Icon icon, String menuName, ActionListener act, MenuItem...subMenu) {
        initComponents();
        lbIcon.setIcon(icon);
        lbName.setText(menuName);
        if(act != null){
            this.act = act;
        }
        this.setSize(new Dimension(Short.MAX_VALUE,40));
        this.setMaximumSize(new Dimension(Short.MAX_VALUE,40));
        this.setMinimumSize(new Dimension(0 ,40));
        for(int i=0; i<subMenu.length;i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(118, 196, 111));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        panel.setBackground(new java.awt.Color(118, 196, 111));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 40, 40));

        lbName.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setText("Dashboard");
        panel.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 4, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        panel.setBackground(new Color(69,152,61));
        if(showing){
            hideMenu();
        } else{
            showMenu();
        }
        if(act != null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        panel.setBackground(new Color(81, 177, 72));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        panel.setBackground(new Color(118, 196, 111));
    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        panel.setBackground(new Color(81, 177, 72));
    }//GEN-LAST:event_formMouseReleased

    private void showMenu(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i = 0; i < subMenu.size(); i++){
                    sleep();    
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }
    
    private void hideMenu(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i = subMenu.size()-1; i >= 0; i--){
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();        
    }
    
    private void sleep(){
        try{
            Thread.sleep(20);
        } catch(Exception e){
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
