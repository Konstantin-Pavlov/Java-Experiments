package org.example.fuctionalInterfaceExample.cat.task1;


import org.example.fuctionalInterfaceExample.cat.Cat;
import org.example.fuctionalInterfaceExample.cat.Printer;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        var cats = Cat.makeCats(10);
        Printer.print(cats);
        Printer.drawLine();

        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        // cats.sort(?);
        // Printer.print(cats);

        // сортировка по породе
        cats.sort(Cat::byBreed);
        Printer.print(cats);
        Printer.drawLine();

        // сортировка по имени, потом по возрасту
        cats.sort(Cat::byNameThenByAge);
        Printer.print(cats);
        Printer.drawLine();

        // не знаю как ещё получить какой-нибудь цвет кота. Поэтому юзаем первого кота в коллекции
        Cat cat = cats.get(0);
        System.out.println("удаление котов с цветом: " + cat.getColor());
        cats.removeIf(cat::removeByColor);
        Printer.print(cats);
        Printer.drawLine();

        System.out.println("удаление имен с длиной: " + cat.getName().length());
        cats.removeIf(c -> c.getName().length() == cat.getName().length());
        Printer.print(cats);
        Printer.drawLine();
    }

}

