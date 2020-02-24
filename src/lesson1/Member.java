package lesson1;

public interface Member {
    String name = "Member";
    String getName();

    int jump();
    int run();

    boolean lose = false;
    boolean getLose();
    void setLose();
}
