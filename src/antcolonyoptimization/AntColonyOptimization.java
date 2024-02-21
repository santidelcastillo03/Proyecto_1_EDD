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
    

    public static void main(String[] args) {
        MainPage ui = new MainPage();
        ui.setVisible(true);
        graph = new Grafo<>();
        GraphVisualizer visualizer = new GraphVisualizer();
        
        Simulation simulation = new Simulation(1.0, 2.0, 100, (int) 0.5, 50);
        
        graph.addCity("New york");
        graph.addCity("Los Angeles");
        graph.addCity("Chicago");

        graph.addEdge("New york", "Los Angeles", 2451);
        graph.addEdge("Los Angeles", "Chicago", 2014);
        graph.addEdge("Chicago", "New york", 790);

        simulation.run();
        

        DynamicArray<Edge> shortestPath = simulation.run();
        String shortestPathString = Simulation.printShortestPath(shortestPath);
        System.out.println(shortestPathString);

              

        visualizer.displayShortestPath(shortestPath);
        visualizer.visualize(graph);
        
    }

    
}

