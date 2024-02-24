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
    
    
    public City moveCity(Grafo grafo, City currentCity, City finalCity, Ant ant){
                Edge path = decideNextCity(currentCity);
                this.pathsTraveled.add(path);
                this.distanceTraveled += path.getWeight();
                distanceTraveled += path.getWeight();
                currentCity = path.getNext();
                updatePheromones(this.pathsTraveled, ant);
                return currentCity;
                
    }
    
   public static void performCycle(Grafo grafo, City finalCity) {
       DynamicArray<Ant> antsMoving = new DynamicArray();
       for (Ant ant : Simulation.getAnts()){
           antsMoving.add(ant);// copia de la colonia
       } int i =0;
       while(antsMoving.size() > 0){
           System.out.println("iteracion" +i);
            DynamicArray<Edge> adjNodes = new DynamicArray();
            int a= 1;
            for(Ant ant : antsMoving){
                System.out.println("hormiga" + a);
                System.out.println("ciudad " + ant.getCurrentCity().getName());
            for (Edge edge : Grafo.getEdges()){
                if(ant.getCurrentCity().equals(edge.getPrevious())){
                adjNodes.add(edge);
         }}
            if (ant.getCurrentCity().equals(grafo.getFinalCity())){
                ant.setCurrentCity(grafo.getStartCity());
                antsMoving.removeN(ant);
            }else if(adjNodes.size() == 0){
                updatePheromones(ant.getPathsTraveled(), ant);
                ant.setCurrentCity(grafo.getStartCity());
            }
                else{
                ant.setCurrentCity(ant.moveCity(grafo, ant.getCurrentCity(), ant.getFinalCity(), ant) );
            }a++;
    }i++;
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
       
            
        
        for(int i = 0; i < adjNodes.size(); i++){
            Edge sEdge = (Edge) adjNodes.get(i);
            double distance = sEdge.getWeight();
            double nPheromones = sEdge.getPheromones();
            double rs = Math.pow(nPheromones, alpha)*Math.pow(Q/distance, beta);
            System.out.println(rs);
            System.out.println(rs/total);
            int prob = (int) Math.round((rs/total)*100);
            System.out.println(adjNodes.get(i).getNext().getName() + "->"+ prob);
            
            
            for(int a = 0; a < prob; a++){
                probArray.add(sEdge);
            }
        }
           Random rand = new Random();
           int random = (int) rand.nextInt(adjNodes.size());
           Edge selEdge  = (Edge) probArray.get(random);
           return selEdge;
        }
        
    }
    
    
    public static void updatePheromones(DynamicArray<Edge> edgesTraveled, Ant ant) {
    double rho = Simulation.getRho();
    double p =  edgesTraveled.get(edgesTraveled.size()-1).getPheromones();
    double b = Simulation.getQ()/ant.distanceTraveled;
    edgesTraveled.get(edgesTraveled.size()-1).setPheromones((1-rho)*p + b); //incremento
    for (int i = edgesTraveled.size() - 1; i > 0; i--){//evaporacion
       double pher = Grafo.getEdges().get(i-1).getPheromones();
       Grafo.getEdges().get(i-1).setPheromones(pher*(1-rho));
        
       }
    }
    }

