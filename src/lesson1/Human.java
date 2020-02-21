package lesson1;

public class Human implements Member {

    public static final int MAX_RUN = 1000;
    public static final int MAX_JUMP = 50;
    public String name;

    public Human(String name) {
        this.name = name + " from Africa";
    }

    @Override
    public int run() {
        System.out.println(name + " can run " + MAX_RUN);
        return MAX_RUN;
    }

    @Override
    public int jump() {
        System.out.println(name + " can jump " + MAX_JUMP);
        return MAX_JUMP;
    }
}
