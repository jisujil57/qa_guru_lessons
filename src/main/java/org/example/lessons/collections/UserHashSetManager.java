package org.example.lessons.collections;

import java.util.HashSet;

public class UserHashSetManager {
    private final HashSet<String> userSet = new HashSet<>();

    public void addUser(String userName) {
        userSet.add(userName);
        System.out.println("Добавлен новый пользователь: " + userName);
    }

    public void removeUser(String userName) {
        if (userSet.contains(userName)) {
            userSet.remove(userName);
            System.out.println("\nПользователь " + userName + " удален");
        } else {
            System.out.println("\nПользователь " + userName + " не найден");
        }
    }

    public void searchUser(String userName) {
        if (userSet.contains(userName)) {
            System.out.println("\nПользователь " + userName + " найден");
        } else {
            System.out.println("\nПользователь " + userName + " не найден");
        }
    }

    public void printUsers() {
        System.out.println("\nСписок пользователей:");
        for (String userName : userSet) {
            System.out.println(userName);
        }
    }

    public static void main(String[] args) {
        UserHashSetManager manager = new UserHashSetManager();

        manager.addUser("Иван");
        manager.addUser("Мария");
        manager.addUser("Петр");

        manager.printUsers();

        manager.searchUser("Мария");

        manager.removeUser("Петр");

        manager.printUsers();
    }
}
