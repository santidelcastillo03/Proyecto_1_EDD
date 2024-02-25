/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import javax.swing.*;

/**
 *This class is a graph data structure
 * Contains methods for adding and removing cities and edges,
 * as well as validating existence of cities and edges
 * 
 * @author Santiago del Castillo
 * @param <T>
 */

public class Grafo<T> {
    private static DynamicArray<City> cities;
    private static DynamicArray<Edge> edges;
    private static City startCity;
    private static City finalCity;
    
    /**
     * Constructor
     */
    public Grafo() {
        cities = new DynamicArray<>();
        edges = new DynamicArray<>();
    }
    
    /**
     * Adds city to the graph
     * 
     * @author Santiago del Castillo
     * @param data name of the city
     */
    public void addCity(String data) {
        //if (cities.size() >= 20) {
          //  JOptionPane.showMessageDialog(null,"you can't add more cities");
        //}
        cities.add(new City(data));
    }
    
    /**
     * Adds an edge to the graph
     * 
     * @author Vicente Tralci
     * @param data1 name of the first city
     * @param data2 name of the second city
     * @param weight distance 
     * @return 
     */
    public Edge addEdge(String data1, String data2, double weight) {
        City city1 = findCity(data1);
        City city2 = findCity(data2);
        if (city1 != null && city2 != null) {
            Edge newEdge = new Edge(city1, city2, weight);
            this.edges.add(newEdge);
            return newEdge;

        }
        else{
            return null;
        }
    }
    /**
     * Remove a city from the graph
     * 
     * @author Santiago del Castillo
     * @param cityName name of the city to delete
     */
    public void removeCity(String cityName) {
        City cityToRemove = findCity(cityName);
        if (cityToRemove != null) {
            int cityIndex = cities.indexOf(cityToRemove);
            if (cityIndex != -1) {
                cities.remove(cityIndex);
            }

            for (int i = edges.size() - 1; i >= 0; i--) {
                Edge edge = edges.get(i);
                if (edge.getPrevious().equals(cityToRemove) || edge.getNext().equals(cityToRemove)) {
                    edges.remove(i);
                }
            }
        }
    }
    /**
     * Resets the start and final city
     */
    public void reset() {
        this.startCity = null;
        this.finalCity = null;
    }

    /**
     *
     * @param cities
     */
    public void setCities(DynamicArray<City> cities) {
        this.cities = cities;
    }
    
    /**
     *
     * @param edges
     */
    public void setEdges(DynamicArray<Edge> edges) {
        this.edges = edges;
    }

    /**
     *
     * @return
     */
    public static DynamicArray<Edge> getEdges() {
        return edges;
    }
    /**
     * Removes an edge from the graph
     * 
     * @author Santiago del Castillo
     * @param data1 name of the first city
     * @param data2 name of the second city
     */
    public void removeEdge(String data1, String data2) {
        City city1 = findCity(data1);
        City city2 = findCity(data2);
        if (city1 != null && city2 != null) {
            for(int i=0; i < this.edges.size(); i++){
                if(edges.get(i).getPrevious() == city1 && edges.get(i).getNext() == city2){
                    edges.get(i).setPrevious(null);
                    edges.get(i).setNext(null);
                    edges.remove(i);     
                }
            }
            
        }
    }
    /**
     * Finds a city
     * @author Vicente Tralci
     * @param data name of the city
     * @return the city if exists, otherwise null
     */
    private City findCity(String data) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(data)) {
                return cities.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param data
     */
    public void setStartCity(String data) {
        if (this.startCity != null) {
            throw new IllegalStateException("Start city has already been set");
        }
        City city = findCity(data);
        if (city != null) {
            this.startCity = city;
        }
    }

    /**
     *
     * @return
     */
    public static City getStartCity() {
        return Grafo.startCity;
    }

    /**
     *
     * @param data
     */
    public void setFinalCity(String data) {
        if (this.finalCity != null) {
            throw new IllegalStateException("Final city has already been set");
        }
        City city= findCity(data);
        if (city != null) {
            this.finalCity = city;
        }
    }

    /**
     *
     * @return
     */
    public static City getFinalCity() {
        return finalCity;
    }

    /**
     *
     * @return
     */
    public static DynamicArray<City> getCities() {
        return Grafo.cities;
    }
    /**
     * Prints all cities
     */
    public void printCities() {
        for (City city : cities) {
            
            System.out.println(city.getName());
        }
    }
    /**
     * Prints all edges
     */
    public void printEdges() {
        for (Edge edge : edges) {
            System.out.println(edge.getPrevious().getName()+"-"+edge.getNext().getName()+"-"+edge.getWeight());
        }
    }
    /**
     * Checks if the city exists
     * 
     * @author Santiago del Castillo
     * @param cityName name of the city
     * @return true if city exists, false if not
     */
    public boolean cityExists(String cityName) {
        for (City city : this.getCities()) {
            if (city.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public boolean startCityExists() {
        return this.getStartCity() != null;
    }

    /**
     *
     * @return
     */
    public boolean finalCityExists() {
        return this.getFinalCity() != null;
    }
    /**
     * Checks if a connection exists between two cities
     * 
     * @author Angel Garcia
     * @param cityName1
     * @param cityName2
     * @return 
     */
     public boolean connectionExists(String cityName1, String cityName2) {
        for (Edge edge : this.getEdges()) {
            if ((edge.getPrevious().getName().equals(cityName1) && edge.getNext().getName().equals(cityName2)) ||
                (edge.getPrevious().getName().equals(cityName2) && edge.getNext().getName().equals(cityName1))) {
                return true;
            }
        }
        return false;
    }
     /**
      * Checks if all cities are connected
      * 
      * @author Santiago del Castillo
      * @return true if all cities are connected, false if not
      */
    public boolean allCitiesHaveEdges() {
        for (City city : this.getCities()) {
            boolean hasEdge = false;
            for (City otherCity : this.getCities()) {
                if (!city.equals(otherCity) && this.connectionExists(city.getName(), otherCity.getName())) {
                    hasEdge = true;
                    break;
                }
            }
            if (!hasEdge) {
                return false;
            }
        }
        return true;
    }
}