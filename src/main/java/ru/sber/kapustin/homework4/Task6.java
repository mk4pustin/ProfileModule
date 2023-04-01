package ru.sber.kapustin.homework4;

import java.util.Set;
import java.util.stream.Collectors;

public class Task6 {

    private static Set<Integer> toSet(Set<Set<Integer>> sets) {
        return sets.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}
