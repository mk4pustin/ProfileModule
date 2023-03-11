package ru.sber.kapustin.homework2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElements {

    public static <T> Set<T> getUnique(ArrayList<T> list) {
        return new HashSet<>(list);
    }
}
