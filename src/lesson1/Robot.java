package lesson1;

import java.util.Random;

public class Robot implements Member {

    public final int MAX_RUN = 10000;
    public final int MAX_JUMP = 1000;

    private int personalRunRecord;
    private int personalJumpRecord;

    public String name;

    public Robot(String name) {
        this.name = name + " Noob Saibot";

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
