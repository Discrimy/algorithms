package discrimy.algorithms.datastruct;

import java.util.Optional;

/**
 * Data structure what describes stack interface
 * Stack is data structure what lets save and permit data in FILO (First in, last out)
 * This can be described by stack of dishes - you have to get all dishes up before get first
 *
 * @param <T> data type
 */
public interface Stack<T> {
    /**
     * Return stack's size
     *
     * @return stack's size
     */
    int size();

    /**
     * Get last element, do not remove it from stack
     * @return last element
     * @throws StackEmptyException if stack has no elements
     */
    T peek();

    /**
     * Get and remove last element from stack
     * @return last element
     * @throws StackEmptyException if stack has no elements
     */
    T pop();

    /**
     * Put element on top of stack
     * @param value element
     */
    void push(T value);

    /**
     * Get offset of first occurrence of element
     *                         4  3  2  1  0
     * For example, for stack [1, 2, 3, 4, 5] <- top
     * Offset of 2 is 3
     * @param value element for search
     * @return index of first such element or Optional.empty()
     */
    Optional<Integer> offset(T value);
}
