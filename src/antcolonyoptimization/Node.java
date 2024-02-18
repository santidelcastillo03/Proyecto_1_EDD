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
    DynamicArray<Double> pheromones;
    DynamicArray<Node<T>> adjNodes;

    public Node(T data) {
        this.data = data;
        this.adjNodes = new DynamicArray<>();
        this.pheromones = new DynamicArray<>();
    }

    public void addAdjNode(Node<T> node) {
        adjNodes.add(node);
        pheromones.add(1.0 / adjNodes.size());
    }

    public void removeAdjNode(Node<T> node) {
        int index = -1;
        for (int i = 0; i < adjNodes.size(); i++) {
            if (adjNodes.get(i).equals(node)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            adjNodes.remove(index);
            pheromones.remove(index);
        }
    }

    public DynamicArray<Node<T>> getAdjNodes() {
        return this.adjNodes;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DynamicArray<Double> getAllPheromones() {
        return pheromones;
    }

    public void setAllPheromones(DynamicArray<Double> pheromones) {
        this.pheromones = pheromones;
    }

    
    
}