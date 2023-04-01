package ru.sber.kapustin.homework4;

import java.util.stream.IntStream;

public class Task1 {

    public static void main(String[] args) {
        final var maxElem = 100;

        final var sum = IntStream.range(0, maxElem + 1)
                .filter(elem -> elem % 2 == 0)
                .sum();

        System.out.println(sum);
    }
}
