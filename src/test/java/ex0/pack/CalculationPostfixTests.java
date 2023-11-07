package ex0.pack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostfixTests {

    //Проверка с пустой строкой.
    @Test
    public void PostfixFormInEmptyTest(){

        assertEquals(0,Postfix.Calculation(null));
    }

    //Проверка корректности решения выражений.
    @Test
    public void testPostfixFormInCorrectTest(){
        String str1 = "5";
        String str2 = "8+2-1";
        String str3 = "6*(3.3/3)";
        String str4 = "2.5^2";
        String str5 = "=3-1";


        assertEquals(5.0,Postfix.Calculation(Divide.PostfixForm(str1)));
        assertEquals(9,Postfix.Calculation(Divide.PostfixForm(str2)));
        assertEquals(6.6,Postfix.Calculation(Divide.PostfixForm(str3)));
        assertEquals(6.25,Postfix.Calculation(Divide.PostfixForm(str4)));
        assertEquals(-4,Postfix.Calculation(Divide.PostfixForm(str5)));
    }

    //Проверка с неправильными выражениями.
    @Test
    public void PostfixFormInNotCorrectTest(){
        String str1 = " ";
        String str2 = "2- - =1";
        String str3 = "100/0";
        String str4 = "1 + - *";
        String str5 = "xy";


        assertThrows(NullPointerException.class, () -> Postfix.Calculation(Divide.PostfixForm(str1)));
        assertThrows(NullPointerException.class, () -> Postfix.Calculation(Divide.PostfixForm(str2)));
        assertThrows(NullPointerException.class, () -> Postfix.Calculation(Divide.PostfixForm(str3)));
        assertThrows(EmptyStackException.class, () -> Postfix.Calculation(Divide.PostfixForm(str4)));
        assertThrows(NullPointerException.class, () -> Postfix.Calculation(Divide.PostfixForm(str5)));


    }

}