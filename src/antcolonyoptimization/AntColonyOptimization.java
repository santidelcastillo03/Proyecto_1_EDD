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
        
        Grafo<City> grafo = new Grafo<>();

        City city1 = new City("City1", 0.0, 0.0);
        City city2 = new City("City2", 1.0, 3.0);
        City city3 = new City("City3", 2.0, 5.0);

    grafo.addNode(city1);
    grafo.addNode(city2);
    grafo.addNode(city3);

    grafo.addEdge(city1, city2);
    grafo.addEdge(city2, city3);

    GraphVisualizer visualizer = new GraphVisualizer();
    visualizer.visualize(grafo);
        
        
    }
}

/*City newYork = new City("New York", 40.7128, 74.0060);
        City losAngeles = new City("Los Angeles", 34.0522, 118.2437);
        City chicago = new City("Chicago", 41.8781, 87.6298);
        City testCity = new City("Test City", 0, 0);
        City penis = new City("penis City", 1, 0);



        grafo.addNode(newYork);
        grafo.addNode(losAngeles);
        grafo.addNode(chicago);
        grafo.addNode(testCity);
        grafo.addNode(penis);

        grafo.addEdge(newYork, losAngeles);
        grafo.addEdge(newYork, chicago);
        grafo.addEdge(losAngeles, chicago);
        grafo.addEdge(penis, testCity);

        for (int i = 0; i < grafo.nodes.size(); i++) {
            Node<City> node = grafo.nodes.get(i);
            System.out.println(node.data + " is connected to:");
            for (int j = 0; j < node.adjNodes.size(); j++) {
                System.out.println(node.adjNodes.get(j).data);
            }
            System.out.println();
        }
        System.out.println("Added Test City. The size of the graph is now: " + grafo.nodes.size());

        grafo.removeNode(testCity);
        System.out.println("Removed Test City. The size of the graph is now: " + grafo.nodes.size());
        grafo.setStartCity(newYork);
        grafo.setFinalCity(chicago);
        System.out.println("The size of the graph is: " + grafo.nodes.size());
        System.out.println(grafo.startCity.data);
        System.out.println(grafo.finalCity.data);
        
        GraphVisualizer visualizer = new GraphVisualizer();
        visualizer.visualize(grafo);
    
    */
