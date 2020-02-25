package lesson2;

public class GenerateArray {

    private int line;
    private int column;

    public GenerateArray(int line, int column, boolean multiTypeArray) {
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
        String tablet[][] = new String[line][column];

        for (int i = 0; i < tablet.length; i++) {
            for (int j = 0; j < tablet[i].length; j++) {
                tablet[i][j] = "" + counter;
                counter ++;
            }
        }

        printArr(tablet);
    }

    private void createMultiTypeArray() {
        int counter = 1;
        String tablet[][] = new String[line][column];

        for (int i = 0; i < tablet.length; i++) {
            for (int j = 0; j < tablet[i].length; j++) {

                if (j % 2 == 0) {
                    tablet[i][j] = "" + counter;
                } else {
                    // TODO: 25.02.2020 передать counter в ячейку без приведения в String и передать исключение 
                    tablet[i][j] = "?";
                }

                counter ++;
            }
        }

        printArr(tablet);
    }

    public static void printArr(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
