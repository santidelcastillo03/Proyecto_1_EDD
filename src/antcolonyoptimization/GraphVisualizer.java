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

        for (Node<City> node : graph.getNodes()) {
            gsGraph.addNode(node.data.getName());
        }

        int edgeId = 0;
        for (Node<City> node : graph.getNodes()) {
            for (Node<City> adjNode : node.getAdjNodes()) {
                gsGraph.addEdge(String.valueOf(edgeId++), node.data.getName(), adjNode.data.getName());
            }
        }

        gsGraph.display();
    }
}
