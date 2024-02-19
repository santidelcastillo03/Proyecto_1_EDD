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
    private int cycles;
    private Grafo<City> graph;
    
    public Simulation(double alpha, double beta, int cycles, int rho) {
        this.alpha = alpha;
        this.beta = beta;
        this.rho = rho;
        this.cycles = cycles;
    }
        
      public void run() {
          
      }
    
    public void antGroup(int totalAnts, int cycles) {
        Ant.setTotalAnts(totalAnts);
        
        for (int i = 0; i < Ant.getTotalAnts(); i++) {
            Ant ant = new Ant(graph.getStartCity(), graph.getFinalCity());
            ant.performCycles(cycles);
        }
    }
}
