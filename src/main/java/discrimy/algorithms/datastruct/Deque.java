package discrimy.algorithms.datastruct;

import java.util.Optional;

/**
 * Deque is two-directional queue. You can add, get and remove elements on both sides of deque
 *
 * @param <T> data type
 */
public interface Deque<T> {
    /**
     * Return count of elements
     *
     * @return size
     */
    int size();

    /**
     * Add element to start of deque
     *
     * @param value element
     */
    void pushFirst(T value);

    /**
     * Add element to end of deque
     *
     * @param value element
     */
    void pushLast(T value);

    /**
     * Get element from start of deque and remove it
     *
     * @return element from start
     * @throws DequeEmptyException if deque has no elements
     */
    T popFirst();

    /**
     * Get element from end of deque and remove it
     *
     * @return element from end
     * @throws DequeEmptyException if deque has no elements
     */
    T popLast();

    /**
     * Get element from start of deque
     *
     * @return element from start
     * @throws DequeEmptyException if deque has no elements
     */
    T peekFirst();

    /**
     * Get element from end of deque
     *
     * @return element from end
     * @throws DequeEmptyException if deque has no elements
     */
    T peekLast();

    /**
     * Return true if deque contains this element
     *
     * @param object element
     * @return do deque contains it
     */
    boolean contains(Object object);

    /**
     * Return index of first occurrence of element
     *
     * @param object element
     * @return index or Optional.empty()
     */
    Optional<Integer> indexOf(Object object);

    /**
     * Return index of last occurrence of element
     *
     * @param object element
     * @return index or Optional.empty()
     */
    Optional<Integer> lastIndexOf(Object object);
}
