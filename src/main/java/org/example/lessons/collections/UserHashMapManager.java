package org.example.lessons.collections;

import java.util.HashMap;

public class UserHashMapManager {
    private final HashMap<String, String> userMap = new HashMap<>();

    public void addUser(String userId, String userName) {
        userMap.put(userId, userName);
        System.out.println("Добавлен новый пользователь: " + userName);
    }

    public void removeUser(String userId) {
        if (userMap.containsKey(userId)) {
            String removedUserName = userMap.remove(userId);
            System.out.println("\nПользователь с id " + userId + " (" + removedUserName + ") удален");
        } else {
            System.out.println("\nПользователь с id " + userId + " не найден");
        }
    }

    public void searchUser(String userId) {
        if (userMap.containsKey(userId)) {
            System.out.println("\nПользователь с id " + userId + " найден");
        } else {
            System.out.println("\nПользователь с id " + userId + " не найден");
        }
    }

    public void printUsers() {
        System.out.println("\nСписок пользователей:");
        for (String userId : userMap.keySet()) {
            System.out.println("ID: " + userId + ", Имя: " + userMap.get(userId));
        }
    }

    public static void main(String[] args) {
        UserHashMapManager userManager = new UserHashMapManager();

        // Добавление пользователей
        userManager.addUser("001", "Федя");
        userManager.addUser("002", "Юля");
        userManager.addUser("003", "Саша");

        // Вывод списка пользователей
        userManager.printUsers();

        // Поиск пользователя
        userManager.searchUser("002");

        // Удаление пользователя
        userManager.removeUser("002");
        userManager.removeUser("007");

        // Вывод списка пользователей после удаления
        userManager.printUsers();
    }

}
