package discrimy.algorithms;

import java.util.Arrays;

/**
 * Class with some sorting algorithms
 */
public class Sorting {
    private static <T> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                int compare = array[i].compareTo(array[i + 1]);
                if (compare > 0) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }

        return array;
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1].compareTo(array[j]) > 0) {
                swap(array, j, j - 1);
                j--;
            }
        }

        return array;
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }

        return array;
    }

    public static <T extends Comparable<T>> T[] mergeSort(T[] array) {
        if (array.length > 1) {
            return merge(
                    mergeSort(Arrays.copyOfRange(array, 0, array.length / 2)),
                    mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length)));
        } else {
            return array;
        }
    }

    private static <T extends Comparable<T>> T[] merge(T[] a1, T[] a2) {
        // Java cannot create generic type array, so we have create Comparable array
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[a1.length + a2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (index1 == a1.length) result[i] = a2[index2++];
            else if (index2 == a2.length) result[i] = a1[index1++];
            else {
                if (a1[index1].compareTo(a2[index2]) < 0) result[i] = a1[index1++];
                else if (a2[index2].compareTo(a1[index1]) <= 0) result[i] = a2[index2++];
            }
        }

        return result;
    }

    public static <T extends Comparable<T>> T[] quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int from, int to) {
        if (array.length == 0) return;
        if (from >= to) return;

        int pivotIndex = from + (to - from) / 2;
        T pivot = array[pivotIndex];

        int i = from;
        int j = to;
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) i++;
            while (array[j].compareTo(pivot) > 0) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (from < j) quickSort(array, from, j);
        if (to > i) quickSort(array, i, to);
    }
}
