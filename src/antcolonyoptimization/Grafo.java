/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import javax.swing.*;

/**
 *
 * @author santiagodelcastillo
 * @param <T>
 */

public class Grafo<T> {
    private DynamicArray<City> cities;
    private DynamicArray<Edge> edges;
    private City startCity;
    private City finalCity;

    public Grafo() {
        cities = new DynamicArray<>();
        edges = new DynamicArray<>();
    }
    
    

    public void addCity(T data) {
        if (cities.size() >= 20) {
            JOptionPane.showMessageDialog(null,"you can't add more cities");
        }
        cities.add(new City((String) data));
    }

    public Edge addEdge(T data1, T data2, double weight) {
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

    public void setCities(DynamicArray<City> cities) {
        this.cities = cities;
    }

    public void setEdges(DynamicArray<Edge> edges) {
        this.edges = edges;
    }


    public DynamicArray<Edge> getEdges() {
        return edges;
    }

    public void removeEdge(T data1, T data2) {
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

    private City findCity(T data) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).equals(data)) {
                return cities.get(i);
            }
        }
        return null;
    }

    public void setStartCity(T data) {
        if (this.startCity != null) {
            throw new IllegalStateException("Start city has already been set");
        }
        City city = findCity(data);
        if (city != null) {
            this.startCity = city;
        }
    }

    public City getStartCity() {
        return this.startCity;
    }

    public void setFinalCity(T data) {
        if (this.finalCity != null) {
            throw new IllegalStateException("Final city has already been set");
        }
        City city= findCity(data);
        if (city != null) {
            this.finalCity = city;
        }
    }

    public City getFinalCity() {
        return this.finalCity;
    }

    public DynamicArray<City> getCities() {
        return this.cities;
    }
}