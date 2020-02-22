package lesson1;

import java.util.ArrayList;

public class Lesson1 {
    private static final int MEMBERS_NUM = 3;
    private static final int BARRIERS_NUM = 2;
    private static final int MAX_BARRIER_HEIGHT = 50;
    private static final int MAX_BARRIER_WIDTH = 50000;
    private static ArrayList membersWhoFinished = new ArrayList();

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

        Barrier[] barriers = new Barrier[BARRIERS_NUM];

        for (int i = 0; i < barriers.length; i++) {
            if (i % 2 == 0) {
                Barrier newWall = new LetJump("Wall " + i, MAX_BARRIER_HEIGHT);
                barriers[i] = newWall;
            } else {
                Barrier newRoad = new LetRun("Road " + i, MAX_BARRIER_WIDTH);
                barriers[i] = newRoad;
            }
        }

        for (int i = 0; i < barriers.length; i++) {

            System.out.print("\n" + barriers[i].getName() + " start! ");
            System.out.println("Limit is " + barriers[i].getLimit() + " \n");

            for (int j = 0; j < members.size(); j++) {

                // TODO: 22.02.2020 fix log after remove member
                if (!barriers[i].doIt(members.get(j))) {
                    System.out.println("members.remove(" + j + ")");
                    members.remove(j);
                } else {
                    membersWhoFinished.add(members.get(j));
                }
                System.out.println();
            }
        }

        System.out.println("\n-Finished " + members.size() + " members");
        System.out.println(membersWhoFinished.size());
    }
}
