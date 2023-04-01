package ru.sber.kapustin.homework4;

import java.util.List;

public class Task4 {
    private static List<Double> sort(List<Double> doubles) {
        return doubles.stream()
                .sorted((a, b) -> Double.compare(b, a))
                .toList();
    }
}
