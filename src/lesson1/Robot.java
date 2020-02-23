package lesson1;

import java.util.Random;

public class Robot implements Member {

    private String name;
    private int personalRunRecord;
    private int personalJumpRecord;
    private boolean lose = false;

    public Robot(String name, int MAX_RUN, int MAX_JUMP) {
        this.name = name + " Noob Saibot";

        Random random = new Random();
        personalRunRecord = random.nextInt(MAX_RUN);
        personalJumpRecord = random.nextInt(MAX_JUMP);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean getLose() {
        return lose;
    }

    @Override
    public void setLose() {
        lose = true;
    }

    @Override
    public int run() {
        System.out.print(name + " can run " + personalRunRecord);
        return personalRunRecord;
    }

    @Override
    public int jump() {
        System.out.print(name + " can jump " + personalJumpRecord);
        return personalJumpRecord;
    }
}
