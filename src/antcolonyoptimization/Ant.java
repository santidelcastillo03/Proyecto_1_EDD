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
    private static double alpha;
    private static double beta;
    private static double Q;
    private static int cycles;
    private static Random RANDOM = new Random();
    private City currentCity;
    private City finalCity;
    private static int totalAnts;

    public static int getTotalAnts() {
        return totalAnts;
    }

    public static void setTotalAnts(int totalAnts) {
        Ant.totalAnts = totalAnts;
    }
    

    public Ant(City startCity, City finalCity) {
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

    
    public City decideNextCity(City currentCity){
        DynamicArray probArray = new DynamicArray();
        DynamicArray adjNodes = new DynamicArray();
        int len = Grafo.getEdges().size();
        for(int i = 0; i < len; i++){
            if (Grafo.getEdges().get(i).getPrevious().equals(currentCity)){
                adjNodes.add(Grafo.getEdges().get(i));
            }
        }
        double total = 0;
        for(int i = 0; i < adjNodes.size(); i++){
            Edge sEdge = (Edge) adjNodes.get(i);
            double distance = sEdge.getWeight();
            double nPheromones = sEdge.getPheromones();
            total += Math.pow(nPheromones, alpha)*Math.pow(Q/distance, beta);
        }
        for(int i = 0; i < adjNodes.size(); i++){
            Edge sEdge = (Edge) adjNodes.get(i);
            double distance = sEdge.getWeight();
            double nPheromones = sEdge.getPheromones();
            double rs = Math.pow(nPheromones, alpha)*Math.pow(Q/distance, beta);
            int prob = (int) Math.round((rs/total)*100);
            
            for(int a = 0; a < prob; a++){
                probArray.add(sEdge);
            }
        }
           
            int random = (int) (Math.random()*1000);
            City city  = (City) probArray.get(random-1);
            
            
            return city;
            
        
    }
    
public void updatePheromones() {
    

    }
    
}
