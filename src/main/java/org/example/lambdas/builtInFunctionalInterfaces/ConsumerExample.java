package org.example.lambdas.builtInFunctionalInterfaces;

import java.util.function.Consumer;

/**
 * Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая:
 * <p>
 * public interface Consumer<T> {
 *     void accept(T t);
 */

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> printer = x -> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов
    }
}
