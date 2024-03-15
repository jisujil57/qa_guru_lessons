package org.example.lessons.collections;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

public class UserDequeManager {
    private final Deque<String> userDeque = new ArrayDeque<>();

    public void addUser(String userId, String userName) {
        userDeque.addLast(userId + ":" + userName);
        System.out.println("Добавлен новый пользователь: " + userName);
    }

    public void removeUser(String userId) {
        boolean removed = false;
        for (String user : userDeque) {
            String[] userInfo = user.split(":");
            if (userInfo[0].equals(userId)) {
                userDeque.remove(user);
                System.out.println("\nПользователь с id " + userId + " (" + userInfo[1] + ") удален");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("\nПользователь с id " + userId + " не найден");
        }
    }

    public void searchUser(String userId) {
        boolean found = false;
        Iterator<String> iterator = userDeque.iterator();
        while (iterator.hasNext()) {
            String user = iterator.next();
            String[] userInfo = user.split(":");
            if (userInfo[0].equals(userId)) {
                System.out.println("\nПользователь с id " + userId + " найден: " + userInfo[1]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nПользователь с id " + userId + " не найден");
        }
    }

    public void printUsers() {
        System.out.println("\nСписок пользователей:");

        Iterator<String> iterator = userDeque.iterator();
        do {
            if (!iterator.hasNext()) break;
            String user = iterator.next();
            String[] userInfo = user.split(":");
            System.out.println("ID: " + userInfo[0] + ", Имя: " + userInfo[1]);
        } while (true);
    }

    public void printUserCountAndNames() {
        System.out.println("\nКоличество пользователей: " + userDeque.size());
        System.out.println("Имена пользователей:");

        Object[] usersArray = userDeque.toArray();
        for (int i = 0; i < usersArray.length; i++) {
            String user = (String) usersArray[i];
            String[] userInfo = user.split(":");
            System.out.println(userInfo[1]);
        }
    }




    public static void main(String[] args) {

        UserDequeManager userManager = new UserDequeManager();

        userManager.addUser("001", "Федя");
        userManager.addUser("002", "Юля");
        userManager.addUser("003", "Саша");
        userManager.addUser("004", "Таня");
        userManager.addUser("005", "Кирилл");

        userManager.printUserCountAndNames();

        userManager.printUsers();

        userManager.searchUser("002");

        userManager.removeUser("002");
        userManager.searchUser("002");

        userManager.printUsers();
    }
}

