package ru.sber.kapustin.homework3;

import java.util.Stack;

public class AdditionalTask2 {

    public static void main(String[] args) {
        System.out.println(isCorrectBracketSeq("[}"));
    }

    public static boolean isCorrectBracketSeq(String line) {
        if (line == null || line.trim().length() == 0) return true;

        final var brackets = new Stack<Character>();

        char stackTop;
        for (var ch : line.toCharArray()) {
            if (ch == '(' || ch == '[' || ch ==  '{') brackets.push(ch);
            else {
                if (brackets.isEmpty()) return false;

                stackTop = brackets.pop();
                if (ch == ')' && stackTop != '(' || ch == '}' && stackTop != '{' || ch == ']' && stackTop != '[')
                    return false;
            }
        }

        return brackets.size() == 0;
    }
}
