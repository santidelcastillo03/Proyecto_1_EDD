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
    Node<T>[] adjNodes;
    int index = 0;

    public Node(T data, int size) {
        this.data = data;
        this.adjNodes = new Node[size];
    }

    public void addAdjNode(Node<T> node) {
        adjNodes[index++] = node;
    }
}
