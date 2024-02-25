/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package antcolonyoptimization.UI;

import antcolonyoptimization.City;
import antcolonyoptimization.Grafo;
import javax.swing.JOptionPane;
/**
 *
 * @author Santiago
 */
public class AddCity extends javax.swing.JFrame {
    private Grafo<City> graph;
    
    /**
     * Creates new form AddCity
     */
    public AddCity() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.graph = new Grafo<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cityNameInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        AddCityBu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cTo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cFrom = new javax.swing.JTextField();
        connectCityBu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        distanceInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Start city", "City", "Destination city" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 30));

        jLabel1.setText("City name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel2.setText("City property:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        getContentPane().add(cityNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel5.setText("Add City");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        AddCityBu.setText("Add city");
        AddCityBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCityBuActionPerformed(evt);
            }
        });
        getContentPane().add(AddCityBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 90, -1));

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel6.setText("Connect to:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));
        getContentPane().add(cTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 100, 30));

        jLabel3.setText("Connect from:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));
        getContentPane().add(cFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 100, 30));

        connectCityBu.setText("Connect");
        connectCityBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectCityBuActionPerformed(evt);
            }
        });
        getContentPane().add(connectCityBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        jLabel4.setText("Distance:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));
        getContentPane().add(distanceInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 100, 30));

        jLabel7.setText("(Min: 4 Max: 20)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 10, 10));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Diseno_sin_titulo_2.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        
    }//GEN-LAST:event_comboActionPerformed

    private void connectCityBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectCityBuActionPerformed
        String cityFrom = this.cFrom.getText();
    String cityTo = this.cTo.getText();
    String distanceStr = this.distanceInput.getText();

    if (cityFrom.isEmpty() || cityTo.isEmpty() || distanceStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields must be filled");
        return;
    }

    double distance;
    try {
        distance = Integer.parseInt(distanceStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Distance must be a number");
        return;
    }

    if (!graph.cityExists(cityFrom) || !graph.cityExists(cityTo)) {
        JOptionPane.showMessageDialog(null, "Both cities must exist in the graph");
        return;
    }
    
    if (graph.connectionExists(cityFrom, cityTo)) {
        JOptionPane.showMessageDialog(null, "Connection already exists");
        return;
    }

        graph.addEdge(cityFrom, cityTo, distance); 
        cFrom.setText("");
        cTo.setText("");
        distanceInput.setText("");
    }//GEN-LAST:event_connectCityBuActionPerformed

    private void AddCityBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCityBuActionPerformed
        
        if (this.cityNameInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "City name cannot be empty");
            return;
        }
    
        if (this.combo.getSelectedItem() == "Start city") {
        graph.addCity(this.cityNameInput.getText());
        if (!graph.startCityExists()) {
            graph.setStartCity(this.cityNameInput.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Start city already exists");
            return;
        }
    } else if (this.combo.getSelectedItem() == "Destination city") {
        graph.addCity(this.cityNameInput.getText());
        if (!graph.finalCityExists()) {
            graph.setFinalCity(this.cityNameInput.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Destination city already exists");
            return;
        }
    } else {
        if (graph.cityExists(this.cityNameInput.getText()) == false) {
            graph.addCity(this.cityNameInput.getText());
        } else {
            JOptionPane.showMessageDialog(null, "This city already exists");
            return;
        }
    }
    cityNameInput.setText("");
    }//GEN-LAST:event_AddCityBuActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCityBu;
    private javax.swing.JTextField cFrom;
    private javax.swing.JTextField cTo;
    private javax.swing.JTextField cityNameInput;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton connectCityBu;
    private javax.swing.JTextField distanceInput;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
