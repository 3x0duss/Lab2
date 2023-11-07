package ex0.pack;
/**
 * Класс Evaluate реализует вычисление выражения
 *
 */
public class Evaluate {
    private final String instance;

    /**
     * Конструктор по умолчанию
     * */
    public Evaluate() {
        instance = "";
    }

    /**
     * Конструктор, который принимает выражение
     *
     * @param str  выражение
     * */
    public Evaluate(String str) {
        instance = "(" + str + ")";
    }

    /**
     * Метод вычисления значения выражения
     *
     * @return answer - полученное значение после разборки и вычисления выражения
     */
    public double Evaluation(){
        String example = ExtraVar.Replace(instance);
        example = Divide.PostfixForm(instance);
        return Postfix.Calculation(example);
    }

    public boolean isEmpty() {
        return (instance == null || instance.equals("()"));
    }

    @Override
    public String toString() {
        String str = "";
        str = instance;
        return str;
    }

}
