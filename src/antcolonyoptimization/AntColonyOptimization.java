/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package antcolonyoptimization;

import antcolonyoptimization.UI.MainPage;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

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
        MainPage ui = new MainPage();
        ui.setVisible(true);
        graph = new Grafo<>();
        GraphVisualizer visualizer = new GraphVisualizer();
        
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

        visualizer.visualize(graph);
        
    }

    
}

