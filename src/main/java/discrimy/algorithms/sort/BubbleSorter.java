package discrimy.algorithms.sort;

import java.util.Comparator;

public class BubbleSorter<T> extends Sorter<T> {
    public BubbleSorter(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                int compare = comparator.compare(array[i], array[i + 1]);
                if (compare > 0) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
    }
}
