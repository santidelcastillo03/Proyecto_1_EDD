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

    public static Random getRANDOM() {
        return RANDOM;
    }

    public static void setRANDOM(Random RANDOM) {
        Ant.RANDOM = RANDOM;
    }

    public static City getCurrentCity() {
        return currentCity;
    }

    public static void setCurrentCity(City currentCity) {
        Ant.currentCity = currentCity;
    }

    public static City getFinalCity() {
        return finalCity;
    }

    public static void setFinalCity(City finalCity) {
        Ant.finalCity = finalCity;
    }

    public static DynamicArray<Edge> getPathsTraveled() {
        return pathsTraveled;
    }

    public static void setPathsTraveled(DynamicArray<Edge> pathsTraveled) {
        Ant.pathsTraveled = pathsTraveled;
    }

    public static double getDistanceTraveled() {
        return distanceTraveled;
    }

    public static void setDistanceTraveled(double distanceTraveled) {
        Ant.distanceTraveled = distanceTraveled;
    }
    
    
    public static void setAlpha(double alpha) {
        Ant.alpha = alpha;
    }

    public static void setBeta(double beta) {
        Ant.beta = beta;
    }
    
 
    public static DynamicArray createColony(int numAnts, Grafo grafo){
        for (int i = 0; i < numAnts; i++){
            Ant newAnt = new Ant(grafo.getStartCity(), grafo.getFinalCity());
            Simulation.getAnts().add(newAnt);
        }
        return Simulation.getAnts();
    }
    
    
    public City moveCity(Grafo grafo, City currentCity, City finalCity){
                Edge path = decideNextCity(currentCity);
                this.pathsTraveled.add(path);
                this.distanceTraveled += path.getWeight();
                distanceTraveled += path.getWeight();
                currentCity = path.getNext();
                updatePheromones(pathsTraveled);
                return currentCity;
                
    }
    
   public static void performCycle(Grafo grafo, City finalCity) {
       DynamicArray<Ant> antsMoving = new DynamicArray();
       for (Ant ant : Simulation.getAnts()){
           antsMoving.add(ant);
       }
       while(antsMoving.size() > 0){
        for(Ant ant : antsMoving){
            if (ant.getCurrentCity().equals(grafo.getFinalCity()) || ant.decideNextCity(currentCity).equals(null)){
                ant.setCurrentCity(grafo.getStartCity());
                antsMoving.removeN(ant);
            }else{
                ant.setCurrentCity(ant.moveCity(grafo, ant.getCurrentCity(), ant.getFinalCity()));
            }
    }
   }}




    
    public Edge decideNextCity(City currentCity){
        DynamicArray<Edge> probArray = new DynamicArray();
        DynamicArray<Edge> adjNodes = new DynamicArray();
        int len = Grafo.getEdges().size();
        for(int i = 0; i < len; i++){
            if (Grafo.getEdges().get(i).getPrevious().equals(currentCity)){       
                adjNodes.add(Grafo.getEdges().get(i));
                
            }
        }
       
           
        
        if (adjNodes.size() == 1){
            return adjNodes.get(0);
            
        }else if(adjNodes.size() == 0){
            Edge restart = null;
            for(int i = 0; i < Grafo.getEdges().size(); i++){
                if (Grafo.getEdges().get(i).getPrevious() == Grafo.getStartCity()){
                    restart = Grafo.getEdges().get(i);
                    break;
                }
            }
            return restart;
        }
        
        else{
        double total = 0;
        for(int i = 0; i < adjNodes.size(); i++){
            Edge sEdge = (Edge) adjNodes.get(i);
            double distance = sEdge.getWeight();
            double nPheromones = sEdge.getPheromones();
            total += Math.pow(nPheromones, alpha)*Math.pow(Q/distance, beta);
        }
        double w = adjNodes.get(0).getPheromones();
        boolean bool = true;
        for(int g = 1; g < adjNodes.size(); g++){
            if(w != adjNodes.get(g).getPheromones()){
                bool = false;
            }
        }
        
        if (total == 0 || bool == false){
        Edge e = adjNodes.get(0);
        for(int g = 1; g < adjNodes.size(); g++){
            if(e.getWeight() > adjNodes.get(g).getWeight()){
                e = adjNodes.get(g);
            }
            return e;
            
        }}else{
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
    }
    
    public static void updatePheromones(DynamicArray<Edge> edgesTraveled) {
    double rho = Simulation.getRho();
    double p =  edgesTraveled.get(edgesTraveled.size()-1).getPheromones();
    double b = Simulation.getQ()/distanceTraveled;
    edgesTraveled.get(edgesTraveled.size()-1).setPheromones((1-rho)*p + b);
    for (int i = edgesTraveled.size() - 1; i > 0 && i < Grafo.getEdges().size(); i--){
       double pher = Grafo.getEdges().get(i).getPheromones();
       Grafo.getEdges().get(i).setPheromones(pher*(1-rho));
        
       }
    }
    }

