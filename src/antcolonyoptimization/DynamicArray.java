/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *This class is a dynamic array that can be resized
 * 
 * @author Santiago del Castillo
 * @param <T>
 */
public class DynamicArray<T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;
    /**
     * Constructor
     */
    public DynamicArray() {
        array = new Object[2];
    }
    /**
     * Adds item to the array
     * If its full, it will resize
     * 
     * @author Santiago del Castillo
     * @param item the item to add
     */
    public void add(T item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }
    /**
     * Removes item
     * 
     * @author Angel Garcia
     * @param index the index of the item to remove
     */
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    /**
     * Removes item
     * 
     * @author Santiago del Castillo
     * @param element element to remove
     */
    public void removeN(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            remove(index);
        }
    }
    /**
     * Gets the item from a specific index
     * 
     * @author Vicente Tralci
     * @param index
     * @return 
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }
    /**
     * @author Angel Garcia
     * @return the size of the array
     */
    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }


        /**
         * @author Vicente Tralci
         * @return an iterator of the elements of the array
         */
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < size && array[currentIndex] != null;
                }

                @Override
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return (T) array[currentIndex++];
                }
            };
        }

    /**
     *
     * @param item
     * @return
     */
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
