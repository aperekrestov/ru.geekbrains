package lesson1;

public interface Barrier {
    String name = "Barrier";
    int limit = 0;

    int getLimit();
    String getName();
    boolean doIt(Member member);
}
