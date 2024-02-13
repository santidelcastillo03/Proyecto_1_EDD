/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author santiagodelcastillo
 */
public class Graph<T> {
    Node<T>[] nodes;
    int index = 0;

    public Graph(int size) {
        nodes = new Node[size];
    }

    public void addNode(T data) {
        nodes[index++] = new Node<>(data, nodes.length);
    }

    public void addEdge(T data1, T data2) {
        Node<T> node1 = findNode(data1);
        Node<T> node2 = findNode(data2);

        if (node1 != null && node2 != null) {
            node1.addAdjNode(node2);
            node2.addAdjNode(node1);
        }
    }

    private Node<T> findNode(T data) {
        for (Node<T> node : nodes) {
            if (node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }
}
