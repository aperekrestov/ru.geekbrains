package lesson3;

public class Lesson3 {
    public static void main(String[] args) {
        System.out.println("Массив слов:");

        WordsArray wordsArray = new WordsArray();
        wordsArray.getInfo();
        wordsArray.getDuplicateCount("Иванов");
        wordsArray.getUnique();

        System.out.println("\nСоздаем список контактов...");

        Contacts contacts = new Contacts();
        contacts.setContact("Иванов", "+7 (916) 916-16-16");
        contacts.setContact("Петров", "+7 (917) 917-17-17");
        contacts.setContact("Сидоров", "+7 (903) 903-03-03");
        contacts.setContact("Петров", "+7 (901) 901-01-01");

        contacts.getInfo();
        contacts.getNumber("Петров");

    }
}
