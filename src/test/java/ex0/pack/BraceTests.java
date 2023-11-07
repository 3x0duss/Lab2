package ex0.pack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BraceTest {

    //Проверка орректности работы с пустой строкой.
    @Test
    public void AreBracesBalanced1Test(){
        Evaluate sol = new Evaluate("");

        assertTrue(CorrectBrace.areBracesCorrect(String.valueOf(sol)));
    }

    //Проверка корректности работы с заполненной строкой.
    @Test
    public void AreBracesBalanced2Test(){

        Evaluate sol1 = new Evaluate("{123}");
        Evaluate sol2 = new Evaluate("([123])");
        Evaluate sol3 = new Evaluate(")([]}{");
        Evaluate sol4 = new Evaluate("[](){})");
        Evaluate sol5 = new Evaluate("[({})(())]");

        assertTrue(CorrectBrace.areBracesCorrect(String.valueOf(sol1)));
        assertTrue(CorrectBrace.areBracesCorrect(String.valueOf(sol2)));
        assertFalse(CorrectBrace.areBracesCorrect(String.valueOf(sol3)));
        assertFalse(CorrectBrace.areBracesCorrect(String.valueOf(sol4)));
        assertTrue(CorrectBrace.areBracesCorrect(String.valueOf(sol5)));
    }

}