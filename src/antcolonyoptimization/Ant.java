/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import java.util.Random;
/**
 *This class is a single ant in the colony
 * Contains method such as create colony, move to city, perform a cycle,
 * update pheromones and decide which city to go next
 * 
 * @author Santiago del Castillo
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
    
    /**
     * Constructor
     * 
     * @param startCity
     * @param finalCity 
     */
    public Ant(City startCity, City finalCity) {
        this.currentCity = Grafo.getStartCity();
        this.finalCity = Grafo.getFinalCity();
        this.pathsTraveled = new DynamicArray();
        this.distanceTraveled = 0;
        this.alpha = Simulation.getAlpha();
        this.beta = Simulation.getBeta();
        this.Q = Simulation.getQ();
    }

    /**
     *
     * @return
     */
    public static double getAlpha() {
        return alpha;
    }

    /**
     *
     * @return
     */
    public static double getBeta() {
        return beta;
    }

    /**
     *
     * @return
     */
    public static double getQ() {
        return Q;
    }

    /**
     *
     * @return
     */
    public static Random getRANDOM() {
        return RANDOM;
    }

    /**
     *
     * @param RANDOM
     */
    public static void setRANDOM(Random RANDOM) {
        Ant.RANDOM = RANDOM;
    }

    /**
     *
     * @return
     */
    public City getCurrentCity() {
        return currentCity;
    }

    /**
     *
     * @param currentCity
     */
    public  void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    /**
     *
     * @return
     */
    public  City getFinalCity() {
        return finalCity;
    }

    /**
     *
     * @param finalCity
     */
    public  void setFinalCity(City finalCity) {
        this.finalCity = finalCity;
    }

    /**
     *
     * @return
     */
    public DynamicArray<Edge> getPathsTraveled() {
        return pathsTraveled;
    }

    /**
     *
     * @param pathsTraveled
     */
    public void setPathsTraveled(DynamicArray<Edge> pathsTraveled) {
        this.pathsTraveled = pathsTraveled;
    }

    /**
     *
     * @return
     */
    public  double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     *
     * @param distanceTraveled
     */
    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
    
    /**
     *
     * @param alpha
     */
    public static void setAlpha(double alpha) {
        Ant.alpha = alpha;
    }

    /**
     *
     * @param beta
     */
    public static void setBeta(double beta) {
        Ant.beta = beta;
    }
    
    /**
     * Creates a colony of ants 
     * 
     * @author Vicnete Tralci
     * @param numAnts the number of ants to create
     * @param grafo
     * @return the colony of ants
     */
    public static DynamicArray createColony(int numAnts, Grafo grafo){
        for (int i = 0; i < numAnts; i++){
            Ant newAnt = new Ant(grafo.getStartCity(), grafo.getFinalCity());
            Simulation.getAnts().add(newAnt);
        }
        return Simulation.getAnts();
    }
    
    /**
     * Moves the ant to another city
     * 
     * @author Vicente Tralci
     * @param grafo
     * @param previous the previous city
     * @param currentCity the current city
     * @param finalCity the final city
     * @param ant the ant
     * @return the new current city
     */
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
                updatePheromones(this.pathsTraveled, ant);
                System.out.println(currentCity.getName());
                return currentCity;
                
    }
    /**
     * Performs a cycle
     * 
     * @author Vicente Tralci
     * @param grafo the graph containing the cities
     * @param finalCity the final city
     */
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
            }else if(adjNodes.size() == 0){
                updatePheromones(ant.getPathsTraveled(), ant);
                ant.setCurrentCity(grafo.getStartCity());
            }
                else{
                City previousCity = ant.getCurrentCity();
                ant.setCurrentCity(ant.moveCity(grafo, previousCity, ant.getCurrentCity(), ant.getFinalCity(), ant) );
                System.out.println("->" + ant.getCurrentCity().getName());
            }a++;
    }i++;
           
   }}

    /**
     * Decides the next city an ant will move to
     * 
     * @author Vicente Tralci
     * @param previous the previous city
     * @param currentCity the current city
     * @param finalCity the final city
     * @param ant the ant to move
     * @return the edge to the next city
     */
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
            if(ant.pathsTraveled.size()-1 >= 0){
                System.out.println(ant.getPathsTraveled().get(ant.getPathsTraveled().size()-1).getPrevious().getName() + " " + ant.getPathsTraveled().get(ant.getPathsTraveled().size()-1).getPrevious().getName());
            for(Edge edge : adjNodes){
                if(edge.getNext().equals(finalCity) || edge.getPrevious().equals(finalCity)){
                    return edge;
                }
                else if (ant.pathsTraveled.get(ant.pathsTraveled.size()-1).equals(edge)){   
                System.out.println("hola");
                adjNodes.removeN(edge);
                }
        }}
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
    
    /**
     * Updates the pheromones on the edges traveled 
     * 
     * @author Vicente Tralci
     * @param edgesTraveled the edges traveled by the ant
     * @param ant the ant that traveled the paths
     */
    public static void updatePheromones(DynamicArray<Edge> edgesTraveled, Ant ant) {
    double rho = Simulation.getRho();
    double p =  edgesTraveled.get(edgesTraveled.size()-1).getPheromones();
    double b = Simulation.getQ()/ant.distanceTraveled;
    Edge lastEdge = edgesTraveled.get(edgesTraveled.size()-1);
    lastEdge.setPheromones((1-rho)*p + b); //incremento
    for (int i = 0; i < Grafo.getEdges().size(); i++){//evaporacion
        if(!Grafo.getEdges().get(i).equals(lastEdge)){
           double pher = Grafo.getEdges().get(i).getPheromones();
           Grafo.getEdges().get(i).setPheromones(pher*(1-rho));
       }
       System.out.println(Grafo.getEdges().get(i).getPrevious().getName() +" -> " + Grafo.getEdges().get(i).getNext().getName() + " " +Grafo.getEdges().get(i).getPheromones());
       }
    }
    }

