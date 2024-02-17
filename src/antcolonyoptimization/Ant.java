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
               currentCity = decideNextCity(currentCity); //decideNextCity es el metodo de probabilidad de la hormiga
            }
           updatePheromones();
        }
    }

    
    public Node decideNextCity(Node currentCity){
        DynamicArray probArray = new DynamicArray();
        double total = 0;
        for(int i = 0; i < currentCity.getAdjNodes().size(); i++){
            Node b = (Node) currentCity.getAdjNodes().get(i);
            City bCity = (City) b.getData();
            double bCityY = bCity.getyCoordinate();
            double bCityX = bCity.getyCoordinate();
            City aCity = (City) currentCity.getData();
            double aCityY = aCity.getyCoordinate();
            double aCityX = aCity.getyCoordinate();
            double distance = Math.sqrt(Math.pow((bCityX - aCityX), 2) + Math.pow((bCityY - aCityY), 2));
            double nPheromones = (double) currentCity.getAllPheromones().get(i);
            total += Math.pow(nPheromones, alpha)*Math.pow(Q/distance, beta);
        }
        for(int i = 0; i < currentCity.getAdjNodes().size(); i++){
            Node b = (Node) currentCity.getAdjNodes().get(i);
            City bCity = (City) b.getData();
             double bCityY = bCity.getyCoordinate();
            double bCityX = bCity.getyCoordinate();
            City aCity = (City) currentCity.getData();
            double aCityY = aCity.getyCoordinate();
            double aCityX = aCity.getyCoordinate();
            double distance = Math.sqrt(Math.pow((bCityX - aCityX), 2) + Math.pow((bCityY - aCityY), 2));
            double nPheromones = (double) currentCity.getAllPheromones().get(i);
            double rs = Math.pow(nPheromones, alpha)*Math.pow(Q/distance, beta);
            int prob = (int) Math.round((rs/total)*100);
            
            for(int a = 0; a < prob; a++){
                probArray.add(b);
            }
        }
           
            int random = (int) (Math.random()*100);
            Node city  = (Node) probArray.get(random-1);
            
            
            return city;
            
        
    }
    
public void updatePheromones() {

    }
    
}
