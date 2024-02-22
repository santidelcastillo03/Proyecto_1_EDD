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
            Node node = gsGraph.addNode(city.getName());
            node.setAttribute("ui.label", city.getName());
            node.setAttribute("ui.style", "fill-color: blue;");
        }

        for (Edge edge : graph.getEdges()) {
            String edgeId = edge.getPrevious().getName() + "-" + edge.getNext().getName();
           org.graphstream.graph.Edge gsEdge = gsGraph.addEdge(edgeId, edge.getPrevious().getName(), edge.getNext().getName());
            gsEdge.setAttribute("ui.label", String.valueOf(edge.getWeight()));
        }

        gsGraph.display();
    }

    public void displayShortestPath(DynamicArray<Edge> shortestPath) {
        for (Edge edge : shortestPath) {
            String edgeId = edge.getPrevious().getName() + "-" + edge.getNext().getName();
            org.graphstream.graph.Edge gsEdge = gsGraph.getEdge(edgeId);
            if (gsEdge != null) {
                gsEdge.setAttribute("ui.class", "shortest");
            }
        }
    }

}
