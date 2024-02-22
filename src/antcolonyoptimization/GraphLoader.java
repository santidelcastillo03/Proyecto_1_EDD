/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Santiago
 */
public class GraphLoader {
    private Grafo<City> graph;

    public GraphLoader(Grafo<City> graph) {
        this.graph = graph;
    }

    public void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            City startCity = null;
            City finalCity = null;
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                boolean isCity = true;
                while ((line = br.readLine()) != null) {
                    if (line.equals("ciudad")) {
                        continue;
                    }
                    if (line.equals("aristas")) {
                        isCity = false;
                        continue;
                    }
                    if (isCity) {
                        City city = new City(line);
                        graph.addCity(city.getName());
                        if (startCity == null) {
                            startCity = city;
                        }
                        finalCity = city;
                    } else {
                        String[] edgeData = line.split(",");
                        String city1 = edgeData[0];
                        String city2 = edgeData[1];
                        double distance = Double.parseDouble(edgeData[2]);
                        graph.addEdge(city1, city2, distance);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Start City: " + startCity);
            System.out.println("Final City: " + finalCity);
        }
    }
    public void saveToFile() {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToSave))) {
                    bw.write("ciudad\n");
                    for (City city : graph.getCities()) {
                        bw.write(city.getName() + "\n");
                    }

                    bw.write("aristas\n");
                    for (Edge edge : graph.getEdges()) {
                        bw.write(edge.getPrevious().getName() + "," + edge.getNext().getName() + "," + edge.getWeight() + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}


