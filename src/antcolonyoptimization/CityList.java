/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author Santiago
 */
public class CityList {
    private Node<City> head;
    private int size;

    public CityList() {
        head = null;
        size = 0;
    }

    public void addCity(Node<City> city) {
        if (head == null) {
            head = city;
        } else {
            Node<City> current = head;
            while (current.adjNodes[current.index] != null) {
                current = current.adjNodes[current.index];
            }
            current.adjNodes[current.index] = city;
        }
        size++;
    }

    public void removeCity(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.adjNodes[head.index];
        } else {
            Node<City> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.adjNodes[current.index];
            }
            current.adjNodes[current.index] = current.adjNodes[current.index].adjNodes[current.adjNodes[current.index].index];
        }
        size--;
    }

    public Node<City> getCity(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<City> current = head;
        for (int i = 0; i < index; i++) {
            current = current.adjNodes[current.index];
        }
        return current;
    }

    public int getSize() {
        return size;
    }
}


