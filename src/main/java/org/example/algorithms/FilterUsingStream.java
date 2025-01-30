package org.example.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FilterUsingStream {
    public static void main(String[] args) {
//        У нас есть коллекция personList<Person>
//        Приведите пример, в котором вы фильтруете список по возрасту более 20 лет,
//        Затем извлекаете только имена, сортируете их по возрастанию
//        и собираете результат в новую коллекцию (ее можно просто вывести)

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Leha", 20));
        personList.add(new Person("Max", 22));
        personList.add(new Person("Mihailo", 15));
        personList.add(new Person("Danilo", 45));
        personList.add(new Person("Pavlenti", null));

        System.out.println(
                personList.stream()
                        .filter(person -> person.getAge() != null && person.getAge() > 20)
                        .map(Person::getName)
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList())
        );
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
