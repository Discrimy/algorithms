package discrimy.algorithms.sort;

import java.util.Comparator;

public class MergeSorter<T> extends Sorter<T> {
    public MergeSorter(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(T[] array, int start, int end) {
        if (end - start <= 1) {
//          Array is already sorted, skip
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle, end);
        merge(array, start, middle, end);
    }

    private void merge(T[] array, int start, int middle, int end) {
        // Java cannot create generic type array, so we have create Object array
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[end - start];
        int index1 = start;
        int index2 = middle;
        for (int i = 0; i < result.length; i++) {
            if (index1 == middle) result[i] = array[index2++];
            else if (index2 == end) result[i] = array[index1++];
            else {
                if (comparator.compare(array[index1], array[index2]) < 0) result[i] = array[index1++];
                else if (comparator.compare(array[index2], array[index1]) <= 0) result[i] = array[index2++];
            }
        }

        System.arraycopy(result, 0, array, start, result.length);
    }
}
