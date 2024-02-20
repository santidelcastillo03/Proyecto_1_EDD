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
    private static double alpha;
    private static double beta;
    private static double rho;
    private static double q;
    private static int numAnts;
    private static DynamicArray<Ant> ants;
    private static int cycles;
    private static Grafo<City> graph;

    public static double getQ() {
        return q;
    }

    public static void setQ(double q) {
        Simulation.q = q;
    }
   
    public Simulation(double alpha, double beta, int cycles, int rho, int numAnts) {
        this.alpha = alpha;
        this.beta = beta;
        this.numAnts = numAnts;
        this.rho = rho;
        this.cycles = cycles;
    }

    public static double getAlpha() {
        return alpha;
    }

    public static void setAlpha(double alpha) {
        Simulation.alpha = alpha;
    }

    public static double getBeta() {
        return beta;
    }

    public static void setBeta(double beta) {
        Simulation.beta = beta;
    }

    public static double getRho() {
        return rho;
    }

    public static void setRho(double rho) {
        Simulation.rho = rho;
    }

    public static int getNumAnts() {
        return numAnts;
    }

    public static void setNumAnts(int numAnts) {
        Simulation.numAnts = numAnts;
    }

    public static int getCycles() {
        return cycles;
    }

    public static void setCycles(int cycles) {
        Simulation.cycles = cycles;
    }

    public static Grafo<City> getGraph() {
        return graph;
    }

    public void setGraph(Grafo<City> graph) {
        this.graph = graph;
    }

    public static DynamicArray<Ant> getAnts() {
        return ants;
    }

    public static void setAnts(DynamicArray<Ant> ants) {
        Simulation.ants = ants;
    }
        
      public void run() {
          
      }
    
    
}
