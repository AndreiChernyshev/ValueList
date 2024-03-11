import java.util.Iterator;

/**
 * Iterator for SimpleValueList. Allows to use for-each cycle
 * @param <T> - type of the list
 */
public class ValueListIterator<T> implements Iterator<T> {
    private int index = 0;
    private T[] listData;

    public ValueListIterator(T[] listData) {
        this.listData = listData;
    }

    @Override
    public boolean hasNext() {
        return index < listData.length;
    }

    @Override
    public T next() {
        return listData[index++];
    }
}
