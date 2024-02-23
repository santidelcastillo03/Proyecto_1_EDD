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

        Simulation simulation = new Simulation(1.0, 2.0, 400, 0.5, 15, 1);
        
        
        graph.addCity("1");
        graph.addCity("2");
        graph.addCity("3");
        graph.addCity("4");
        graph.addCity("5");
        graph.addCity("6");
        graph.addCity("7");
        graph.addCity("8");


        graph.addEdge("1","2",10.0);
        graph.addEdge("2", "3", 12.0);
        graph.addEdge("3", "4", 16.0);
        graph.addEdge("2", "5", 4.0);
        graph.addEdge("4", "6", 20.0);
        graph.addEdge("3", "7", 10.0);
        graph.addEdge("6", "8", 1.0);
        graph.addEdge("4", "8", 15.0);
        
        graph.setFinalCity("6");
        graph.setStartCity("1");
        



        DynamicArray<Edge> shortestPath = simulation.run(graph);
        String shortestPathString = Simulation.printShortestPath(shortestPath);
        System.out.println(shortestPathString);

        
        GraphVisualizer visualizer = new GraphVisualizer();

        //visualizer.visualize(graph, shortestPath, simulation);
        visualizer.displayShortestPath(shortestPath);

    }

    
}

