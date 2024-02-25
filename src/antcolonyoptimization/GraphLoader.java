/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *This class is responsible for the reading writing of files
 * Contains methods like loading a file, saving file and checking if its compatible
 * 
 * @author Santiago del Castillo
 */
public class GraphLoader {
    private Grafo<City> graph;
    /**
     * Constructor
     * @param graph 
     */
    public GraphLoader(Grafo<City> graph) {
        this.graph = graph;
    }
    /**
     * Loads a file using JFileChooser
     * 
     * @author Santiago del Castillo
     */
    public void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (!isFileCompatible(selectedFile)) {
                JOptionPane.showMessageDialog(null, "The file is not compatible");
                return;
            }
            
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                boolean isCity = true;
                String lastCity = null;
                while ((line = br.readLine()) != null) {
                    if (line.equals("ciudad")) {
                        continue;
                    }
                    if (line.equals("aristas")) {
                        isCity = false;
                        if (lastCity != null) {
                            graph.setFinalCity(lastCity);
                        }
                        continue;
                    }
                    if (isCity) {
                        City city = new City(line);
                        graph.addCity(city.getName());
                        if (graph.getStartCity() == null) {
                            graph.setStartCity(city.getName());
                            
                        }
                        lastCity = city.getName();
                                               
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
        }
    }
    /**
     * Saves a file
     * 
     * @author Santiago del Castillo
     */
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
    /**
     * Checks if file is compatible
     * 
     * @author Vicente Tralci
     * @param file the selected file
     * @return true if its compatible, false if not
     */
    public boolean isFileCompatible(File file) {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        boolean isCity = true;
        while ((line = br.readLine()) != null) {
            if (isCity) {
                if (line.equals("aristas")) {
                    isCity = false;
                    continue;
                }
                if (line.trim().isEmpty()) {
                    return false;
                }
            } else {
                String[] edgeData = line.split(",");
                if (edgeData.length != 3) {
                    return false;
                }
                try {
                    Double.parseDouble(edgeData[2]);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
    } catch (IOException e) {
        return false;
    }
    return true;
}
}


