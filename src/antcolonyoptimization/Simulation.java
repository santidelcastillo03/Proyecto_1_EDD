/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author Santiago
 */
public class Simulation {
    private double alpha;
    private double beta;
    private int rho;
    private int numAnts;
    private int cycles;
    private Graph<City> graph;
    
    public Simulation(double alpha, double beta, int cycles, int rho, int numAnts) {
        this.alpha = alpha;
        this.beta = beta;
        this.numAnts = numAnts;
        this.rho = rho;
        this.cycles = cycles;
    }
        
      public void run() {
          
      }
    
    
}
