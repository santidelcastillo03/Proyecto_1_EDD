/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package antcolonyoptimization;

import antcolonyoptimization.UI.MainPage;

/**
 *
 * @author santiagodelcastillo
 */
public class AntColonyOptimization {
    private static Grafo<City> graph;
    private static double alpha = 1.0;
    private static double beta = 1.0;
    private static int cycles = 100;
    private static int rho = 5;

    public static void main(String[] args) {
        graph = new Grafo<>();

        
        graph.addCity("New york");
        graph.addCity("Los Angeles");
        graph.addCity("Chicago");

        graph.addEdge("New york", "Los Angeles", 2451);
        graph.addEdge("Los Angeles", "Chicago", 2014);
        graph.addEdge("Chicago", "New york", 790);

        graph.setStartCity("New york");
        graph.setFinalCity("Chicago");

        graph.printCities();
        graph.printEdges();
        
    }

    public static void antGroup(int totalAnts, int cycles) {
        Ant.setTotalAnts(totalAnts);

        for (int i = 0; i < Ant.getTotalAnts(); i++) {
            Ant ant = new Ant(graph.getStartCity(), graph.getFinalCity());
            ant.performCycles(cycles);
        }

        
    }
    
}

