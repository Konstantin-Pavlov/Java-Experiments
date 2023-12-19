package org.example.fuctionalInterfaceExample.cat.task2;

import org.example.fuctionalInterfaceExample.cat.ActiveCat;
import org.example.fuctionalInterfaceExample.cat.interfaces.Action;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Action> actions = List.of(
                ActiveCat::jump,
                ActiveCat::sleep,
                ActiveCat::eat
        );

        // исправьте код так, что бы на экран выводилось что-то вроде.
        // Я Misty. Я прыгаю!
        // Я Tibbles. Я сплю!
        // Я Ginger. Я кушаю!
        // для решения примените лямбда-выражения,
        // каждый кот должен уметь выполнять что-то своё
        //добавьте ещё два-три кота, с совершенно другими действиями

        List<ActiveCat> cats = Stream.generate(() -> new ActiveCat(actions.get(random.nextInt(actions.size()))))
                .limit(10)
                .collect(Collectors.toList());

        cats.forEach(ActiveCat::doAction);
        
    }
}
