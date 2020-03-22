package ru.geekbrains.java2.server.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseAuthService implements AuthService {

    private static final List<UserData> USER_DATA = new ArrayList<>();

    private static class UserData {
        private String login;
        private String password;
        private String username;

        public UserData(String login, String password, String username) {
            this.login = login;
            this.password = password;
            this.username = username;
        }
    }

    public void createUserList() {
        UserData user1 = new UserData("login1", "pass1", "username1");
        UserData user2 = new UserData("login2", "pass2", "username2");
        UserData user3 = new UserData("login3", "pass3", "username3");
        USER_DATA.add(user1);
        USER_DATA.add(user2);
        USER_DATA.add(user3);

    }

    /*private static final List<UserData> USER_DATA = List.of(
            new UserData("login1", "pass1", "username1"),
            new UserData("login2", "pass2", "username2"),
            new UserData("login3", "pass3", "username3")
    );*/

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        for (UserData userDatum : USER_DATA) {
            if (userDatum.login.equals(login) && userDatum.password.equals(password)) {
                return userDatum.username;
            }
        }
        return null;
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации оставлен");
    }
}
