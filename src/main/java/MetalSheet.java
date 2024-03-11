/**
 * Simple class implements Comparable for using in tests with SimpleValueList
 */
public class MetalSheet implements Comparable {
private int width;
private int length;

    public MetalSheet(int width, int length) {
        this.width = width;
        this.length = length;
    }
    public int sheetArea(){
        return width * length;
    }

    @Override
    public String toString() {
        return "S=" + this.sheetArea();
    }

    @Override
    public int compareTo(Object o) {
        return this.sheetArea() - ((MetalSheet)o).sheetArea();

    }
}
