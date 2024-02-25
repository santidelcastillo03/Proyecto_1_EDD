/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *This class is an edge in the graph
 * 
 * @author Vicente Tralci
 */
public class Edge {
    private City previous;
    private double weight;
    private City next;
    private double pheromones;
    /**
     * Constructor
     * 
     * @param previous previous city
     * @param next next city
     * @param weight distance
     */
    public Edge(City previous, City next, double weight) {
        this.previous = previous;
        this.weight = weight;
        this.next = next;
        this.pheromones = 1.0/Grafo.getCities().size();
    }

    /**
     *
     * @return
     */
    public City getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     */
    public void setPrevious(City previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public City getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(City next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public double getPheromones() {
        return pheromones;
    }

    /**
     *
     * @param pheromones
     */
    public void setPheromones(double pheromones) {
        this.pheromones = pheromones;
    }
    
    
}    