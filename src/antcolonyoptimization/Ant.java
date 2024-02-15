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
    private static double alpha = 1.0;
    private static double beta = 2.0;
    private static double Q = 1.0;

    private static int cycles;
    private static Random RANDOM = new Random();
     private Node<City> currentCity;
    private Node<City> finalCity;

    public Ant(Node<City> startCity, Node<City> finalCity) {
        this.currentCity = startCity;
        this.finalCity = finalCity;
    }

    public static double getAlpha() {
        return alpha;
    }

    public static double getBeta() {
        return beta;
    }

    public static double getQ() {
        return Q;
    }

    public static void setCycles(int cycles) {
        Ant.cycles = cycles;
    }
    

    public static void setAlpha(double alpha) {
        Ant.alpha = alpha;
    }

    public static void setBeta(double beta) {
        Ant.beta = beta;
    }
    
    //revisa si se realizo un ciclo
    public void performCycles(int cycles) {
        for (int i = 0; i < cycles; i++) {
            while (!currentCity.equals(finalCity)) {
               // currentCity = decideNextCity(currentCity); //decideNextCity es el metodo de probabilidad de la hormiga
            }
           updatePheromones();
        }
    }

    public void updatePheromones() {

    }
    
}
