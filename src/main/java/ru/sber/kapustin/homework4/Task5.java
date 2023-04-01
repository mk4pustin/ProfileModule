package ru.sber.kapustin.homework4;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {

    public static void main(String[] args) {
        printUpperCase(List.of("abc", "def", "qqq"));
    }

    private static void printUpperCase(List<String> strings) {
        final var result = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
