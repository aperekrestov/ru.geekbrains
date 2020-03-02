
package lesson2;

import static java.lang.Integer.parseInt;

public class Lesson2 {
    private static CreateArray testArray;

    public static void main(String[] args) {

        testArray = new CreateArray(4, 4, true);
        testArray.getInfo();

        checkArraySize();
        checkArrayData();

        System.out.println("\nFinish");
    }

    private static void checkArraySize() {
        if (testArray.getArray().length != 4) {
            throw new ArrayIndexOutOfBoundsException("MyArraySizeException");
        }

        for (int i = 0; i < testArray.getArray().length; i++) {
            for (int j = 0; j < testArray.getArray()[i].length; j++) {
                if (testArray.getArray()[i].length != 4) {
                    throw new ArrayIndexOutOfBoundsException("MyArraySizeException [" + i + "][" + j + "]");
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
                    throw new NumberFormatException("MyArrayDataException [" + i + "][" + j +"]");
                }
            }
        }
    }
}