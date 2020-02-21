package lesson1;

public class Human implements Competitor {
    public static final int MAX_RUN = 1000;
    public static final int MAX_JUMP = 50;

    @Override
    public int run() {
        System.out.println("человек может пробежать на " + MAX_RUN);
        return MAX_RUN;
    }

    @Override
    public int jump() {
        System.out.println("человек может прагнуть на " + MAX_JUMP);
        return MAX_JUMP;
    }
}
