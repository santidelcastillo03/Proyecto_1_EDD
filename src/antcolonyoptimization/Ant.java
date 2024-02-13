/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import java.util.Random;
/**
 *
 * @author santiagodelcastillo
 */
public class Ant {
    private static final double alpha = 1.0;
    private static final double beta = 2.0;
    private static final double Q = 1.0;
    private static final Random RANDOM = new Random();
     private Node<City> currentCity;
    private Node<City> destinationCity;

    public Ant(Node<City> startCity, Node<City> destinationCity) {
        this.currentCity = startCity;
        this.destinationCity = destinationCity;
    }
    //revisa si se realizo un ciclo
    public void performCycles(int cycles) {
        for (int i = 0; i < cycles; i++) {
            while (!currentCity.equals(destinationCity)) {
               // currentCity = decideNextCity(currentCity); //decideNextCity es el metodo de probabilidad de la hormiga
            }
           updatePheromones();
        }
    }

    public void updatePheromones() {

    }
    
}
