package ex0.pack;
import java.util.*;
/**
 * Класс CorrectBrace реализует проверку правильности скобок в выражении.
 */
public class CorrectBrace {

    public static boolean areBracesCorrect(String expr) {

        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{') {

                stack.push(x);
                continue;
            }

            if (stack.isEmpty() && (x == ')' || x == ']' || x == '}'))
                return false;
            char brace;
            switch (x) {
                case ')':
                    brace = stack.pop();
                    if (brace == '{' || brace == '[')
                        return false;
                    break;
                case '}':
                    brace = stack.pop();
                    if (brace == '(' || brace == '[')
                        return false;
                    break;
                case ']':
                    brace = stack.pop();
                    if (brace == '(' || brace == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}
