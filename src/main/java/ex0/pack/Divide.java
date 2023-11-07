package ex0.pack;
import java.util.Stack;
import java.util.Map;
/**
 * Класс Divide реализует перевод выражения в постфиксную форму.
 */
public class Divide {
    private static final String OPERATORS = "^=*/+-.";
    private static final Map<Character, Integer> PRECEDENCE = Map.of(
            '.',4,
            '^',3,
            '=',3,
            '*', 2,
            '/', 2,
            '+', 1,
            '-', 1
    );

    /**
     * Метод перевода в постфиксную форму
     *
     * @param infix инфиксное выражение
     *
     * @return постфиксное выражение
     */
    public static String PostfixForm(String infix) {

        if (infix == null ) {
            NullPointerException e;
            System.out.println("Введено пустое выражение");
            return null;
        }

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char token : infix.toCharArray()) {

            if (Character.isDigit(token)) {
                postfix.append(token);

            } else if ( OPERATORS.contains(String.valueOf(token)) ) {

                while (!stack.isEmpty() && stack.peek() != '('
                        && PRECEDENCE.get(token) <= PRECEDENCE.get(stack.peek()))
                {  postfix.append(' ').append(stack.pop());  }

                postfix.append(' ');
                stack.push(token);

            } else if (token == '(') {
                stack.push(token);

            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                {  postfix.append(' ').append(stack.pop());  }

                stack.pop();
            }
        }
        while (!stack.isEmpty()) {  postfix.append(' ').append(stack.pop());  }

        if (!postfix.isEmpty()) return postfix.toString();
        return null;
    }
}