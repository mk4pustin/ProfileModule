package ru.sber.kapustin.homework1;

import java.util.Scanner;

public class AdditionalTask1 {

    public static void main(String[] args) {
        final var console = new Scanner(System.in);

        final var arrSize = console.nextInt();

        final var arr = new int[arrSize];
        for (var i = 0; i < arrSize; i++) {
            arr[i] = console.nextInt();
        }

        var firstMax = Integer.MIN_VALUE;
        var secondMax = Integer.MIN_VALUE;

        for (var i = 0; i < arrSize; i++) {
            switch (Integer.compare(arr[i], firstMax)) {
                case 1 -> {
                    secondMax = firstMax;
                    firstMax = arr[i];
                }
                case -1 -> {
                    if (secondMax < arr[i]) secondMax = arr[i];
                }
            }
        }

        System.out.println("first max: " + firstMax);
        System.out.println("second max: " + secondMax);
    }
}
