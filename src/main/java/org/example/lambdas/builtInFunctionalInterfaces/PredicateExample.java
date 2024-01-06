package org.example.lambdas.builtInFunctionalInterfaces;

import java.util.function.Predicate;

/**
 * Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
 * Если оно соблюдается, то возвращается значение true. В качестве параметра лямбда-выражение принимает объект типа T:
 * <p>
 * public interface Predicate<T> {
 *     boolean test(T t);
 * }
 */

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
    }
}
