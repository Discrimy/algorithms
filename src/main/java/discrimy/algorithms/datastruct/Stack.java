package discrimy.algorithms.datastruct;

import java.util.Optional;

public interface Stack<T> {
    int size();

    T peek();

    T pop();

    void push(T value);

    Optional<Integer> offset(T value);
}
