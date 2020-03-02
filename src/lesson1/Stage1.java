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

            int winCounter = 0;

            System.out.print("\n" + barriers[i].getName() + " start! ");
            System.out.println("Limit is " + barriers[i].getLimit());

            for (int j = 0; j < members.size(); j++) {
                if (!members.get(j).getLose() && !barriers[i].doIt(members.get(j))) {
                    members.get(j).setLose();
                } else {
                    winCounter ++;
                }
            }

            // TODO: 23.02.2020 Аочему-то не работает на втором цикле 
            if (winCounter == 0) {
                System.out.println("\nAfter " + barriers[i].getName() + " we have no winners");
                return;
            }
        }

        System.out.println("\nWinners:");
        for (int j = 0; j < members.size(); j++) {
            if (!members.get(j).getLose()) {
                System.out.println(members.get(j).getName());
            }
        }
    }
}
