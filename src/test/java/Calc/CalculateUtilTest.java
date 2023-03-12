package Calc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculateUtilTest {
    // метод, выполняющийся перед началом выполнения всех тестов
    @BeforeAll
    public static void before() {
        System.out.println("Start testing CalculateUtil.java");
    }

    // метод-тест, проверяющий работу метода нашего класса
    @Test
    public void testAddAndMultiply() {
        // вызываем метод нашего класса, получаем результат
        final int result = CalculateUtil.addAndMultiply(2, 3, 10);
        // выполняем проверку: наш метод должен был вернуть ответ = 50,
        // сравниваем реальное с ожидаемым
        Assertions.assertEquals(50, result);
    }

    // метод, выполняющийся после окончания выполнения всех тестов
    @AfterAll
    public static void after() {
        System.out.println("Finish testing CalculateUtil.java");
    }
}
