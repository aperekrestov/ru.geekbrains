package lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        Human competitor1 = new Human();
        Wall wall1 = new Wall(50);

        System.out.println(wall1.doClimb(competitor1));
    }
}
