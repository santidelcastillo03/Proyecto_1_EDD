/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author Santiago
 */
public class GraphVisualizer {
    public void visualize(Grafo<City> graph) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph gsGraph = new SingleGraph("Ant Colony Optimization");

        for (City city : graph.getCities()) {
            gsGraph.addNode(city.getName());
        }

        for (Edge edge : graph.getEdges()) {
            String edgeId = edge.getPrevious().getName() + "-" + edge.getNext().getName();
            gsGraph.addEdge(edgeId, edge.getPrevious().getName(), edge.getNext().getName());
        }

        gsGraph.display();
    }
}
