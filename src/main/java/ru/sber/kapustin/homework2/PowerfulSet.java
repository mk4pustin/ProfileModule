package ru.sber.kapustin.homework2;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet<T> {

    public Set<T> intersection(Set<T> set1, Set<T> set2) {
        final var intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return intersection;
    }

    public Set<T> union(Set<T> set1, Set<T> set2) {
        final var union = new HashSet<>(set1);
        union.addAll(set2);

        return union;
    }

    public Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        final var relativeComplement = new HashSet<>(set1);
        relativeComplement.removeAll(set2);

        return relativeComplement;
    }
}

