/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import antcolonyoptimization.Ant;
import antcolonyoptimization.City;
import antcolonyoptimization.DynamicArray;
import antcolonyoptimization.Edge;
import antcolonyoptimization.Grafo;

/**
 *This class runs the ant colony optimization algorithm
 * 
 * @author Vicente Tralci
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
    
    /**
     * Constructor
     * 
     * @param alpha
     * @param beta
     * @param cycles
     * @param rho
     * @param numAnts
     * @param q 
     */
    public Simulation(double alpha, double beta, int cycles, double rho, int numAnts, double q) {
        this.alpha = alpha;
        this.beta = beta;
        this.numAnts = numAnts;
        this.rho = rho;
        this.cycles = cycles;
        this.ants = new DynamicArray<Ant>();
        this.q = q;
    }

    /**
     *
     * @return
     */
    public static double getQ() {
        return q;
    }

    /**
     *
     * @param q
     */
    public static void setQ(double q) {
        Simulation.q = q;
    }

    /**
     *
     * @return
     */
    public static double getAlpha() {
        return alpha;
    }

    /**
     *
     * @param alpha
     */
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     *
     * @return
     */
    public static double getBeta() {
        return beta;
    }

    /**
     *
     * @param beta
     */
    public void setBeta(double beta) {
        this.beta = beta;
    }

    /**
     *
     * @return
     */
    public static double getRho() {
        return rho;
    }

    /**
     *
     * @param rho
     */
    public void setRho(double rho) {
        this.rho = rho;
    }

    /**
     *
     * @return
     */
    public static int getNumAnts() {
        return numAnts;
    }

    /**
     *
     * @param numAnts
     */
    public void setNumAnts(int numAnts) {
        this.numAnts = numAnts;
    }

    /**
     *
     * @return
     */
    public static int getCycles() {
        return cycles;
    }

    /**
     *
     * @param cycles
     */
    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    /**
     *
     * @return
     */
    public static Grafo<City> getGraph() {
        return graph;
    }

    /**
     *
     * @param graph
     */
    public void setGraph(Grafo<City> graph) {
        this.graph = graph;
    }

    /**
     *
     * @return
     */
    public static DynamicArray<Ant> getAnts() {
        return ants;
    }

    /**
     *
     * @param ants
     */
    public static void setAnts(DynamicArray<Ant> ants) {
        Simulation.ants = ants;
    }


    /**
     * Returns the shortest path
     * 
     * @author Vicente Tralci
     * @param grafo the graph
     * @return the shortest path
     */
    public static DynamicArray<Edge> shortestPath(Grafo grafo) {
    DynamicArray<Edge> shortestPath = new DynamicArray<>();
    City currentCity = grafo.getStartCity();
    DynamicArray<Edge> allEdges= new DynamicArray();
    for(Edge edge : grafo.getEdges() ){
        allEdges.add(edge);
    }
    while (!currentCity.equals(grafo.getFinalCity())) {
        DynamicArray<Edge> adjNodes = new DynamicArray<>();
        for (Edge edge : allEdges) {
            if (edge.getPrevious().equals(currentCity)) {
                adjNodes.add(edge);
            }
        }if (adjNodes.size() == 0){
            DynamicArray<Edge> invAdjNodes = new DynamicArray();
            for (Edge edge : allEdges){
                if(edge.getNext().equals(currentCity)){
                    invAdjNodes.add(edge);
                }
                
            }
            double pher = invAdjNodes.get(0).getPheromones();
            Edge invselectedEdge = invAdjNodes.get(0);
            for(int i= 1; i < invAdjNodes.size(); i++){
                if(pher < invAdjNodes.get(i).getPheromones()){
                    pher = invAdjNodes.get(i).getPheromones();
                    invselectedEdge = invAdjNodes.get(i);
                }
                
                }
                for (Edge edge : allEdges){
                if(edge.getNext().equals(currentCity)){
                    allEdges.removeN(edge);
                }
                }
                currentCity = invselectedEdge.getPrevious();
                shortestPath.removeN(invselectedEdge);
                
        } else {
            double pher = adjNodes.get(0).getPheromones();
            Edge selectedEdge = adjNodes.get(0);
            for(int i= 1; i < adjNodes.size(); i++){
                if(pher < adjNodes.get(i).getPheromones()){
                    pher = adjNodes.get(i).getPheromones();
                    selectedEdge = adjNodes.get(i);
                }
            
            }
            shortestPath.add(selectedEdge);
            currentCity = selectedEdge.getNext();
        }
        
    }
    return shortestPath;
}   /**
    * Resets the simulation
    * 
    */
    public void reset() {
        this.alpha = 0.0;
        this.beta = 0.0;
        this.rho = 0.0;
        this.q = 0.0;
        this.numAnts = 0;
        this.cycles = 0;
        this.ants = new DynamicArray<Ant>();
        this.graph = new Grafo<City>();
        this.graph.reset();;
    }

    
      /**
       * Runs the simulation
       * 
       * @author Vicente Tralci
       * @param grafo the graph used
       * @return results
       */
      public static DynamicArray run(Grafo grafo) {
          DynamicArray<Ant> colony = Ant.createColony(numAnts, grafo);
          for(int i = 0; i < cycles; i++){
          Ant.performCycle(grafo, grafo.getFinalCity());
          }
            DynamicArray<Edge> result = shortestPath(grafo);
            return result;
     }
      /**
       * Prints the shortest path
       * 
       * @param shortestPath
       * @return a string of the shortest path
       */
      public static String printShortestPath(DynamicArray<Edge> shortestPath) {
        StringBuilder sb = new StringBuilder();
        sb.append("Shortest path:\n");
        for (int i = 0; i < shortestPath.size(); i++) {
            Edge edge = shortestPath.get(i);
            sb.append(edge.getPrevious().getName())
              .append(" -> ")
              .append(edge.getNext().getName())
              .append(" : ")
              .append(edge.getWeight())
              .append("\n");
        }
        return sb.toString();
    }
     }
