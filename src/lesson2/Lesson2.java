
package lesson2;

import static java.lang.Integer.parseInt;

public class Lesson2 {
    private static final int ARRAY_SIZE= 4;
    private static CreateArray testArray;

    public static void main(String[] args) {

        testArray = new CreateArray(4, 4, false);
        testArray.getInfo();

        checkArraySize();
        checkArrayData();

        System.out.println("\nFinish");
    }

    private static void checkArraySize() {
        if (testArray.getArray().length != ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < testArray.getArray().length; i++) {
            for (int j = 0; j < testArray.getArray()[i].length; j++) {
                if (testArray.getArray()[i].length != ARRAY_SIZE) {
                    throw new MyArraySizeException();
                }
            }
        }
    }

    public static void checkArrayData() {
        int counter = 0;

        for (int i = 0; i < testArray.getArray().length; i++) {
            for (int j = 0; j < testArray.getArray()[i].length; j++) {
                try {
                    counter += parseInt(testArray.getArray()[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(testArray.getArray()[i][j], i, j );
                }
            }
        }

        System.out.println("Сумма чисел равна " + counter);
    }
}