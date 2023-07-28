package ru.sber.kapustin.homework6.additional;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        final var console = new Scanner(System.in);

        final var number = console.nextInt();
        System.out.println(isPrime(number));
    }

    public static boolean isPrime(int number) {
        for (var i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

