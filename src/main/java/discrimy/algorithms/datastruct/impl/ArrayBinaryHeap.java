package discrimy.algorithms.datastruct.impl;

import discrimy.algorithms.datastruct.BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayBinaryHeap<T extends Comparable<T>> implements BinaryHeap<T> {
    private List<T> list = new ArrayList<>();

    public ArrayBinaryHeap() {
    }

    private ArrayBinaryHeap(T[] array) {
        list.addAll(Arrays.asList(array));

        for (int i = list.size() / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public static <T extends Comparable<T>> ArrayBinaryHeap<T> fromArray(T[] array) {
        return new ArrayBinaryHeap<>(array);
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean contains(Object object) {
        return contains(0, object);
    }

    private boolean contains(int index, Object object) {
        if (index >= list.size()) return false;

        if (Objects.equals(list.get(index), object)) {
            return true;
        }

        return contains(2 * index + 1, object) || contains(2 * index + 2, object);
    }

    @Override
    public void add(T object) {
        list.add(object);

        int i = list.size() - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && list.get(i).compareTo(list.get(parent)) > 0) {
            swap(i, parent);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void heapify(int i) {
        int left;
        int right;
        int largest;

        while (true) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            largest = i;

            if (left < list.size() && list.get(left).compareTo(list.get(largest)) > 0) {
                largest = left;
            }

            if (right < list.size() && list.get(right).compareTo(list.get(largest)) > 0) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            swap(largest, i);
            i = largest;
        }
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public T pop() {
        T result = peek();
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        heapify(0);
        return result;
    }
}
