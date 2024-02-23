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
    
    public Simulation(double alpha, double beta, int cycles, int rho, int numAnts, double q) {
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
    while (!currentCity.getName().equals(grafo.getFinalCity().getName())) {
        DynamicArray<Edge> adjNodes = new DynamicArray<>();
        for (Edge edge : grafo.getEdges()) {
            if (edge.getPrevious().equals(currentCity)) {
                adjNodes.add(edge);
            }
        }
        if (adjNodes.size() == 1) {
            shortestPath.add(adjNodes.get(0));
            currentCity = adjNodes.get(0).getNext();
        } else {
            double total = 0;
            for (Edge edge : adjNodes) {
                total += Math.pow(edge.getPheromones(), alpha) * Math.pow(1.0 / edge.getWeight(), beta);
            }

            double randomValue = Math.random();
            double probSum = 0;
            Edge selectedEdge = null;
            for (Edge edge : adjNodes) {
                double edgeProb = Math.pow(edge.getPheromones(), alpha) * Math.pow(1.0 / edge.getWeight(), beta) / total;
                probSum += edgeProb;
                if (randomValue <= probSum) {
                    selectedEdge = edge;
                    break;
                }
            }
            if(adjNodes.size() == 0){
            currentCity = grafo.getStartCity();
        }
            if (selectedEdge == null) {
                double maxPheromones = adjNodes.get(0).getPheromones();
                selectedEdge = adjNodes.get(0);
                for (int i = 1; i < adjNodes.size(); i++) {
                    if (adjNodes.get(i).getPheromones() > maxPheromones) {
                        maxPheromones = adjNodes.get(i).getPheromones();
                        selectedEdge = adjNodes.get(i);
                    }
                }
            }

            shortestPath.add(selectedEdge);
            currentCity = selectedEdge.getNext();
        }
    }
    return shortestPath;
}


    
    
      public static DynamicArray run(Grafo grafo) {
          DynamicArray<Ant> colony = Ant.createColony(numAnts, grafo);
          for (int a = 0; a < cycles; a++){
              Ant.performCycle(grafo, grafo.getFinalCity());
          }
            DynamicArray<Edge> result = shortestPath(grafo);
            return result;
     }
      
      public static String printShortestPath(DynamicArray<Edge> shortestPath) {
        StringBuilder sb = new StringBuilder();
        sb.append("Shortest path: \n");
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
