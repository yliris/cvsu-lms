package lms.homeMenu;

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
        this.setSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
        for(int i=0; i<subMenu.length;i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lbName.setText("Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(showing){
            hideMenu();
        } else{
            showMenu();
        }
        if(act != null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed

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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
