package discrimy.algorithms.datastruct;

public interface Set<T> {
    void size();

    boolean contains(Object object);

    void add(T object);

    boolean remove(Object object);

    T pop();

    Set<T> union(Set<T> another);

    Set<T> insertion(Set<T> another);

    Set<T> difference(Set<T> another);

    boolean isSubset(Set<T> another);
}
