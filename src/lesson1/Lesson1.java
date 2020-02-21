package lesson1;

public class Lesson1 {
    private static final int MEMBERS_NUM = 15;
    private static final int BARRIERS_NUM = 1;
    private static final int MAX_HEIGHT = 150;

    public static void main(String[] args) {

        Member[] members = new Member[MEMBERS_NUM];
        for (int i = 0; i < members.length; i++) {
            if (i % 2 == 0) {
                Human myHuman = new Human("human " + i);
                members[i] = myHuman;
            } else {
                Robot myRobot = new Robot("robot " + i);
                members[i] = myRobot;
            }
        }

        LetJump[] walls = new LetJump[BARRIERS_NUM];
        for (int i = 0; i < walls.length; i++) {
            LetJump newWall = new LetJump(MAX_HEIGHT);
            walls[i] = newWall;
        }

        // TODO: 22.02.2020 Review this block
        for (int i = 0; i < walls.length ; i++) {
            System.out.print("\n" + "Wall " + i + " start! ");
            System.out.println("The walls height is " + walls[i].getHeight() + " !!!!!!!!!!!!!");

            for (int j = 0; j < members.length; j++) {
                // TODO: 22.02.2020 check winners 
                walls[i].doJump(members[j]);
            }

        }
    }
}
