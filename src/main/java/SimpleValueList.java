import java.util.Arrays;
import java.util.Iterator;

public class SimpleValueList<T extends Comparable<T>> implements ValueList<T>{
    /**
     * Base array of this list
     */
    private T[] elementsData;
    /**
     * size of list
     */
    private int size;

    /**
     * Constructor of the list.
     * @param initCapacity - initial capacity of list
     * @throws IllegalArgumentException if initCapacity under the zero
     */
    public SimpleValueList(int initCapacity) {
        if(initCapacity < 0){
            throw new IllegalArgumentException("Wrong size: " + initCapacity);
        }
            this.elementsData = (T[]) new Comparable[initCapacity];
    }

    /**
     * Default constructor of SimpleValueList. Create list with 10 elements
     */
    public SimpleValueList(){
        this(10);
    }

    /**
     * Check required capacity of the list for adding element(s)
     * If capacity is not enough, enlarge capacity by multiplying on 1.5 + 1
     * @param requiredCapacity - size of the list after adding new element(s)
     */
    @SuppressWarnings(value = "unchecked")
    private void checkCapacity(int requiredCapacity){
        if(requiredCapacity > elementsData.length){
            Object[] oldValueList = this.elementsData;
            int newSize = this.size * 3 / 2 + 1;
            this.elementsData = (T[]) new  Comparable[newSize];
            System.arraycopy(oldValueList, 0, elementsData, 0, oldValueList.length);
        }
    }

    /**
     * Check index is valid. Index must be more or equals than 0. Index must be less then list size
     * @param index - index for element to add
     */
    private void checkRange(int index){
        if(index < 0 || index >= this.size + 1){
            throw new IllegalArgumentException("Wrong index: " + index);
        }
    }

    @Override
    public boolean add(T t) {
        checkCapacity(this.size + 1);
        elementsData[this.size++] = t;
        return true;
    }

    @Override
    public boolean add(int index, T t) {
        checkRange(index);
        checkCapacity(this.size + 1);
        System.arraycopy(this.elementsData, index, elementsData, index + 1, size - index);
        elementsData[index] = t;
        this.size++;
        return true;
    }
    @Override
    public void remove(int index) {
       for(int i = index; i < size; i++){
           elementsData[i] = elementsData[i + 1];
           elementsData[size] = null;
       }
    }
    @Override
    public T get(int index) {
        return this.elementsData[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++){
            elementsData[i] = null;
        }
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ValueListIterator<>(elementsData);
    }
    @Override
    @SuppressWarnings(value = "unchecked")
    public void sort (){
        T[] tempArray = (T[]) new Comparable[size];
        System.arraycopy(elementsData, 0, tempArray, 0, size);
        Arrays.sort(tempArray);
        elementsData = tempArray;

    }
    public void quickSort(){
        ValueListQuickSort<T> vqs = new ValueListQuickSort<>();
        vqs.quickSort(elementsData, size);
    }


}
