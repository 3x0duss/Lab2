package ex0.pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixFormTests {

    //Проверка корректности работаты с пустой строкой.
    @Test
    public void PostFixFormInEmptyStringTest(){

        assertNull(Divide.PostfixForm(null));
    }

    //Проверка корректности составляения постфиксной формы выражений.
    @Test
    public void PostFixFormInNotEmptyStringTest(){
        String str1 = " ";
        String str2 = "5+7";
        String str3 = "2/(6-3)";
        String str4 = "x+y+7";
        String str5 = "abc";

        assertNull(Divide.PostfixForm(str1));
        assertEquals("5 7 +",Divide.PostfixForm(str2));
        assertEquals("2 6 3 - /",Divide.PostfixForm(str3));
        assertEquals("  + 7 +",Divide.PostfixForm(str4));
        assertNull(Divide.PostfixForm(str5));
    }

}