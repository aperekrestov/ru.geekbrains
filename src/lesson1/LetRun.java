package lesson1;

public class LetRun {

    public final int width;

    public LetRun(int width) {
        this.width = width;
    }

    public boolean doRun(Member member){
        int w = member.run();
        boolean memberDoIt = w >= width;

        System.out.println(memberDoIt);
        return memberDoIt;
    }
}
