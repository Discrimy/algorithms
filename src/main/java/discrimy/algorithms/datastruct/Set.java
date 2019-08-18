package discrimy.algorithms.datastruct;

/**
 * Set is unordered collection of unique elements
 *
 * @param <T> data type
 */
public interface Set<T> {
    /**
     * Get count of elements
     *
     * @return size
     */
    int size();

    /**
     * Return true if set contains such element, else false
     *
     * @param object element
     * @return do set contains object
     */
    boolean contains(Object object);

    /**
     * Add object to set, if such element already in, when do not change set
     * @param object element
     */
    void add(T object);

    /**
     * Remove element from set
     * If set don't contains such element, return false and do nothing
     * Else return true
     * @param object element
     * @return do element removed
     */
    boolean remove(Object object);

    /**
     * Get element from set and remove it
     * @return element
     * @throws SetEmptyException if set is empty
     */
    T pop();

    /**
     * Return new set that contains all element from this and another sets
     * @param another another set
     * @return new set
     */
    Set<T> union(Set<T> another);

    /**
     * Return new set of elements, that were in both sets
     * @param another another set
     * @return new set
     */
    Set<T> insertion(Set<T> another);

    /**
     * Return new set of elements do not contained in both sets in one time
     * @param another another set
     * @return new set
     */
    Set<T> difference(Set<T> another);

    /**
     * Return do this set contains all elements from another
     * @param another another set
     * @return is this set subset of another
     */
    boolean isSubset(Set<T> another);
}
