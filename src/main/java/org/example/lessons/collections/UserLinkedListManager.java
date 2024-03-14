package org.example.lessons.collections;

import java.util.LinkedList;

public class UserLinkedListManager {
    private final LinkedList<String> userList = new LinkedList<>();

    public void addUser(String userName) {
        userList.add(userName);
        System.out.println("Добавлен новый пользователь: " + userName);
    }

    public void removeUser(String userName) {
        if (userList.contains(userName)) {
            userList.remove(userName);
            System.out.println("\nПользователь " + userName + " удален");
        } else {
            System.out.println("\nПользователь " + userName + " не найден");
        }
    }

    public void searchUser(String userName) {
        if (userList.contains(userName)) {
            System.out.println("\nПользователь " + userName + " найден");
        } else {
            System.out.println("\nПользователь " + userName + " не найден");
        }
    }

    public void printUsers() {
        System.out.println("\nСписок пользователей:");
        for (String userName : userList) {
            System.out.println(userName);
        }
    }

    public static void main(String[] args) {
        UserLinkedListManager manager = new UserLinkedListManager();

        manager.addUser("Иван");
        manager.addUser("Мария");
        manager.addUser("Петр");

        manager.printUsers();

        manager.searchUser("Мария");

        manager.removeUser("Петр");

        manager.printUsers();
    }
}
