package ex0.pack;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ExtraVarTests {

    //Проверка корректности работы с выражениями без параметров.
    @Test
    void ReplaceWithoutParamsTest() {
        String str1 = " ";
        String str2 = "(3-7)*(5+4)";
        String str3 = "42";
        String str4 = "8+1-3" ;
        String str5 = "7 + - *";

        assertEquals(str1, ExtraVar.Replace(str1));
        assertEquals(str2, ExtraVar.Replace(str2));
        assertEquals(str3, ExtraVar.Replace(str3));
        assertEquals(str4, ExtraVar.Replace(str4));
        assertEquals(str5, ExtraVar.Replace(str5));
    }

    //Проверка корректности работы с неправильными выражениями.
    @Test
    void ReplaceInIncorrectTest() {
        String str1 = "xy(";
        String str2 = "sin(4)";
        String str3_1 = "cos(x)";
        String str3_2 = "cos(y)";
        String str3_3 = "cos(z)";
        String str4 = "error";

        assertEquals("error", ExtraVar.Replace(str1));
        assertEquals("error", ExtraVar.Replace(str2));
        assertEquals("error", ExtraVar.Replace(str3_1));
        assertEquals("error", ExtraVar.Replace(str3_2));
        assertEquals("error", ExtraVar.Replace(str3_3));
        assertEquals("0", ExtraVar.Replace(str4));
    }

    //Проверка корректности работы с выражениями, содержащими параметры.
    @Test
    public void testReplaceWithParamsTest() {
        String expression = "a+b";
        InputStream stdin = System.in;

        try {
            //  Входные данные для программы
            String input = "1\n2\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Вызов метода
            String result = ExtraVar.Replace(expression);

            // Проверка результат
            assertEquals("1+2", result);
        } finally {
            // Восстановите исходный входной поток
            System.setIn(stdin);
        }
    }

    //Проверка корректности работы с выражениями, содержащими функции с параметрами.
    @Test
    public void ReplaceAndFunctionWithFunctionsTest() {
        String expression = "sin(d)+cos(d)+sqrt(m)";
        InputStream stdin = System.in;

        try {
            //  Входные данные для программы
            String input = "0\n9\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Вызов метода
            String result = ExtraVar.Replace(expression);

            // Проверка результат
            assertEquals("0.0+1.0+3.0", result);
        } finally {
            // Восстановите исходный входной поток
            System.setIn(stdin);
        }
    }

    //Проверка корректности реакции на неправильные выражения с параметром.
    @Test
    public void ReplaceInIncorrectWithParamsTest() {
        String expression1 = "log(x)";
        String expression2 = "sin(1+x)";
        InputStream stdin = System.in;

        try {
            String input = "-1\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String result1 = ExtraVar.Replace(expression1);

            input = "1\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String result2 = ExtraVar.Replace(expression2);


            assertEquals("error", result1);
            assertEquals("error", result2);
        } finally {
            // Восстановите исходный входной поток
            System.setIn(stdin);
        }

    }

}