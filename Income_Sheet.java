import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Income_Sheet extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    double pqty=0,ppr=0,ptot=0;
    double sqty=0,spr=0,sltot=0;
    public Income_Sheet() {
        initComponents();
        conn=provision.provision1();
        PUR();
        SEL();
        COM();
    }
private void COM(){
    String sql="select name from new_dep";
    try{
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
            sel.addItem(rs.getString("name"));
        }
    }catch(Exception ex){
        System.out.println(ex);
    }
}
private void PUR()
{
    String sql="select qty,price,tot from purchase_dep";
    try{
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        purchases.setModel(DbUtils.resultSetToTableModel(rs));
        rs=pst.executeQuery();
        while(rs.next())
        {
            ptot+=Double.parseDouble(rs.getString("tot"));
            ppr+=Double.parseDouble(rs.getString("price"));
            pqty+=Double.parseDouble(rs.getString("qty"));
        }
        totpr.setText("Total Price:"+ppr);
        totq.setText("Total Quantity:"+pqty);
        tot.setText("Total Cost:"+ptot);
    }catch(Exception ex){
        System.out.println(ex);
    }
}
private void SEL()
{
    String sql="select qty,price,tot from sales_dep";
    try{
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        sales.setModel(DbUtils.resultSetToTableModel(rs));
        rs=pst.executeQuery();
        while(rs.next()){
            sltot+=Double.parseDouble(rs.getString("tot"));
            spr+=Double.parseDouble(rs.getString("price"));
            sqty+=Double.parseDouble(rs.getString("qty"));
        }
        sppr.setText("Total Sale Price:"+spr);
        sqt.setText("Total Quantity Sold:"+sqty);
        stot.setText("Total Sale Cost:"+sltot);    
    }catch(Exception ex){
        System.out.println(ex);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sales = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchases = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        x = new javax.swing.JButton();
        y = new javax.swing.JButton();
        sel = new javax.swing.JComboBox<>();
        totq = new javax.swing.JLabel();
        totpr = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        stot = new javax.swing.JLabel();
        sppr = new javax.swing.JLabel();
        sqt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Income_Sheet");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(206, 165, 117));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Income Calculation Sheet");

        sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(sales);

        purchases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(purchases);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Purchases");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sales");

        x.setText("Back");
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });

        y.setText("Print");
        y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yActionPerformed(evt);
            }
        });

        sel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department" }));
        sel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selActionPerformed(evt);
            }
        });

        totq.setBackground(new java.awt.Color(0, 0, 0));
        totq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totq.setText("Purchases");

        totpr.setBackground(new java.awt.Color(0, 0, 0));
        totpr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totpr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totpr.setText("Purchases");

        tot.setBackground(new java.awt.Color(0, 0, 0));
        tot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tot.setText("Purchases");

        stot.setBackground(new java.awt.Color(0, 0, 0));
        stot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stot.setText("Purchases");

        sppr.setBackground(new java.awt.Color(0, 0, 0));
        sppr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sppr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sppr.setText("Purchases");

        sqt.setBackground(new java.awt.Color(0, 0, 0));
        sqt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sqt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sqt.setText("Purchases");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(y)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(x)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totpr, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totq, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stot, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sppr, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sqt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totpr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tot))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sqt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sppr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stot)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x)
                    .addComponent(y)
                    .addComponent(sel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selActionPerformed
        // TODO add your handling code here:
        pqty=0;ppr=0;ptot=0;
     sqty=0;spr=0;sltot=0;
        String x=sel.getSelectedItem().toString();
        String sql1="select qty,price,tot from purchase_dep where dep_name='"+x+"'";
    try{
        pst=conn.prepareStatement(sql1);
        rs=pst.executeQuery();
        purchases.setModel(DbUtils.resultSetToTableModel(rs));
        rs=pst.executeQuery();
        while(rs.next())
        {
            ptot+=Double.parseDouble(rs.getString("tot"));
            ppr+=Double.parseDouble(rs.getString("price"));
            pqty+=Double.parseDouble(rs.getString("qty"));
        }
        totpr.setText("Total Price:"+ppr);
        totq.setText("Total Quantity:"+pqty);
        tot.setText("Total Cost:"+ptot);
    }catch(Exception ex){
        System.out.println(ex);
    }
    String sql="select qty,price,tot from sales_dep where dep_name='"+x+"'";
    try{
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        sales.setModel(DbUtils.resultSetToTableModel(rs));
        rs=pst.executeQuery();
        while(rs.next()){
            sltot+=Double.parseDouble(rs.getString("tot"));
            spr+=Double.parseDouble(rs.getString("price"));
            sqty+=Double.parseDouble(rs.getString("qty"));
        }
        sppr.setText("Total Sale Price:"+spr);
        sqt.setText("Total Quantity Sold:"+sqty);
        stot.setText("Total Sale Cost:"+sltot);    
    }catch(Exception ex){
        System.out.println(ex);
    }
    }//GEN-LAST:event_selActionPerformed

    private void yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yActionPerformed
        // TODO add your handling code here:
        x.setVisible(false);
        y.setVisible(false);
        sel.setVisible(false);
        String x=JOptionPane.showInputDialog("Enter The File Name Followed By Extension Name:");
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.paint(img.getGraphics());
        File outputfile = new File("D:\\"+x);
    try {
        ImageIO.write(img, "png", outputfile);
    } catch (IOException ex) {
        Logger.getLogger(Income_Sheet.class.getName()).log(Level.SEVERE, null, ex);
    }
    JOptionPane.showMessageDialog(this, "File Saved On 'D:\' Drive...!");
    this.hide();
    }//GEN-LAST:event_yActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_xActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Income_Sheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Income_Sheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Income_Sheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Income_Sheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Income_Sheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable purchases;
    private javax.swing.JTable sales;
    private javax.swing.JComboBox<String> sel;
    private javax.swing.JLabel sppr;
    private javax.swing.JLabel sqt;
    private javax.swing.JLabel stot;
    private javax.swing.JLabel tot;
    private javax.swing.JLabel totpr;
    private javax.swing.JLabel totq;
    private javax.swing.JButton x;
    private javax.swing.JButton y;
    // End of variables declaration//GEN-END:variables
}
