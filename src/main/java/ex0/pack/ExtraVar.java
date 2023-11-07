package ex0.pack;
import java.util.Scanner;
/**
 * Класс ExtraVar реализует замену переменных и функций на числовые значения
 * В методе реализованы функции :
 * sin, cos, tan, exp, sqrt, log.
 */
public class ExtraVar {

    /**
     * Метод замены переменных и функций в выражении.
     * Функции задаются только с переменной, переменные незаглавные, отличные от символов функции, пример:
     *
     * @param expression выражение, которое может содержать переменные и(или) функции
     *
     * @return выражение из цифр и арифметических операций
     */
    public static String Replace (String expression){
        if (!expression.matches(".*[a-zA-Z].*")) {
            return expression;

        } else if(expression.contains("error")) {
            return "0";
        } else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выражение содержит символы!");

            char var = 'a';
            do {
                if (expression.contains(String.valueOf(var))
                        && !expression.matches(".*"+var+"[a-zA-Z].*")
                        && !expression.matches(".*"+ var + "\\(.*" ))
                {
                    System.out.println("Замените символ \"" + var + "\" на число:");
                    String old_var = String.valueOf(var);
                    String new_var = scanner.nextLine();

                    boolean valid = false;
                    while (!valid){
                        try {
                            Double.parseDouble(new_var);
                            valid = true;
                        } catch (NumberFormatException e){
                            System.out.println("Введено не число. Введите снова:");
                            new_var = scanner.nextLine();
                        }
                    }

                    expression = expression.replaceAll(old_var, new_var);
                    expression = function(expression, new_var);
                }
                var = (char) (var + 1);
                if (var >= 'z' + 1) {
                    System.out.println("Ошибка при вводе выражения!");
                    return "error";
                }
            } while (expression.matches(".*[a-zA-Z].*"));
            return expression;
        }
    }

    /**
     * Метод преобразования функций в значение
     *
     * @param exp выражение
     * @param receive число, стоящее внутри функции
     *
     * @return выражение с вычисленной функцией
     */
    private static String function(String exp, String receive){

        double var = Double.parseDouble(receive);

        if (exp.contains("sin")) {
            double ans = Math.sin(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("sin\\(" + receive + "\\)",param );
        }
        if (exp.contains("cos")) {
            double ans = Math.cos(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("cos\\(" + receive + "\\)",param );

        }
        if (exp.contains("tan")) {
            double ans = Math.tan(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("tan\\(" + receive + "\\)",param );

        }
        if (exp.contains("exp")) {
            exp = exp.replaceAll("exp\\(" + receive + "\\)", String.valueOf(Math.exp(var)));

        }
        if (exp.contains("sqrt")) {
            double ans = Math.sqrt(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("sqrt\\(" + receive + "\\)",param );

        }
        if (exp.contains("log(" + receive + ")")) {
            if (var <= 0) return "error";
            double ans = Math.log(var);
            String param;

            if (ans < 0) {
                param = "=" + (ans*(-1));
            }  else {param = "" + ans; }

            exp = exp.replaceAll("log\\(" + receive + "\\)",param );
        }

        return exp;
    }

}
