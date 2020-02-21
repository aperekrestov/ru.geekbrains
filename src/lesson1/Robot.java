package lesson1;

public class Robot implements Member {

    public final int MAX_RUN = 10000;
    public final int MAX_JUMP = 1000;
    public String name;

    public Robot(String name) {
        this.name = name + " Noob Saibot";
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
