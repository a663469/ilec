package Calc;

public class CalculateUtil {

    // метод сложения двух чисел, приватный
    private static int addTwo(int a, int b) {
        return a + b;
    }

    // метод сложения двух чисел и умножения, публичный
    public static int addAndMultiply(int a, int b, int n) {
        // использует внутри приватный метод
        return addTwo(a, b) * n;
    }
}
