/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Santiago
 */
public class DynamicArray<T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;

    public DynamicArray() {
        array = new Object[2];
    }

    public void add(T item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

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

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }



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

        public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
