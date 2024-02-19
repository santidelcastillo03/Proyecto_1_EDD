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
    
 public DynamicArray performCycle() {
        DynamicArray<Edge> pathsTraveled = new DynamicArray();
            while (!currentCity.equals(finalCity)) {
                Edge path = decideNextCity(currentCity);
                pathsTraveled.add(path);
                currentCity = path.getNext(); //decideNextCity es el metodo de probabilidad de la hormiga
            }
           currentCity = Grafo.getStartCity();
        return pathsTraveled;
    }

    
    public Edge decideNextCity(City currentCity){
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
            Edge selEdge  = (Edge) probArray.get(random-1);
            
            
            return selEdge;
            
        
    }
    
public void updatePheromones() {
    for (int i = 0; i < Grafo.getEdges().size(); i++){
       Grafo.getEdges().get(i).setPheromones(0);
    }

    }
    
}

