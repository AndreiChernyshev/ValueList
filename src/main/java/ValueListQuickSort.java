import java.util.Stack;

public class ValueListQuickSort<T extends Comparable<? super T>>  {

    public  void quickSort(T[] numbers, int size) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(size);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
    }
    private int partition(T[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        T piv = input[position];
        swap(input, position, end - 1);
        while (l < h) {
            if (input[l].compareTo(piv) < 0) {
                l++;
            } else if (input[h].compareTo(piv) >= 0) {
                h--;
            }
            else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if (input[h].compareTo(piv) < 0) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx; }
    private  void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
