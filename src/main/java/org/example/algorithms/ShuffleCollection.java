package org.example.algorithms;

import org.jetbrains.annotations.NotNull;
import util.ConsoleColors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ShuffleCollection {


    public static void main(String[] args) {
        List<Integer> list = List.of(5, 6, 7, 10, 15, 0, -5, 8);
        System.out.println(list);
        List<Integer> shuffled = shuffle(list);
        System.out.println(shuffled);

        System.out.println();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> shuffle(List<Integer> list) {
        Random random = new Random();
        List<Integer> shuffled = new ArrayList<>(list.size());
        int counter = 0;
        int placeHolderSize = list.size() + list.size() - 1 + list.size() - 1 + 2;
        System.out.println(placeHolderSize);
        HashSet<Integer> indexes = IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toCollection(HashSet<Integer>::new));
        while (!indexes.isEmpty()) {
            int index = random.nextInt(list.size());
            if (indexes.contains(index)) {
                String formatFirstPart = String.format(getFormattedStringForIf(placeHolderSize, index, counter), indexes);

                shuffled.add(list.get(index));
                indexes.remove(index);

                String formatIndexesPart = String.format(getFormattedIndexes(
                        ConsoleColors.ANSI_GREEN,
                        placeHolderSize
                ), indexes);

                System.out.println(formatFirstPart + " " + formatIndexesPart);
            } else {
                String beforeIndexes = String.format(getFormattedStringForElse(placeHolderSize, index, counter), indexes);
                String formattedIndexes = String.format(getFormattedIndexes(
                        ConsoleColors.ANSI_YELLOW,
                        placeHolderSize
                ), indexes);
                System.out.println(beforeIndexes + " " + formattedIndexes);
            }
            counter++;
        }
        return shuffled;
    }

    private static @NotNull String getFormattedStringForIf(int width, int index, int counter) {
        return String.format(
                ConsoleColors.ANSI_GREEN +
                        "indexes: %%%ds; " +
                        "index %d removed from indexes, " +
                        "iterations: %3d; " +
                        ConsoleColors.RESET,
                width,
                index,
                counter
        );
    }

    private static @NotNull String getFormattedStringForElse(int width, int index, int counter) {
        return String.format(
                ConsoleColors.YELLOW +
                        "index %d was already removed from indexes" +
                        "-".repeat(width + 1) +
                        "iterations: %3d; " +
                        ConsoleColors.RESET,
                index,
                counter
        );
    }

    private static String getFormattedIndexes(String color, int placeHolderSize) {
        return String.format(
                color +
                        "indexes:  %%%ds; " +
                        ConsoleColors.RESET,
                placeHolderSize
        );
    }

    /**
     * Алгоритм Фишера-Йетса
     * <p>
     * Алгоритм заключается в том, чтобы проходить по массиву от конца к началу
     * и на каждом шаге выбирать случайный элемент из всех еще не перемещенных элементов
     * и менять его местами с текущим элементом.
     */
    private static void shuffleArray(int[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

}
