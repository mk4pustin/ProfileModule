package ru.sber.kapustin.homework4;

import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        System.out.println(multiply(List.of(1, 2, 3, 4, 5)));
    }

    private static int multiply(List<Integer> list) {
        return list.stream()
                .reduce(1, (a, b) -> a * b);
    }
}

