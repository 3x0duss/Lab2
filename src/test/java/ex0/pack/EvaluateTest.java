package ex0.pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateTests {

//Проверка корректности работы с пустой строкой.
@Test
public void EvaluationInEmptyStringTest(){

        Evaluate sol = new Evaluate(" ");
        assertThrows(NullPointerException.class, () -> Postfix.Calculation(Divide.PostfixForm(String.valueOf(sol))));
        }

//Проверка корректности работы с непустой строкой.
@Test
public void EvaluationInNotEmptyStringTest(){

    Evaluate sol = new Evaluate("4^2*2+6+2.5");

        assertEquals(40.5,sol.Evaluation());
        }

        }