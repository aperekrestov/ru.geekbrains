package lesson3;

import java.util.*;

public class Contacts {
    public List<Person> contacts = new ArrayList<Person>();

    public Contacts() {}

    public void setContact(String name, String number) {
        Person newOne = new Person(name, number);
        contacts.add(newOne);
    }

    public void getSize() {
        System.out.println("Всего " + contacts.size() + " контактов");
    }

    public void getInfo() {
        for (Person person : contacts) {
            System.out.println(person.name + " " + person.number);
        }
    }

    public void getNumber(String name) {
        System.out.println("\nПоиск по имени " + name + ":");
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).name)) {
                System.out.println(contacts.get(i).number);
            }
        }
    }

}
