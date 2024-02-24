/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author Santiago
 */
public class Edge {
    private City previous;
    private double weight;
    private City next;
    private double pheromones;

    public Edge(City previous, City next, double weight) {
        this.previous = previous;
        this.weight = weight;
        this.next = next;
        this.pheromones = 1.0/Grafo.getCities().size();
    }

    public City getPrevious() {
        return previous;
    }

    public void setPrevious(City previous) {
        this.previous = previous;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public City getNext() {
        return next;
    }

    public void setNext(City next) {
        this.next = next;
    }

    public double getPheromones() {
        return pheromones;
    }

    public void setPheromones(double pheromones) {
        this.pheromones = pheromones;
    }
    
    
}    