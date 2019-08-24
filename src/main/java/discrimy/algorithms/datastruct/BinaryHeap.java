package discrimy.algorithms.datastruct;

public interface BinaryHeap<T extends Comparable<T>> {
    int size();

    boolean contains(Object object);

    void add(T object);

    T peek();

    T pop();
}
