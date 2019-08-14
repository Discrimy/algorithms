package discrimy.algorithms;

import java.util.Optional;

public class Searching {
    // Search index of element is sorted array (from smaller to bigger)
    public static <T extends Comparable<T>> Optional<Integer> binarySearch(T[] sortedArray, T value) {
        if (sortedArray.length == 0) return Optional.empty();

        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int compare = value.compareTo(sortedArray[middle]);
            if (compare == 0) return Optional.of(middle);
            else if (compare > 0) left = middle + 1;
            else right = middle - 1;
        }

        return Optional.empty();
    }
}
