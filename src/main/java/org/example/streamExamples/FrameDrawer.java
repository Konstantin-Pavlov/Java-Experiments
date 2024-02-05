package org.example.streamExamples;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Sample Input 1:
5 4
Sample Output 1:
****
*  *
*  *
*  *
****

Sample Input 2:
-1 5
Sample Output 2:
ERROR
*/

class FrameDrawer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        try {
            int height = Integer.parseInt(input[0]);
            int width = Integer.parseInt(input[1]);

            if (height > 0 && width > 0) {
                drawFrame(height, width);
            } else {
                System.out.println("ERROR");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR");
        }
        scanner.close();
    }

    private static void drawFrame(int height, int width) {
        IntStream.range(0, height)
                .forEach(row -> {
                    if (row == 0 || row == height - 1) {
                        drawLine(width);
                    } else {
                        drawMiddleLine(width);
                    }
                });
    }

    private static void drawLine(int width) {
        System.out.println("*".repeat(width));
    }

    private static void drawMiddleLine(int width) {
        System.out.println("*" + " ".repeat(Math.max(0, width - 2)) + "*");
    }
}
