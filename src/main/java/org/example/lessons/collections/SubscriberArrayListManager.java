package org.example.lessons.collections;

import java.util.ArrayList;

public class SubscriberArrayListManager {
    private final ArrayList<String> subscriberList = new ArrayList<>();

    public void addSubscriber(String subscriberName) {
        subscriberList.add(subscriberName);
        System.out.println("Добавлен новый подписчик: " + subscriberName);
    }

    public void removeSubscriber(int index) {
        if (index >= 0 && index < subscriberList.size()) {
            String removedSubscriber = subscriberList.remove(index);
            System.out.println("\nПодписчик с индексом " + index + " (" + removedSubscriber + ") удален");
        } else {
            System.out.println("\nНекорректный индекс для удаления подписчика");
        }
    }

    public void searchSubscriber(String subscriber) {
        if (subscriberList.contains(subscriber)) {
            System.out.println("\nПодписчик " + subscriber + " найден");
        } else {
            System.out.println("\nПодписчик " + subscriber + " не найден");
        }
    }

    public void printSubscribersList() {
        System.out.println("\nСписок подписчиков:");
        for (String subscriber : subscriberList) {
            System.out.println(subscriber);
        }
    }

    // Метод для получения количества подписчиков
    public int getSubscriberCount() {
        return subscriberList.size();
    }

    // Метод для очистки списка подписчиков
    public void clearSubscribers() {
        subscriberList.clear();
        System.out.println("\nСписок подписчиков очищен");
    }

    public static void main(String[] args) {
        SubscriberArrayListManager manager = new SubscriberArrayListManager();

        manager.addSubscriber("Иван56");
        manager.addSubscriber("Габарик1994");
        manager.addSubscriber("Мартина_Идена2");
        manager.addSubscriber("КалинаКлейна");
        manager.addSubscriber("ВладиУргент2023");

        manager.printSubscribersList();

        manager.searchSubscriber("Иван56");
        manager.searchSubscriber("Иван52");

        manager.removeSubscriber(1);
        manager.printSubscribersList();

        System.out.println("\nОбщее количество подписчиков: " + manager.getSubscriberCount());

        manager.clearSubscribers();
        manager.printSubscribersList();
    }
}
