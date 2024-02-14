/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author Santiago
 */
public class Simulation {
    private double alpha;
    private double beta;
    private int rho;
    private int numAnts;
    private int cycles;
    private CityList cityList;
    private Graph<City> graph;
    
    public Simulation(double alpha, double beta, int cycles, int rho, int numAnts) {
        this.alpha = alpha;
        this.beta = beta;
        this.numAnts = numAnts;
        this.rho = rho;
        this.cycles = cycles;
        this.cityList = new CityList();
        this.graph = new Graph<>(cityList.getSize());
    }
    
       public void setAlpha(double alpha) {
        Ant.setAlpha(alpha);
    }//cambia el valor de alpha en la clase Ant

    public void setBeta(double beta) {
        Ant.setBeta(beta);
    }//igual que arriba pero beta

    public void setCycles(int cycles) {
        this.cycles = cycles;
        Ant.setCycles(cycles);
    }
    public void deleteCity(String name) {
        if (graph.nodes.length <= 4) {
            return;
        }
        Node<City> cityToDelete = null;
        int indexToDelete = -1;
        for (int i = 0; i < cityList.getSize(); i++) {
            Node<City> cityNode = cityList.getCity(i);
            if (cityNode.data.getName().equals(name)) {
                cityToDelete = cityNode;
                indexToDelete = i;
                break;
            }
        }

        if (cityToDelete == null) {
            return;
        }

        if (cityToDelete.equals(graph.startCity) || cityToDelete.equals(graph.finalCity)) {
            return;
        }

        for (int i = 0; i < cityList.getSize(); i++) {
            Node<City> cityNode = cityList.getCity(i);
            cityNode.removeAdjNode(cityToDelete);
        }

        cityList.removeCity(indexToDelete);
    }

    public void connectCities(String cityName1, String cityName2) {
        Node<City> cityNode1 = cityList.getCityByName(cityName1);
        Node<City> cityNode2 = cityList.getCityByName(cityName2);
        if (cityNode1 != null && cityNode2 != null) {
            this.graph.addEdge(cityNode1.data, cityNode2.data);
        }
    }
    
      public void addCity(String name, double xCoordinate, double yCoordinate) {
        if (cityList.getSize() >= 20) {
            return;
        }

        City newCity = new City(name, xCoordinate, yCoordinate);
        Node<City> newNode = new Node<>(newCity, cityList.getSize() + 1);

        for (int i = 0; i < cityList.getSize(); i++) {
            Node<City> cityNode = cityList.getCity(i);
            double distance = calculateDistance(cityNode.data, newCity);
            cityNode.addAdjNode(newNode, cityList.getSize() + 1);
            newNode.addAdjNode(cityNode, cityList.getSize() + 1);
        }

        cityList.addCity(newNode);
      }
      
      public void setStartCity(String name, double xCoordinate, double yCoordinate) {
    City newCity = new City(name, xCoordinate, yCoordinate);
    Node<City> newNode = new Node<>(newCity, cityList.getSize() + 1);
    for (int i = 0; i < cityList.getSize(); i++) {
        Node<City> cityNode = cityList.getCity(i);
        double distance = calculateDistance(cityNode.data, newCity);
        cityNode.addAdjNode(newNode, cityList.getSize() + 1);
        newNode.addAdjNode(cityNode, cityList.getSize() + 1);
    }
    this.graph.setStartCity(newNode.data);
    this.cityList.addCity(newNode);
      }
      
      public void setFinalCity(String name, double xCoordinate, double yCoordinate) {
    City newCity = new City(name, xCoordinate, yCoordinate);
    Node<City> newNode = new Node<>(newCity, cityList.getSize() + 1);
    for (int i = 0; i < cityList.getSize(); i++) {
        Node<City> cityNode = cityList.getCity(i);
        double distance = calculateDistance(cityNode.data, newCity);
        cityNode.addAdjNode(newNode, cityList.getSize() + 1);
        newNode.addAdjNode(cityNode, cityList.getSize() + 1);
    }
    this.graph.setFinalCity(newNode.data);
    this.cityList.addCity(newNode);
}
      
      private double calculateDistance(City city1, City city2) {
        double xDistance = Math.abs(city1.getxCoordinate() - city2.getxCoordinate());
        double yDistance = Math.abs(city1.getyCoordinate() - city2.getyCoordinate());
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }
    
      public void run() {
          
      }
    
    
}
