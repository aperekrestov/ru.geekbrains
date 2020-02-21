package lesson1;

public class LetRoad {

    public final int width;

    public LetRoad(int width) {
        this.width = width;
    }

    public boolean doRun(Member member){
        int w = member.run();
        boolean memberDoIt = w >= width;

        System.out.println(memberDoIt);
        return memberDoIt;
    }
}
