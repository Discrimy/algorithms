package discrimy.algorithms.datastruct;

import java.util.Optional;

public interface Map<K, V> {
    int size();

    void put(K key, V value);

    Optional<V> get(K key);

    void remove(K key);
}
