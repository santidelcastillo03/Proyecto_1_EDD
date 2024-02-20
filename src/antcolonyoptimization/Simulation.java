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
    
    public Simulation(double alpha, double beta, int cycles, int rho, int numAnts) {
        this.alpha = alpha;
        this.beta = beta;
        this.numAnts = numAnts;
        this.rho = rho;
        this.cycles = cycles;
    }
    public static double getQ() {
        return q;
    }

    public static void setQ(double q) {
        Simulation.q = q;
    }
    public static double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public static double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public static double getRho() {
        return rho;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }

    public static int getNumAnts() {
        return numAnts;
    }

    public void setNumAnts(int numAnts) {
        this.numAnts = numAnts;
    }

    public static int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
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
        
    
    public static DynamicArray shortestPath(){
      DynamicArray <Edge> shortestPath = new DynamicArray();
      City currentCity = Grafo.getStartCity();
      while(!currentCity.equals(Grafo.getFinalCity())){
        DynamicArray<Edge> adjNodes = new DynamicArray();
        int len = Grafo.getEdges().size();
        for(int i = 0; i < len; i++){
            if (Grafo.getEdges().get(i).getPrevious().equals(currentCity)){
                adjNodes.add(Grafo.getEdges().get(i));
            }
            double pointer = adjNodes.get(0).getPheromones();
        for(int a = 1; a < adjNodes.size(); a++){
            if(pointer < adjNodes.get(a).getPheromones()){
                shortestPath.add(adjNodes.get(a));
                currentCity = adjNodes.get(a).getNext();
                pointer = adjNodes.get(a).getPheromones();
            }
        }
      }
    
    }
      return shortestPath;
    }
    
      public static DynamicArray run() {
          DynamicArray<Ant> colony = Ant.createColony(numAnts);
          for (int a = 0; a < cycles; a++){
              for (int i = 0; i < colony.size(); i++){
              colony.get(i).performCycle();
          } Ant.updatePheromones();
      }
            DynamicArray<Edge> result = shortestPath();
            return result;
     }
     }
