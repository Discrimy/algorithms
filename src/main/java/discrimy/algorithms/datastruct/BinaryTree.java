package discrimy.algorithms.datastruct;

public interface BinaryTree<T> {
    int size();

    boolean contains(Object object);

    void add(T object);

    T max();

    T min();

    boolean remove(Object object);
}
