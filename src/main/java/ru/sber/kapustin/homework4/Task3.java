package ru.sber.kapustin.homework4;

import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        System.out.println(getNonEmptyStringsCount(List.of("abc", "", "", "def", "qqq")));
    }

    private static long getNonEmptyStringsCount(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .count();
    }
}

