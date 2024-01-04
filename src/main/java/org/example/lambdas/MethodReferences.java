package org.example.lambdas;

public class MethodReferences {
    public static void main(String[] args) {
        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sum(nums, ExpressionHelper::isEven));

        Expression expr = ExpressionHelper::isPositive; // 24
        System.out.println(sum(nums, expr)); // 55

        // If we need to call non-static methods, then the name of the object of this class is used in the link instead of the class name
        System.out.println(sum(nums, new ExpressionHelper()::isNegative)); // -15
    }

    // referenced methods must match the parameters and result of the functional interface method
    private static int sum(int[] numbers, Expression func) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}

// класс, в котором определены методы
class ExpressionHelper {

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
     boolean isNegative(int n) {
        return n < 0;
    }

}
