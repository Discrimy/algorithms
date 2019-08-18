package discrimy.algorithms.datastruct;

/**
 * Interface of queue
 * Implements FIFO (First in, first out)
 *
 * @param <T> data type
 */
public interface Queue<T> {
    /**
     * Return count of elements
     *
     * @return size
     */
    int size();

    /**
     * Return do queue contains this object
     * @param object element
     * @return do queue contains this object
     */
    boolean contains(Object object);

    /**
     * Add element in end of the queue
     * @param object element
     */
    void enqueue(T object);

    /**
     * Get next element and remove it from queue
     * @return next element
     * @throws QueueEmptyException if queue has no elements
     */
    T dequeue();
}
