package org.example.lambdas.builtInFunctionalInterfaces;

import java.util.function.UnaryOperator;

/**
 * UnaryOperator<T> принимает в качестве параметра объект типа T, выполняет над ними операции и возвращает результат операций в виде объекта типа T:
 * <p>
 * public interface UnaryOperator<T> {
 *     T apply(T t);
 * }
 */

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25
    }
}
