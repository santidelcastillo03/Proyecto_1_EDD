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
    private Graph gsGraph;
    
    public GraphVisualizer() {
        gsGraph = new SingleGraph("Ant Colony Optimization");
       gsGraph.setAttribute("ui.stylesheet", "edge.shortest {fill-color: red;}");
    }
    
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
    
    public void displayShortestPath(DynamicArray<Edge> shortestPath) {
        System.out.println("Shortest path:");
        for (int i = 0; i < shortestPath.size(); i++) {
            Edge edge = shortestPath.get(i);
            System.out.println(edge.getPrevious().getName() + " -> " + edge.getNext().getName() + " : " + edge.getWeight());

            org.graphstream.graph.Edge graphEdge = gsGraph.getEdge(edge.getPrevious().getName() + edge.getNext().getName());
            if (graphEdge != null) {
                graphEdge.setAttribute("ui.class", "shortest");
            }
        }
    }

}
