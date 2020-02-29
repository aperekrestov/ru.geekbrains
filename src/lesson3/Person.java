package lesson3;

public class Person implements Comparable<Person>{
    protected String name;
    protected String number;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int compareTo(Person anotherPerson) {
        return this.name.compareTo(anotherPerson.name);
    }
}
