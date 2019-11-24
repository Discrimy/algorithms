package discrimy.alrothims;

import discrimy.algorithms.sort.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SorterTest {
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
        Sorter<Integer> sorter = new BubbleSorter<Integer>(Comparator.naturalOrder());
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @RepeatedTest(100)
    public void insertionSort() {
        Sorter<Integer> sorter = new InsertionSorter<Integer>(Comparator.naturalOrder());
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @RepeatedTest(100)
    public void selectionSort() {
        Sorter<Integer> sorter = new SelectionSorter<Integer>(Comparator.naturalOrder());
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @RepeatedTest(100)
    public void mergeSort() {
        Sorter<Integer> sorter = new MergeSorter<Integer>(Comparator.naturalOrder());
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @RepeatedTest(100)
    public void quickSort() {
        Sorter<Integer> sorter = new QuickSorter<Integer>(Comparator.naturalOrder());
        sorter.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}
