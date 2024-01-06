package org.example.lambdas.builtInFunctionalInterfaces;

import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:
 * <p>
 * public interface Supplier<T> {
 *     T get();
 * }
 */

public class SupplierExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Supplier<User> userFactory = () -> {
            System.out.print("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
        in.close();
    }
}

class User {

    private final String name;

    String getName() {
        return name;
    }

    User(String n) {
        this.name = n;
    }
}
