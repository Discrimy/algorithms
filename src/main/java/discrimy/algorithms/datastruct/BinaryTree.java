package discrimy.algorithms.datastruct;

public interface BinaryTree<T extends Comparable<T>> {
    int size();

    boolean contains(Object object);

    void add(T object);

    T max();

    boolean remove(Object object);
}
