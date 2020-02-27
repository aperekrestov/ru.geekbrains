package lesson2;

public class Lesson2 {

    public static void main(String[] args) {

        GeneratorArray testArray = new GeneratorArray(4, 4, true);
        testArray.getInfo();

        ArrayDataException letCheck = new ArrayDataException(testArray.getArray());
        letCheck.arraySize();
        letCheck.arrayData();

        System.out.println("\nFinish");
    }
}
