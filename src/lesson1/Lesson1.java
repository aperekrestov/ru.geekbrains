package lesson1;

public class Lesson1 {
    public static void main(String[] args) {

        // TODO: 21.02.2020 create array for test members 
        Human member1 = new Human("Ali");
        Robot member2 = new Robot("R2D2");

        LetWall wall1 = new LetWall(150);
        LetRoad road1 = new LetRoad(5000);

        wall1.doClimb(member1);
        wall1.doClimb(member2);
        
        road1.doRun(member1);
        road1.doRun(member2);
    }
}
