package discrimy.algorithms;

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
}
