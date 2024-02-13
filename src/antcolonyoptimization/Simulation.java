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
    private int cycles;
    private CityList cityList;
    
    public Simulation(double alpha, double beta, int cycles) {
        this.alpha = alpha;
        this.beta = beta;
        this.cycles = cycles;
        this.cityList = new CityList();
    }

    public void deleteCity(String name) {
        // Find the city to delete
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
            System.out.println("City not found.");
            return;
        }

        for (int i = 0; i < cityList.getSize(); i++) {
            Node<City> cityNode = cityList.getCity(i);
            cityNode.removeAdjNode(cityToDelete);
        }

        cityList.removeCity(indexToDelete);
    }
    
      public void addCity(String name, double xCoordinate, double yCoordinate) {
        if (cityList.getSize() >= 20) {
            System.out.println("Cannot add more cities. The limit is 20.");
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
      
      private double calculateDistance(City city1, City city2) {
        double xDistance = Math.abs(city1.getxCoordinate() - city2.getxCoordinate());
        double yDistance = Math.abs(city1.getyCoordinate() - city2.getyCoordinate());
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }
    
      public void run() {
          
      }
    
    
}
