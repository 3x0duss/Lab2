package ex0.pack;
import java.util.Stack;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 * Класс PostfixCreator реализует вычисление значения выражения в постфиксной форме
 */
public class Postfix{

    /**
     * Метод, который находит значение постфиксного выражения
     *
     * @param postfix постфиксное выражение, предварительно сделать так:
     * @return вычисленное значение
     */
    public static double Calculation(String postfix) {

        if (postfix == null) {
            NullPointerException e;
            System.out.println("Неправильный ввод выражения!");
            return 0;
        }
        Stack<Double> stack = new Stack<>();
        Scanner scanner = new Scanner(postfix);

        if (!postfix.isEmpty()) {
            while (scanner.hasNext()) {

                if (scanner.hasNextDouble()) {
                    stack.push(scanner.nextDouble());
                } else {

                    if (stack.peek() == null) {
                        NullPointerException e;
                        System.out.println("Выражение записано некорректно!");
                        postfix = null;
                        return 0;
                    }

                    double y = stack.pop();
                    if (!stack.isEmpty()) {

                        double x = stack.pop();
                        char data = scanner.next().charAt(0);

                        switch (data) {
                            case '.':
                                BigDecimal num = new BigDecimal(y);
                                int point = (int) Math.log10(num.longValue()) + 1;
                                BigDecimal shift = num.movePointLeft(point);
                                double z = shift.doubleValue();
                                stack.push(x + z);
                                break;
                            case '^':
                                stack.push(Math.pow(x, y));
                                break;
                            case '+':
                                stack.push(x + y);
                                break;
                            case '-':
                                stack.push(x - y);
                                break;
                            case '*':
                                stack.push(x * y);
                                break;
                            case '/':
                                if ((y != 0)) {
                                    stack.push(x / y);
                                } else {
                                    System.out.println("Деление на ноль!");
                                    return 0;
                                }
                                break;
                            case '=':
                                stack.push(x);
                                stack.push(y * (-1));
                        }
                    } else {
                        char data = scanner.next().charAt(0);
                        if (data == '=') {
                            stack.push(y * (-1));
                        }
                    }
                }
            }
            scanner.close();

            if (!stack.isEmpty()) {
                double answer = stack.pop();
                return Math.floor(answer * 10000) / 10000;

            } else {

                NullPointerException e;
                System.out.println("Ошибка ввода выражения!");
            }
        }
        return 0;
    }
}