package discrimy.algorithms.datastruct;

import java.util.Optional;

/**
 * Interface for list implementations
 *
 * @param <T> data types
 */
public interface List<T> {
    /**
     * Return count of elements
     *
     * @return size
     */
    int size();

    /**
     * Add element in end of the list
     * @param data element
     */
    void add(T data);

    /**
     * Get element by specific index (starts by 0)
     * @param index index
     * @return element on this index
     * @throws IndexOutOfBoundsException if list do not contains any element of this index
     */
    T get(int index);

    /**
     * Remove element by its index
     * @param index index
     * @throws IndexOutOfBoundsException if list do not contains any element of this index
     */
    void remove(int index);

    /**
     * Remove first occurrence of this element in list
     * @param o element
     * @return true if such element was deleted, false otherwise
     */
    boolean remove(Object o);

    /**
     * Return true if list has such element
     * @param o element
     * @return true if list contains it, false otherwise
     */
    boolean contains(Object o);

    /**
     * Return index of first occurrence of this element
     * @param o element
     * @return index or Optional.empty() if list do not contains is
     */
    Optional<Integer> indexOf(Object o);

    /**
     * Return index of last occurrence of this element
     * @param o element
     * @return index or Optional.empty() if list do not contains is
     */
    Optional<Integer> lastIndexOf(Object o);
}
