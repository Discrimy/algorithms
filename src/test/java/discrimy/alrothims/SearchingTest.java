package discrimy.alrothims;

import discrimy.algorithms.Searching;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchingTest {
    Integer[] sortedArray;

    @BeforeEach
    public void prepareSortedArray() {
        sortedArray = new Random().ints(10).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedArray);
    }

    @RepeatedTest(10)
    public void binarySearch() {
        int index = new Random().nextInt(sortedArray.length);
        Integer value = sortedArray[index];
        Optional<Integer> searchedIndex = Searching.binarySearch(sortedArray, value);
        assertEquals(Optional.of(index), searchedIndex);
    }

    @Test
    public void notInArray() {
        Integer[] array = new Integer[]{1, 2, 3};
        Optional<Integer> result = Searching.binarySearch(array, 0);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void emptyArray() {
        Integer[] array = new Integer[0];
        Optional<Integer> result = Searching.binarySearch(array, 0);
        assertEquals(Optional.empty(), result);
    }
}
