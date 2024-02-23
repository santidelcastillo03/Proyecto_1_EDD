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
        
        Simulation simulation = new Simulation(1.0, 2.0, 200, (int) 0.5, 10, 1);
        
        /*
        graph.addCity("New york");
        graph.addCity("Los Angeles");
        graph.addCity("Chicago");
        graph.addCity("Dallas");


        graph.addEdge("New york", "Los Angeles", 100);
        graph.addEdge("Los Angeles", "Chicago", 100);
        graph.addEdge("Chicago", "Dallas", 100);
        graph.addEdge("New york", "Dallas", 50);
        
        graph.setFinalCity("Dallas");
        graph.setStartCity("New york");
        



        DynamicArray<Edge> shortestPath = simulation.run(graph);
        String shortestPathString = Simulation.printShortestPath(shortestPath);
        System.out.println(shortestPathString);
        */
        
       
    }

    
}

