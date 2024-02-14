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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);

        Graph<City> graph = new Graph<>(3);

        // Step 2: Create some City objects and add them to the graph
        City newYork = new City("New York", 40.7128, 74.0060);
        City losAngeles = new City("Los Angeles", 34.0522, 118.2437);
        City chicago = new City("Chicago", 41.8781, 87.6298);

        graph.addNode(newYork);
        graph.addNode(losAngeles);
        graph.addNode(chicago);

        // Step 3: Add edges between the cities
        graph.addEdge(newYork, losAngeles);
        graph.addEdge(newYork, chicago);
        graph.addEdge(losAngeles, chicago);

        // Step 4: Print out the adjacency list of the graph
        for (Node<City> node : graph.nodes) {
            System.out.println(node.data + " is connected to:");
            for (int i = 0; i < node.index; i++) {
                System.out.println(node.adjNodes[i].data);
            }
            System.out.println();
        }
    }
}

    
    
