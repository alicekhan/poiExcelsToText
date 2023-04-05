package poiexcel;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class MainFrame extends javax.swing.JFrame {
    Service service = null;
    public MainFrame() {
        initComponents();
        service = new Service();
    }
    public String filePath1;
    public String filePath2;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        select2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        done1 = new javax.swing.JButton();
        select1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        select2.setBackground(new java.awt.Color(0, 204, 153));
        select2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        select2.setForeground(new java.awt.Color(255, 255, 255));
        select2.setText("Select");
        select2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setText("Main Page");

        done1.setBackground(new java.awt.Color(0, 204, 153));
        done1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        done1.setForeground(new java.awt.Color(255, 255, 255));
        done1.setText("Save Text File");
        done1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done1ActionPerformed(evt);
            }
        });

        select1.setBackground(new java.awt.Color(0, 204, 153));
        select1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        select1.setForeground(new java.awt.Color(255, 255, 255));
        select1.setText("Select");
        select1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Choose Second Excel File:");

        jLabel3.setText("Choose First Excel File:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(select1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(select2)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(done1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select1)
                    .addComponent(select2))
                .addGap(31, 31, 31)
                .addComponent(done1)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select1ActionPerformed
      JFileChooser file = new JFileChooser();
      file.setMultiSelectionEnabled(true);
      file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      file.setFileHidingEnabled(false);
      if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
         java.io.File f = file.getSelectedFile();
         filePath1 = f.getPath();
         System.err.println(filePath1);     
         service.setExcelFilePath(filePath1);
      }

    }//GEN-LAST:event_select1ActionPerformed

    private void select2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select2ActionPerformed
      JFileChooser file = new JFileChooser();
      file.setMultiSelectionEnabled(true);
      file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      file.setFileHidingEnabled(false);
      if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
         java.io.File f = file.getSelectedFile();
         filePath2 = f.getPath();
         System.err.println(filePath2);
         service.setExcelFilePath1(filePath2);
      }

    }//GEN-LAST:event_select2ActionPerformed

    private void done1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done1ActionPerformed
        try {
            service.excelDataManipulation();
        } catch (InvalidFormatException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_done1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton select1;
    private javax.swing.JButton select2;
    // End of variables declaration//GEN-END:variables
}
