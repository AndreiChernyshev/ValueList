/**
 * @author Andrei Chernushev
 * @param <T>
 */
public interface ValueList<T> extends Iterable<T> {
    /**
     * @ Add element of type T to the collection
     * @param t - – element to be inserted
     * @return true if success
     */
    boolean add(T t);
    /**
     * @ Add element of type T to the collection to the position index
     * @param t  – element to be inserted
     * @param index – index at which the specified element is to be inserted element
     * @return true if success
     */
    boolean add(int index, T t);

    /**
     * Returns the element at the specified position in this list.
     * @param index – index of the element to return
     * @return the element at the specified position in this list
     */
    T get( int index);

    /**
     * Removes the element at the specified position in this list
     * @param index  - the index of the element to be removed
     */
    void remove(int index);

    /**
     * Removes all the elements from this list
     */
    void clear();

    /**
     *
     * @return true if list is empty
     */
    boolean isEmpty();

    /**
     *
     * @return size of the list
     */
    int size();

    /**
     * Sorting list in natural order
     */
    void sort();

    /**
     * Sorting list in natural order using quick sort algorithm
     */
    public void quickSort();



    
}
