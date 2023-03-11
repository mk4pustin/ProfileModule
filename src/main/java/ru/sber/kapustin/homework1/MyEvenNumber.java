package ru.sber.kapustin.homework1;

public class MyEvenNumber {
    private final int n;

    public MyEvenNumber(int n) {
        if (n % 2 != 0) throw new IllegalArgumentException("MyEvenNumber must be even!");

        this.n = n;
    }

    public int getValue() {
        return n;
    }
}
