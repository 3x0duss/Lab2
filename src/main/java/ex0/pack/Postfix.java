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

            System.out.println("Неправильный ввод выражения!");
            throw new NullPointerException();
        }
        Stack<Double> stack = new Stack<>();
        Scanner scanner = new Scanner(postfix);

        if (!postfix.isEmpty()) {
            while (scanner.hasNext()) {

                if (scanner.hasNextDouble()) {
                    stack.push(scanner.nextDouble());
                } else {

                    if (stack.peek() == null) {
                        System.out.println("Выражение записано некорректно!");
                        postfix = null;
                        throw new NullPointerException();
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
                                    throw new NullPointerException();
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

                System.out.println("Ошибка ввода выражения!");
                throw new NullPointerException();
            }
        }
        return 0.0;
    }
}