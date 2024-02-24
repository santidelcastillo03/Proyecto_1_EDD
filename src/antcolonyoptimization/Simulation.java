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
    
    public Simulation(double alpha, double beta, int cycles, double rho, int numAnts, double q) {
        this.alpha = alpha;
        this.beta = beta;
        this.numAnts = numAnts;
        this.rho = rho;
        this.cycles = cycles;
        this.ants = new DynamicArray<Ant>();
        this.q = q;
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
        
    
    public static DynamicArray<Edge> shortestPath(Grafo grafo) {
    DynamicArray<Edge> shortestPath = new DynamicArray<>();
    City currentCity = grafo.getStartCity();
    DynamicArray<Edge> allEdges= new DynamicArray();
    for(Edge edge : grafo.getEdges() ){
        allEdges.add(edge);
    }
    while (!currentCity.equals(grafo.getFinalCity())) {
        DynamicArray<Edge> adjNodes = new DynamicArray<>();
        System.out.println(currentCity.getName());
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
                System.out.println("se regreso a " + currentCity.getName());
                
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
            System.out.println("fue a " + currentCity.getName());
        }
        
    }
    return shortestPath;
}


    
    
      public static DynamicArray run(Grafo grafo) {
          DynamicArray<Ant> colony = Ant.createColony(numAnts, grafo);
          for(int i = 0; i < cycles; i++){
              System.out.println("Ciclo" + (i+1));
          Ant.performCycle(grafo, grafo.getFinalCity());
          }
            DynamicArray<Edge> result = shortestPath(grafo);
            return result;
     }
      
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
