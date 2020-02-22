package lesson1;

public interface Barrier {
    String name = "Препятствие";
    int limit = 0;

    int getLimit();
    boolean doIt(Member member);
    String getName();
}
