package discrimy.algorithms.datastruct;

import java.util.Objects;
import java.util.Optional;

public class ArrayList<T> implements List<T> {
    private int size = 0;
    private T[] array;

    private void requireIndexInBound(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Size is " + size + " but index is " + index);
    }

    private void changeArraySize(int newSize) {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public ArrayList() {
        //noinspection unchecked
        array = (T[]) new Object[8];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T data) {
        if (size == array.length) {
            changeArraySize(array.length + 8);
        }

        array[size] = data;
        size++;
    }

    @Override
    public T get(int index) {
        requireIndexInBound(index);
        return array[index];
    }

    @Override
    public void remove(int index) {
        requireIndexInBound(index);
        if (size - index + 1 >= 0) System.arraycopy(array, index + 1, array, index, size - index + 1);
        size--;

        if (size == array.length - 8 && size > 8) {
            changeArraySize(array.length - 8);
        }
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Optional<Integer> indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(get(i), o)) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }
}
