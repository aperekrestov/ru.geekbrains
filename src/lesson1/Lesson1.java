
package lesson1;

public class Lesson1 {

    private static final int MAX_BARRIER_HEIGHT = 50;
    private static final int MAX_BARRIER_WIDTH = 50000;

    public static void main(String[] args) {

        Stage1 stage1 = new Stage1();
        stage1.createMember(30, MAX_BARRIER_WIDTH, MAX_BARRIER_HEIGHT);
        stage1.createBarrier(10, MAX_BARRIER_WIDTH, MAX_BARRIER_HEIGHT);
        stage1.checkWin();
        stage1.printWin();
    }
}