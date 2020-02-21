package lesson1;

import java.util.Random;

public class LetJump {

    private final int height;

    public LetJump(int MAX_HEIGHT) {
        Random random = new Random();
        this.height = random.nextInt(MAX_HEIGHT);
    }

    public boolean doJump(Member member) {
        int h = member.jump();
        boolean memberDoIt = h >= height;

        System.out.println(memberDoIt + " ");
        return memberDoIt;
    }

    public int getHeight(){
        return height;
    }
}
