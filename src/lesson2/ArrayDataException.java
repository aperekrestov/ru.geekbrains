package lesson2;

import static java.lang.Integer.parseInt;

public class ArrayDataException extends RuntimeException {
    private String[][] testArray;

    public ArrayDataException(String arr[][]) {
        this.testArray = arr;
    }

    public void arraySize() {
        if (testArray.length != 4) {
            throw new ArrayIndexOutOfBoundsException("MyArraySizeException");
        }

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                if (testArray[i].length != 4) {
                    throw new ArrayIndexOutOfBoundsException("MyArraySizeException [" + i + "][" + j + "]");
                }
            }
        }

    }

    public void arrayData() {
        int counter = 0;

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                try {
                    counter += parseInt(testArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("MyArrayDataException [" + i + "][" + j +"]");
                }
            }
        }
    }
}
