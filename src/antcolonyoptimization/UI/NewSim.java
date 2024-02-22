/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package antcolonyoptimization.UI;

import antcolonyoptimization.DynamicArray;
import antcolonyoptimization.Edge;
import antcolonyoptimization.Grafo;
import antcolonyoptimization.GraphLoader;
import antcolonyoptimization.GraphVisualizer;
import antcolonyoptimization.Simulation;
import javax.swing.JOptionPane;

/**
 *
 * @author santiagodelcastillo
 */
public class NewSim extends javax.swing.JFrame {
    AddCity addCity = new AddCity();
    Simulation simulation;
    Grafo graph = new Grafo();
    GraphVisualizer visualizer = new GraphVisualizer();
    GraphLoader graphLoader = new GraphLoader(graph);

    
    
    /**
     * Creates new form AddCity
     */
    public NewSim() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        StartSimBu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BackBu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CyclesInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AAInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AlphaInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BetaInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        RhoInput = new javax.swing.JTextField();
        AddValuesBu = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        QInput = new javax.swing.JTextField();
        SaveGraphBu = new javax.swing.JButton();
        DelCityBu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        StartSimBu.setText("Start Simulation");
        StartSimBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartSimBuActionPerformed(evt);
            }
        });
        getContentPane().add(StartSimBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("New Simulation");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        BackBu.setText("<< Back");
        BackBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBuActionPerformed(evt);
            }
        });
        getContentPane().add(BackBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        jLabel2.setText("Cycles:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        getContentPane().add(CyclesInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 80, -1));

        jLabel3.setText("Ant amount:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        AAInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAInputActionPerformed(evt);
            }
        });
        getContentPane().add(AAInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 80, -1));

        jLabel4.setText("Alpha value:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        AlphaInput.setText("1.0");
        getContentPane().add(AlphaInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 80, -1));

        jLabel5.setText("Beta value:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        BetaInput.setText("2.0");
        getContentPane().add(BetaInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 80, -1));

        jLabel8.setText("Rho value:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        RhoInput.setText("0.5");
        getContentPane().add(RhoInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 80, -1));

        AddValuesBu.setText("Add");
        AddValuesBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddValuesBuActionPerformed(evt);
            }
        });
        getContentPane().add(AddValuesBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

        jButton4.setText("New city");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, -1, -1));

        jLabel6.setText("Q value:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        QInput.setText("1.0");
        getContentPane().add(QInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 80, -1));

        SaveGraphBu.setText("Save Graph");
        SaveGraphBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveGraphBuActionPerformed(evt);
            }
        });
        getContentPane().add(SaveGraphBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, -1, -1));

        DelCityBu.setText("Delete city");
        getContentPane().add(DelCityBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AAInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AAInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AAInputActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        addCity.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BackBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBuActionPerformed
        
    }//GEN-LAST:event_BackBuActionPerformed

    private void StartSimBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartSimBuActionPerformed
         try {
            int cycles = Integer.parseInt(CyclesInput.getText());
            int antAmount = Integer.parseInt(AAInput.getText());
            double alpha = Double.parseDouble(AlphaInput.getText());
            double beta = Double.parseDouble(BetaInput.getText());
            double rho = Double.parseDouble(RhoInput.getText());
            double qValue = Double.parseDouble(QInput.getText());

        Simulation simulation = new Simulation(alpha, beta, cycles, (int) rho, antAmount, qValue);
        simulation.setCycles(cycles);
        simulation.setNumAnts(antAmount);
        simulation.setQ(qValue);
        simulation.setAlpha(alpha);
        simulation.setBeta(beta);
        simulation.setRho(rho);
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "All fields must be numbers");
        }
        
        DynamicArray<Edge> shortestPath = simulation.run(graph);
        String shortestPathString = Simulation.printShortestPath(shortestPath);
        visualizer.displayShortestPath(shortestPath);
        visualizer.visualize(graph);
        System.out.println(shortestPathString);

    }//GEN-LAST:event_StartSimBuActionPerformed

    private void SaveGraphBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveGraphBuActionPerformed
        graphLoader.saveToFile();
    }//GEN-LAST:event_SaveGraphBuActionPerformed

    private void AddValuesBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddValuesBuActionPerformed
        try {
            int cycles = Integer.parseInt(CyclesInput.getText());
            int antAmount = Integer.parseInt(AAInput.getText());
            double alpha = Double.parseDouble(AlphaInput.getText());
            double beta = Double.parseDouble(BetaInput.getText());
            double rho = Double.parseDouble(RhoInput.getText());
            double qValue = Double.parseDouble(QInput.getText());

            Simulation simulation = new Simulation(alpha, beta, cycles, (int) rho, antAmount, qValue);
            simulation.setCycles(cycles);
            simulation.setNumAnts(antAmount);
            simulation.setQ(qValue);
            simulation.setAlpha(alpha);
            simulation.setBeta(beta);
            simulation.setRho(rho);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "All fields must be numbers");
        }
    }//GEN-LAST:event_AddValuesBuActionPerformed

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
            java.util.logging.Logger.getLogger(NewSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AAInput;
    private javax.swing.JButton AddValuesBu;
    private javax.swing.JTextField AlphaInput;
    private javax.swing.JButton BackBu;
    private javax.swing.JTextField BetaInput;
    private javax.swing.JTextField CyclesInput;
    private javax.swing.JButton DelCityBu;
    private javax.swing.JTextField QInput;
    private javax.swing.JTextField RhoInput;
    private javax.swing.JButton SaveGraphBu;
    private javax.swing.JButton StartSimBu;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
