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
    private static Random RANDOM = new Random();
    private static City currentCity;
    private static City finalCity;
    private static DynamicArray<Edge> pathsTraveled;
    private static double distanceTraveled;
    

    public Ant(City startCity, City finalCity) {
        this.currentCity = startCity;
        this.finalCity = finalCity;
        this.pathsTraveled = new DynamicArray();
        this.distanceTraveled = 0;
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
    
    public static void setAlpha(double alpha) {
        Ant.alpha = alpha;
    }

    public static void setBeta(double beta) {
        Ant.beta = beta;
    }
    
 
    public static DynamicArray createColony(int numAnts){
        for (int i = 0; i < numAnts; i++){
            Ant newAnt = new Ant(currentCity, finalCity);
            Simulation.getAnts().add(newAnt);
        }
        return Simulation.getAnts();
    }
    
    
    public DynamicArray performCycle() {
            while (!currentCity.equals(finalCity)) {
                Edge path = decideNextCity(currentCity);
                pathsTraveled.add(path);
                distanceTraveled += path.getWeight();
                double pher = path.getPheromones();
                path.setPheromones(pher + (Simulation.getQ()/distanceTraveled));
                distanceTraveled += path.getWeight();
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
        if (total == 0){
            for (int a=0; a < adjNodes.size(); a++){
                probArray.add(adjNodes.get(a));
            }
        }else{
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
        }
           Random rand = new Random();
           int random = (int) rand.nextInt(adjNodes.size());
           Edge selEdge  = (Edge) probArray.get(random);
           return selEdge;
            
        
    }
    
    public static void updatePheromones() {
    double rho = Simulation.getRho();
    for (int i = 0; i < Grafo.getEdges().size(); i++){
       double pher = Grafo.getEdges().get(i).getPheromones();
       Grafo.getEdges().get(i).setPheromones(pher*(1-rho));
    }

    }
    
}

