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
        
        
        graph = new Grafo();
        GraphVisualizer visualizer = new GraphVisualizer();
        
        Simulation simulation = new Simulation(1.0, 2.0, 5, (int) 0.5, 5, 1);

        
        graph.addCity("1");
        graph.addCity("2");
        graph.addCity("3");
        graph.addCity("4");
        graph.addCity("5");
        graph.addCity("6");
        graph.addCity("7");


        graph.addEdge("1","2", 5.0);
        graph.addEdge("1", "3", 3.1);
        graph.addEdge("1", "6", 5.2);
        graph.addEdge("6", "3", 3.2);
        graph.addEdge("6", "5", 4.7);
        graph.addEdge("3", "2", 4.9);
        graph.addEdge("2", "7", 5.2);
        graph.addEdge("3", "7", 3.0);
        graph.addEdge("3", "5", 6.0);
        graph.addEdge("7", "4", 4.8);
        graph.addEdge("5", "4", 5.5);

        graph.setFinalCity("7");
        graph.setStartCity("1");




        DynamicArray<Edge> shortestPath = simulation.run(graph);
        String shortestPathString = Simulation.printShortestPath(shortestPath);
        System.out.println(shortestPathString);
         
        
        
         

        visualizer.visualize(graph, shortestPath,simulation);
        visualizer.displayShortestPath(shortestPath);
        
    }

    
}

