package ru.sber.kapustin.homework4;

import java.util.Scanner;

public class AdditionalTask1 {

    public static void main(String[] args) {
        final var console = new Scanner(System.in);

        final var str1 = console.nextLine();
        final var str2 = console.nextLine();

        System.out.println(canBeEqual(str1, str2));
    }

    public static boolean canBeEqual(String str1, String str2) {
        if (str1.equals(str2)) return false;

        final var length1 = str1.length();
        final var length2 = str2.length();

        if (Math.abs(length1 - length2) > 1) return false;

        boolean diffFound = false;
        for (int i = 0, j = 0; i < length1 && j < length2; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (diffFound) {
                    return false;
                }
                diffFound = true;

                switch (Integer.compare(length1, length2)) {
                    case 1 : j--;
                    case -1: i--;
                }
            }
        }

        return true;
    }
}

