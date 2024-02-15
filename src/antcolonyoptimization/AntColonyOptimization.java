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

        Graph<City> graph = new Graph<>();

        // Step 2: Create some City objects and add them to the graph
        City newYork = new City("New York", 40.7128, 74.0060);
        City losAngeles = new City("Los Angeles", 34.0522, 118.2437);
        City chicago = new City("Chicago", 41.8781, 87.6298);
        City testCity = new City("Test City", 0, 0);
        City penis = new City("penis City", 1, 0);



        graph.addNode(newYork);
        graph.addNode(losAngeles);
        graph.addNode(chicago);
        graph.addNode(testCity);
        graph.addNode(penis);

        graph.addEdge(newYork, losAngeles);
        graph.addEdge(newYork, chicago);
        graph.addEdge(losAngeles, chicago);
        graph.addEdge(penis, testCity);

        for (int i = 0; i < graph.nodes.size(); i++) {
            Node<City> node = graph.nodes.get(i);
            System.out.println(node.data + " is connected to:");
            for (int j = 0; j < node.adjNodes.size(); j++) {
                System.out.println(node.adjNodes.get(j).data);
            }
            System.out.println();
        }
        System.out.println("Added Test City. The size of the graph is now: " + graph.nodes.size());

        graph.removeNode(testCity);
        System.out.println("Removed Test City. The size of the graph is now: " + graph.nodes.size());
        graph.setStartCity(newYork);
        graph.setFinalCity(chicago);
        System.out.println("The size of the graph is: " + graph.nodes.size());
        System.out.println(graph.startCity.data);
        System.out.println(graph.finalCity.data);
    }
}

    
    
