package discrimy.alrothims;

import discrimy.algorithms.Sorting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingTest {
    Integer[] array;
    Integer[] sortedArray;

    @BeforeEach
    public void randomizeArray() {
        array = new Random().ints(1000).boxed().toArray(Integer[]::new);
        sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
    }

    @RepeatedTest(100)
    public void bubbleSort() {
        assertArrayEquals(Sorting.bubbleSort(array), sortedArray);
    }

    @RepeatedTest(100)
    public void insertionSort() {
        assertArrayEquals(Sorting.insertionSort(array), sortedArray);
    }

    @RepeatedTest(100)
    public void selectionSort() {
        assertArrayEquals(Sorting.selectionSort(array), sortedArray);
    }

    @RepeatedTest(100)
    public void mergeSort() {
        assertArrayEquals(Sorting.mergeSort(array), sortedArray);
    }

    @RepeatedTest(100)
    public void quickSort() {
        assertArrayEquals(Sorting.quickSort(array), sortedArray);
    }
}
