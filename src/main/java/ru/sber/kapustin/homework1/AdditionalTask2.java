package ru.sber.kapustin.homework1;

import java.util.Scanner;

public class AdditionalTask2 {

    public static void main(String[] args) {
        final var console = new Scanner(System.in);

        final var arrSize = console.nextInt();

        final var arr = new int[arrSize];
        for (var i = 0; i < arrSize; i++) {
            arr[i] = console.nextInt();
        }

        final var elem = console.nextInt();
        System.out.println(binarySearch(arr, elem));
    }

    public static int binarySearch(int[] arr, int elem) {
        var startIndex = 0;
        var endIndex = arr.length - 1;

        int midIndex;
        int midValue;
        do {
            midIndex = (startIndex + endIndex) / 2;
            midValue = arr[midIndex];

            switch (Integer.compare(elem, midValue)) {
                case 0 -> {
                    return midIndex;

                }
                case -1 -> endIndex = midIndex - 1;
                case 1 -> startIndex = midIndex + 1;
            }
        } while (startIndex <= endIndex);

        return -1;
    }
}
