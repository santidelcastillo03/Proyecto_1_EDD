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

    }
    
    public void visualize(Grafo<City> graph, DynamicArray<Edge> shortestPath,Simulation simulation) {
        System.setProperty("org.graphstream.ui", "swing");
        gsGraph.setAttribute("ui.stylesheet", "graph { fill-color: white; } node { fill-color: black; text-alignment: under; text-size: 20; } edge { fill-color: grey; } edge .marked { fill-color: red; stroke-width: 5px;}");
        String shortestPathString = Simulation.printShortestPath(shortestPath);

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
        displayShortestPath(shortestPath);
        gsGraph.setAttribute("ui.default.title","Cycles made: "+simulation.getCycles()+" \nAnt amount: "+simulation.getNumAnts()+""+shortestPathString);
    }

    public void displayShortestPath(DynamicArray<Edge> shortestPath) {
    for (Edge edge : shortestPath) {
        String edgeId1 = edge.getPrevious().getName() + "-" + edge.getNext().getName();
        String edgeId2 = edge.getNext().getName() + "-" + edge.getPrevious().getName();
        org.graphstream.graph.Edge gsEdge = gsGraph.getEdge(edgeId1);
        if (gsEdge == null) {
            gsEdge = gsGraph.getEdge(edgeId2);
        }
        if (gsEdge != null) {
            gsEdge.setAttribute("ui.class", "marked");
        }
    }
}
    }


