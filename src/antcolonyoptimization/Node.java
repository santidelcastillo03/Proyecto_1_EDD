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
    double[] pheromones; //cantidad de feromonas en la arista entre el node y cada node adyacente
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



    public void removeAdjNode(Node<T> node) {
        for (int i = 0; i < index; i++) {
            if (adjNodes[i].equals(node)) {
                for (int j = i; j < index - 1; j++) {
                    adjNodes[j] = adjNodes[j + 1];
                    pheromones[j] = pheromones[j + 1];
                }
                index--;
                break;
            }
        }
    }
}
