package lesson1;

import java.util.ArrayList;

public class Stage1 {

    private static ArrayList<Member> members = new ArrayList<Member>();
    private static Barrier[] barriers;

    public Stage1() {}

    public void createMember(int memberCounter, int maxRun, int maxJump) {

        for (int i = 0; i < memberCounter; i++) {
            if (i % 2 == 0) {
                Human myHuman = new Human("Human " + i, maxRun, maxJump);
                members.add(myHuman);
            } else {
                Robot myRobot = new Robot("Robot " + i, maxRun, maxJump);
                members.add(myRobot);
            }
        }
    }

    public void createBarrier(int barrierCounter, int maxWidth, int maxHeight) {

        barriers = new Barrier[barrierCounter];

        for (int i = 0; i < barriers.length; i++) {
            if (i % 2 == 0) {
                Barrier newRoad = new LetRun("Road " + i, maxWidth);
                barriers[i] = newRoad;
            } else {
                Barrier newWall = new LetJump("Wall " + i, maxHeight);
                barriers[i] = newWall;
            }
        }
    }

    public void checkWin() {

        for (int i = 0; i < barriers.length; i++) {

            System.out.print("\n" + barriers[i].getName() + " start! ");
            System.out.println("Limit is " + barriers[i].getLimit());

            checkLooserStep(i);
        }
    }

    private void checkLooserStep(int barrierIndex) {

        for (int i = 0; i < members.size(); i++) {
            if (!members.get(i).getLose()) {
                if (!barriers[barrierIndex].doIt(members.get(i))) {
                    members.get(i).setLose();
                }
            }
        }
    }

    public void printWin() {
        int countLooser = 0;
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getLose()) {
                countLooser ++;
            }
        }

        if (countLooser == members.size()) {
            System.out.println("\nNo winners");

        } else {
            System.out.println("\nWinners:");

            for (int j = 0; j < members.size(); j++) {
                if (!members.get(j).getLose()) {
                    System.out.println(members.get(j).getName());
                }
            }
        }

    }
}
