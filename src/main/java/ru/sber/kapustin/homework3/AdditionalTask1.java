package ru.sber.kapustin.homework3;

public class AdditionalTask1 {

    public static void main(String[] args) {
        System.out.println(isCorrectBracketSeq("((())())"));
    }

    public static boolean isCorrectBracketSeq(String line) {
        if (line == null || line.trim().length() == 0) return true;

        var openBracketsCount = 0;
        for (var ch : line.toCharArray()) {
            switch (ch) {
                case '(' -> openBracketsCount++;
                case ')' -> openBracketsCount--;
            }

            if (openBracketsCount < 0) return false;
        }

        return openBracketsCount == 0;
    }
}
