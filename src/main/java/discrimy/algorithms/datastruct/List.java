package discrimy.algorithms.datastruct;

import java.util.Optional;

public interface List<T> {
    int size();

    void add(T data);

    T get(int index);

    void remove(int index);

    boolean remove(Object o);

    boolean contains(Object o);

    Optional<Integer> indexOf(Object o);

    Optional<Integer> lastIndexOf(Object o);
}
