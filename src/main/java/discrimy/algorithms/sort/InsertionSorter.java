package discrimy.algorithms.sort;

import java.util.Comparator;

public class InsertionSorter<T> extends Sorter<T> {
    public InsertionSorter(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && comparator.compare(array[j - 1], array[j]) > 0) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }
}
