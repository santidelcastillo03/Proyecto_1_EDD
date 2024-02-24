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
    private City currentCity;
    private static City finalCity;
    private DynamicArray<Edge> pathsTraveled;
    private double distanceTraveled;
    

    public Ant(City startCity, City finalCity) {
        this.currentCity = Grafo.getStartCity();
        this.finalCity = Grafo.getFinalCity();
        this.pathsTraveled = new DynamicArray();
        this.distanceTraveled = 0;
        this.alpha = Simulation.getAlpha();
        this.beta = Simulation.getBeta();
        this.Q = Simulation.getQ();
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

    public City getCurrentCity() {
        return currentCity;
    }

    public  void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public  City getFinalCity() {
        return finalCity;
    }

    public  void setFinalCity(City finalCity) {
        this.finalCity = finalCity;
    }

    public DynamicArray<Edge> getPathsTraveled() {
        return pathsTraveled;
    }

    public void setPathsTraveled(DynamicArray<Edge> pathsTraveled) {
        this.pathsTraveled = pathsTraveled;
    }

    public  double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
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
    
    
    public City moveCity(Grafo grafo, City previous, City currentCity, City finalCity, Ant ant){
                Edge path = decideNextCity(previous, currentCity, finalCity, ant);
                this.pathsTraveled.add(path);
                this.distanceTraveled += path.getWeight();
                distanceTraveled += path.getWeight();
                if(path.getNext().equals(currentCity)){
                    currentCity = path.getPrevious();
                }else{
                currentCity = path.getNext();
                }
                System.out.println(currentCity.getName());
                return currentCity;
                
    }
    
   public static void performCycle(Grafo grafo, City finalCity) {
       DynamicArray<Ant> antsMoving = new DynamicArray();
       for (Ant ant : Simulation.getAnts()){
           antsMoving.add(ant);// copia de la colonia
       } int i =0;
       
       while(antsMoving.size() > 0){
           System.out.println("iteracion" +i);
           System.out.println("hormigas moviendose " + antsMoving.size());
            DynamicArray<Edge> adjNodes = new DynamicArray();
            int a= 1;
            for(Ant ant : antsMoving){
                System.out.println(ant);
                System.out.println("ciudad " + ant.getCurrentCity().getName());
            for (Edge edge : Grafo.getEdges()){
                if(ant.getCurrentCity().equals(edge.getPrevious())){
                adjNodes.add(edge);
         }}
            if (ant.getCurrentCity().equals(grafo.getFinalCity())){
                ant.setCurrentCity(grafo.getStartCity());
                System.out.println("fuera");
                antsMoving.removeN(ant);
                updatePheromones(ant.getPathsTraveled(), ant);
            }else if(adjNodes.size() == 0){
                ant.setCurrentCity(grafo.getStartCity());
                antsMoving.removeN(ant);
            }
                else{
                City previousCity = ant.getCurrentCity();
                ant.setCurrentCity(ant.moveCity(grafo, previousCity, ant.getCurrentCity(), ant.getFinalCity(), ant) );
                System.out.println("->" + ant.getCurrentCity().getName());
            }a++;
    }i++;
           
   }}

    
    public Edge decideNextCity(City previous, City currentCity, City finalCity, Ant ant){
        System.out.println("papa");
        DynamicArray<Edge> probArray = new DynamicArray();
        DynamicArray<Edge> adjNodes = new DynamicArray();
        int len = Grafo.getEdges().size();
        for(int i = 0; i < len; i++){
            if (Grafo.getEdges().get(i).getPrevious().equals(currentCity) || Grafo.getEdges().get(i).getNext().equals(currentCity)){       
                adjNodes.add(Grafo.getEdges().get(i));
            }
        }
        

        if (adjNodes.size() == 1){
            return adjNodes.get(0);
        }
        
        else{
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
            System.out.println(adjNodes.get(i).getPrevious().getName()+ adjNodes.get(i).getNext().getName() + "->"+ prob);
            
            for(int a = 0; a < prob; a++){
                probArray.add(sEdge);
            }
        }
           Random rand = new Random();
            
           System.out.println("len " + probArray.size());
           int random = (int) rand.nextInt(probArray.size());
           System.out.println("random" + random);
           Edge selEdge  = (Edge) probArray.get(random);
           return selEdge;
        }
        
    }
    
    
    public static void updatePheromones(DynamicArray<Edge> edgesTraveled, Ant ant) {
    double rho = Simulation.getRho();
    double b = Simulation.getQ()/ant.distanceTraveled;
    for (int i = 0; i < edgesTraveled.size(); i++){//evaporacion
        double p = edgesTraveled.get(i).getPheromones();
           edgesTraveled.get(i).setPheromones((1-rho)*p + b);
       }
    }
    }

