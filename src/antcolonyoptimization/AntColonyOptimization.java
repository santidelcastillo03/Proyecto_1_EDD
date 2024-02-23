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
        
        /*
        graph = new Grafo();
        
        Simulation simulation = new Simulation(1.0, 2.0, 100, (int) 0.5, 5, 1);
        
        graph.addCity("New york");
        graph.addCity("Los Angeles");
        graph.addCity("Chicago");
        graph.addCity("Dallas");
        graph.addCity("Miami");
         

        graph.addEdge("Miami", "New york", 300);
        graph.addEdge("New york", "Chicago", 800);
        graph.addEdge("Chicago", "Los Angeles", 5000);
        graph.addEdge("Miami", "Dallas", 7000);
        graph.addEdge("Dallas", "Chicago", 3500);
        
        graph.setFinalCity("Los Angeles");
        graph.setStartCity("Miami");
        



        DynamicArray<Edge> shortestPath = simulation.run(graph);
        String shortestPathString = Simulation.printShortestPath(shortestPath);
        System.out.println(shortestPathString);
        */
        
         
    }

    
}

