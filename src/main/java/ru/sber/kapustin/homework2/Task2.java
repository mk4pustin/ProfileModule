package ru.sber.kapustin.homework2;

import java.util.HashMap;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        final var console = new Scanner(System.in);

        final var str1 = console.nextLine();
        final var str2 = console.nextLine();

        System.out.println(checkAnagram(str1, str2));
    }

    private static boolean checkAnagram(String str1, String str2) {
        if (str2 == null || str1 == null || str1.length() != str2.length()) return false;

        final var lettersCount = new HashMap<Character, Integer>();
        str1.chars().forEach(ch -> lettersCount.put((char) ch, lettersCount.getOrDefault((char) ch, 0) + 1));

        char ch;
        for (int i = 0; i < str2.length(); i++) {
            ch = str2.charAt(i);
            if (!lettersCount.containsKey(ch) || lettersCount.get(ch) == 0) {
                return false;
            }

            lettersCount.put(ch, lettersCount.get(ch) - 1);
        }

        return true;
    }
}
