/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author Santiago
 */
public class Node<T> {
    T data;
    double[] pheromones;
    Node<T>[] adjNodes;
    int index = 0;

    public Node(T data, int size) {
        this.data = data;
        this.adjNodes = new Node[size];
        this.pheromones = new double[size];
    }

    public void addAdjNode(Node<T> node, int size) {
        adjNodes[index] = node;
        pheromones[index] = 1.0 / size;
        index++;
    }
}
