package ex0;
import ex0.pack.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        if (CorrectBrace.areBracesCorrect(expression)) {
            Evaluate sol = new Evaluate(ExtraVar.Replace(expression));
            double answer = sol.Evaluation();
            System.out.printf(String.valueOf(answer));
        }
        else System.out.print("Скобки некорректны!");
    }
}