package ru.sber.kapustin.homework6.additional;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        final var console = new Scanner(System.in);

        System.out.println(isArmstrongNumber(console.nextInt()));
    }

    public static boolean isArmstrongNumber(int number) {
        final var digits = Integer.toString(number).chars().map(c -> c - '0').toArray();

        final var digitsCount = digits.length;
        return IntStream.of(digits).map(digit -> (int) Math.pow(digit, digitsCount)).sum() == number;
    }
}
