package discrimy.algorithms.datastruct;

public interface Queue<T> {
    int size();

    boolean contains(Object object);

    void enqueue(T object);

    T dequeue();
}
