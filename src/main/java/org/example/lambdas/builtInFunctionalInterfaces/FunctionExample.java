package org.example.lambdas.builtInFunctionalInterfaces;

import java.util.function.Function;

/**
 * Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:
 * <p>
 * public interface Function<T, R> {
 *     R apply(T t);
 * }
 */

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> convert = x -> x + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов
    }
}
