package lesson1;

public class LetWall {

    private final int height;

    public LetWall(int height) {
        this.height = height;
    }

    public boolean doClimb(Member member) {
        int h = member.jump();
        boolean memberDoIt = h >= height;

        System.out.println(memberDoIt);
        return memberDoIt;
    }
}
