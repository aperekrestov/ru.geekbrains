package lesson1;

import java.util.Random;

public class Human implements Member {

    public static final int MAX_RUN = 50000;
    public static final int MAX_JUMP = 50;

    private int personalRunRecord;
    private int personalJumpRecord;
    public String name;

    public Human(String name) {
        this.name = name + " from Africa";
        System.out.println(name);

        Random random = new Random();
        personalRunRecord = random.nextInt(MAX_RUN);
        personalJumpRecord = random.nextInt(MAX_JUMP);
    }

    @Override
    public int run() {
        System.out.println(name + " can run " + personalRunRecord);
        return personalRunRecord;
    }

    @Override
    public int jump() {
        System.out.println(name + " can jump " + personalJumpRecord);
        return personalJumpRecord;
    }
}
