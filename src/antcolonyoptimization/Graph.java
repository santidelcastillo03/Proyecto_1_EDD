/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import javax.swing.*;

/**
 *
 * @author santiagodelcastillo
 */

public class Graph<T> {
    DynamicArray<Node<T>> nodes;
    Node<T> startCity;
    Node<T> finalCity;

    public Graph() {
        nodes = new DynamicArray<>();
    }

    public void addNode(T data) {
        if (nodes.size() >= 20) {
            JOptionPane.showMessageDialog(null,"you cant add more cities");
        }
        nodes.add(new Node<>(data));
    }

    public void addEdge(T data1, T data2) {
        Node<T> node1 = findNode(data1);
        Node<T> node2 = findNode(data2);
        if (node1 != null && node2 != null) {
            node1.addAdjNode(node2);
            node2.addAdjNode(node1);
        }
    }

    public void removeEdge(T data1, T data2) {
        Node<T> node1 = findNode(data1);
        Node<T> node2 = findNode(data2);
        if (node1 != null && node2 != null) {
            node1.removeAdjNode(node2);
            node2.removeAdjNode(node1);
        }
    }



    private Node<T> findNode(T data) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).data.equals(data)) {
                return nodes.get(i);
            }
        }
        return null;
    }

    public void setStartCity(T data) {
        if (this.startCity != null) {
            throw new IllegalStateException("Start city has already been set");
        }
        Node<T> node = findNode(data);
        if (node != null) {
            this.startCity = node;
        }
    }

    public Node<T> getStartCity() {
        return this.startCity;
    }

    public void setFinalCity(T data) {
        if (this.finalCity != null) {
            throw new IllegalStateException("Final city has already been set");
        }
        Node<T> node = findNode(data);
        if (node != null) {
            this.finalCity = node;
        }
    }

    public Node<T> getFinalCity() {
        return this.finalCity;
    }
}