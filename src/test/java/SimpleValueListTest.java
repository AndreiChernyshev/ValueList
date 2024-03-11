import junit.framework.TestCase;

public class SimpleValueListTest extends TestCase {
    ValueList<Character> alphabet = new SimpleValueList<>();
    ValueList<String> unsortedList = new SimpleValueList<>();
    ValueList<MetalSheet> areasList = new SimpleValueList<>();
    @Override
    protected void setUp()  {
        //Creating ValueList with type Character
        for (char c = 65; c <= 90; c++) {
            alphabet.add(c);
        }
        //Creating ValueList with custom class which implements Comparable
        areasList.add(new MetalSheet(10, 10));
        areasList.add(new MetalSheet(1, 10));
        areasList.add(new MetalSheet(1, 11));
        areasList.add(new MetalSheet(2, 3));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 7));
        areasList.add(new MetalSheet(3, 8));
        areasList.add(new MetalSheet(3, 8));
        //Creating unsorded ValueList
        unsortedList.add("Vlada");
        unsortedList.add("Andrei");
        unsortedList.add("Vika");
        }
    private String generateActualString(ValueList valueList){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object s : valueList){
              if(s != null){
                  stringBuilder.append(s);
              }
            }
        return stringBuilder.toString();
        }


    public void testAdd() {
        alphabet.add('1');
        alphabet.add('2');
        alphabet.add('3');
        String expectedString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123";
        String actualString = generateActualString(alphabet);
        assertEquals(expectedString, actualString);
    }

    public void testTestAdd() {
        alphabet.add(1,'1');
        alphabet.add(2,'2');
        alphabet.add(5,'3');
        String expectedString = "A12BC3DEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals(expectedString, generateActualString(alphabet));
    }

    public void testRemove() {
        alphabet.remove(0);
        alphabet.remove(6);
        String expectedString = "BCDEFGIJKLMNOPQRSTUVWXYZ";
        assertEquals(expectedString, generateActualString(alphabet));
    }

    public void testGet() {
        assertEquals((Character) 'C', alphabet.get(2));
    }

    public void testClear() {
        alphabet.clear();
        assertEquals(0, alphabet.size());
    }

    public void testIsEmpty() {
        alphabet.clear();
        assertEquals(0, alphabet.size());
    }

    public void testSize() {
        assertEquals(26, alphabet.size());
    }

     public void testSort() {
        String expectedString = "AndreiVikaVlada";
         unsortedList.sort();
         assertEquals(expectedString, generateActualString(unsortedList));
    }

    public void testQuickSort() {
        String expectedString = "S=6S=10S=11S=21S=21S=21S=21S=21S=21S=21S=21S=24S=24S=100";
        areasList.sort();
        assertEquals(expectedString, generateActualString(areasList));

    }
}