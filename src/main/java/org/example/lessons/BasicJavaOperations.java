package org.example.lessons;

public class BasicJavaOperations {

    public static void main(String[] args) {

        // Арифметические операции
        int sum = 5 + 3;
        int difference = 8 - 3;
        int product = 4 * 6;
        double quotient = 10.0 / 3.0;
        int remainder = 10 % 3;

        System.out.println("Сложение: " + sum);
        System.out.println("Вычитание: " + difference);
        System.out.println("Умножение: " + product);
        System.out.println("Деление: " + quotient);
        System.out.println("Остаток от деления: " + remainder);

        // Логические операции
        boolean condition1 = true;
        boolean condition2 = false;
        boolean resultAnd = condition1 && condition2;
        boolean resultOr = condition1 || condition2;
        boolean resultNot = !condition1;

        System.out.println("Логическое И: " + resultAnd);  // Вывод: false
        System.out.println("Логическое ИЛИ: " + resultOr); // Вывод: true
        System.out.println("Логическое НЕ: " + resultNot); // Вывод: false

        // Максимальное значение int и переполнение
        int maxIntValue = Integer.MAX_VALUE;
        int overflowedValue = maxIntValue + 1;

        System.out.println("Максимальное значение int: " + maxIntValue);
        System.out.println("Переполненное значение int: " + overflowedValue);

        // Сложение int + double
        int testedInt = 10;
        double testedDouble = 12.12;
        double result = testedInt + testedDouble;

        System.out.println("Сумма int + double: " + result);

        // Условие (if-else)
        int number = 7;

        if (number % 2 == 0) {
            System.out.println(number + " четное число.");
        } else {
            System.out.println(number + " нечетное число.");
        }

        // Циклы (for, while, do-while)
        System.out.println("Цикл for:");

        for (int i = 0; i < 5; i++) {
            System.out.println("Итерация " + i);
        }

        System.out.println("Цикл while:");

        int count = 0;
        while (count < 3) {
            System.out.println("Счетчик: " + count);
            count++;
        }

        System.out.println("Цикл do-while:");

        int doWhileCount = 0;
        do {
            System.out.println("Счетчик (do-while): " + doWhileCount);
            doWhileCount++;
        } while (doWhileCount < 2);
    }
}


