package lesson1;

import java.util.Random;

public class LetRun implements Barrier{

    private final int limit;
    private String name;

    public LetRun(String name, int MAX_INT) {
        this.name = name;
        Random random = new Random();
        this.limit = random.nextInt(MAX_INT);
    }

    @Override
    public int getLimit(){
        return limit;
    }

    @Override
    public boolean doIt(Member member){
        int w = member.run();
        boolean memberDoIt = w >= limit;

        System.out.println(memberDoIt + " ");
        return memberDoIt;
    }

    @Override
    public String getName() {
        return name;
    }
}
