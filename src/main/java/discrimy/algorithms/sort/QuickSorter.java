package discrimy.algorithms.sort;

import java.util.Comparator;

public class QuickSorter<T> extends Sorter<T> {
    public QuickSorter(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length);
    }

    private void quickSort(T[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int pivotIndex = (start + end) / 2;
        T pivotElement = array[pivotIndex];

        int i = start;
        int j = end - 1;
        while (i <= j) {
            while (comparator.compare(array[i], pivotElement) < 0) i++;
            while (comparator.compare(array[j], pivotElement) > 0) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (start < j) {
            quickSort(array, start, j + 1);
        }
        if (end > i) {
            quickSort(array, i, end);
        }
    }
}
