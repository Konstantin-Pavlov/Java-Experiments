package org.example.lambdas;

import java.util.ArrayList;
import java.util.List;

public class GenericPredicateExample {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 5, 7, 4, 0));
        List<Apple> apples = new ArrayList<>(List.of(
                new Apple("Green", 50),
                new Apple("Red", 120),
                new Apple("Yellow", 150),
                new Apple("Green", 75))
        );

        filterAndPrint(nums, (n) -> n % 2 == 0);
        filterAndPrint(apples, (apple) -> apple.getWeight() < 100);
    }

    private static <T> void filterAndPrint(List<T> list, Predicate<T> predicate) {
        for (T element : list) {
            if (predicate.test(element)) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

}

interface Predicate<T> {
    boolean test(T t);
}

class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
