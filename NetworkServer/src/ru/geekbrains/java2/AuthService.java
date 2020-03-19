package ru.geekbrains.java2;

public interface AuthService {

    String getUsernameByLoginAndPassword(String login, String password);

    void start();
    void stop();

    void createUserList();
}