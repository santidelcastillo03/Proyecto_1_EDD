/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonyoptimization;

/**
 *
 * @author Santiago
 */
public class DynamicArray<T> {
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

    public void removeN(Node<T> node) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(node)) {
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


}
