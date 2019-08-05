package discrimy.alrothims;

import discrimy.algorithms.Sorting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingTest {
    Integer[] array;
    Integer[] sortedArray;

    @BeforeEach
    public void randomizeArray() {
        array = new Random().ints(10).boxed().toArray(Integer[]::new);
        sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
    }

    private <T extends Comparable<T>> Stream<DynamicTest> sortingDynamicTest(int count, Function<Integer[], Integer[]> sortingFunc) {
        return IntStream.range(0, count)
                .mapToObj((i) ->
                        DynamicTest.dynamicTest("Random test", () -> {
                            randomizeArray();
                            assertArrayEquals(sortingFunc.apply(array), sortedArray);
                        })
                );
    }

    @TestFactory
    public Stream<DynamicTest> bubbleSortDynamic() {
        return sortingDynamicTest(100, Sorting::bubbleSort);
    }

    @TestFactory
    public Stream<DynamicTest> insertionSortDynamic() {
        return sortingDynamicTest(100, Sorting::insertionSort);
    }

    @TestFactory
    public Stream<DynamicTest> selectionSortDynamic() {
        return sortingDynamicTest(100, Sorting::selectionSort);
    }
}
