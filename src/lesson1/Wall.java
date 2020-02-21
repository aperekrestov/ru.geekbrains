package lesson1;

public class Wall {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean doClimb(Competitor member) {
        int memberMaxHeight = member.jump();
        return memberMaxHeight >= height;
    }
}
