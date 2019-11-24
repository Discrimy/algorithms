package discrimy.algorithms.sort;

import java.util.Comparator;

public abstract class Sorter<T> {
    Comparator<T> comparator;

    public Sorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    static <T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public abstract void sort(T[] array);
}
