package lesson3;

import java.util.*;

public class WordsArray {
    private String[] aWords = new String[]{
            "Иванов", "Петров", "Иванов", "Сидоров",
            "Чудов", "Петров", "Агапов", "Смирнов",
            "Фурсов", "Петров", "Иванов", "Сидоров",
    };

    public WordsArray() {}

    public void getInfo() {
        for (String a : aWords) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void getUnique() {
        Set mySet = new TreeSet(Arrays.asList(aWords));
        System.out.println("Всего копий в массиве " + (aWords.length - mySet.size()));

        for (Object s : mySet) {
            System.out.print(s + " ");
        }

        System.out.println("- уникальные имена");
    }

    public void getDuplicateCount(String text) {
        int counter = 0;

        for (int i = 0; i < aWords.length; i++) {
            if (text.equals(aWords[i])) {
                counter ++;
            }
        }

        System.out.println("В массиве " + counter + " копий по поиску: " + text);
    }
}
