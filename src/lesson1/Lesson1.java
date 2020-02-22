package lesson1;

import java.util.ArrayList;

public class Lesson1 {
    private static final int MEMBERS_NUM = 15;
    private static final int BARRIERS_NUM = 1;
    private static final int MAX_BARRIER_HEIGHT = 50;

    public static void main(String[] args) {

        ArrayList<Member> members = new ArrayList<Member>();

        for (int i = 0; i < MEMBERS_NUM; i++) {
            if (i % 2 == 0) {
                Human myHuman = new Human("Human " + i);
                members.add(myHuman);
            } else {
                Robot myRobot = new Robot("Robot " + i);
                members.add(myRobot);
            }
        }

        LetJump[] walls = new LetJump[BARRIERS_NUM];
        for (int i = 0; i < walls.length; i++) {
            LetJump newWall = new LetJump(MAX_BARRIER_HEIGHT);
            walls[i] = newWall;
        }

        for (int i = 0; i < walls.length; i++) {
            System.out.print("\n" + "Wall " + i + " start! ");
            System.out.println("The walls height is " + walls[i].getHeight() + " \n");

            for (int j = 0; j < members.size(); j++) {

                if (walls[i].doJump(members.get(j)) == false) {
                    members.remove(j);
                    System.out.println("!! loose " + j);
                }
                System.out.println();
            }
        }

        System.out.println("\n-Finished " + members.size() + " members");
    }
}
