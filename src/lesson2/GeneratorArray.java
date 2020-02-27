package lesson2;

public class GeneratorArray {
    private String testArray[][];
    private int line;
    private int column;

    public GeneratorArray(int line, int column, boolean multiTypeArray) {
        this.line = line;
        this.column = column;

        if (multiTypeArray) {
            createMultiTypeArray();
        } else {
            createRegularStringArray();
        }
    }

    private void createRegularStringArray() {
        int counter  = 1;
        testArray = new String[line][column];

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                testArray[i][j] = "" + counter;
                counter ++;
            }
        }
    }

    private void createMultiTypeArray() {
        int counter = 1;
        testArray = new String[line][column];

        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {

                if (j % 2 == 0) {
                    testArray[i][j] = "" + counter;
                } else {
                    testArray[i][j] = "?";
                }

                counter ++;
            }
        }
    }

    private void printArr(String[][] arr) {
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void getInfo() {
        printArr(testArray);
    }

    public String[][] getArray() {
        return testArray;
    }
}
