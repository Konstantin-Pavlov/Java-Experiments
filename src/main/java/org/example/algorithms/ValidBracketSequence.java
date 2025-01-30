package org.example.algorithms;

import java.util.Stack;

public class ValidBracketSequence {
    public static void main(String[] args) {
        String[] testInputs = {"(())()()", "((()", ")( "};

        for (String input : testInputs) {
            if (isValid(input)) {
                System.out.println("Строка" + input + " валидна.");
            } else {
                System.out.println("Строка" + input + " не валидна.");
            }
        }
    }
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
