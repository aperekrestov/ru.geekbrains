package ru.geekbrains.java2;

@FunctionalInterface
public interface AuthEvent {
    void authIsSuccessful(String nickname);
}