package org.example.asciiCharSequence;

public class Main {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer);//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello

        //проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!

        System.out.println();

        byte[] x = new byte[]{65, 66, 67, 68, 69, 70, 71};
        AsciiCharSequence myX = new AsciiCharSequence(x);
        System.out.println(myX.length()); // 7
        System.out.println(myX.charAt(3)); // D
        System.out.println(myX.subSequence(3, 5)); // DE
        System.out.println(myX); // ABCDEFG
    }
}

