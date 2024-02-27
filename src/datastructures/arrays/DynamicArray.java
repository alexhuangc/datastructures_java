package datastructures.arrays;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPCITY = 10;

    public DynamicArray() {
        array = new Object[DEFAULT_CAPCITY];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public int size() {
        return size;
    }    
}