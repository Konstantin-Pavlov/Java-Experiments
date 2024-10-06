package org.example.streamExamples;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapAndStream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("James", "Morison", 25),
                new Person("Alice", "Johnson", 30),
                new Person("Michael", "Smith", 28),
                new Person("Emily", "Davis", 22),
                new Person("David", "Brown", 35),
                new Person("Sophia", "Wilson", 27),
                new Person("Daniel", "Taylor", 31),
                new Person("Olivia", "Anderson", 26),
                new Person("Matthew", "Thomas", 59),
                new Person("Isabella", "Jackson", 26),
                new Person("Ethan", "White", 33),
                new Person("Mia", "Harris", 25),
                new Person("James", "Martin", 34),
                new Person("Charlotte", "Thompson", 25),
                new Person("Alexander", "Garcia", 32)
        );

        people.stream()
                .filter(person -> person.getFullName().length() < 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresentOrElse(
                        fullName -> System.out.println("person found: " + fullName),
                        () -> System.out.println("person not found")
                );

        Map<Integer, List<String>> peopleMappedByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getFullName, Collectors.toList())));

        Map<Integer, List<String>> collected = peopleMappedByAge.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        // won't work if there's duplicate age, that's why we need to compare two objects in this case somehow
        Map<Integer, Person> personMap = people.stream()
                .collect(Collectors.toMap(
                        Person::getAge,
                        Function.identity(), // Value mapper: use the Person object itself as the value
                        (person1, person2) -> { // Merge function for handling duplicate keys
                            // Compare by full name length, then lexicographical order
                            int compare = Integer.compare(person1.getFullName().length(), person2.getFullName().length());
                            if (compare == 0) {
                                return person1.getFullName().compareTo(person2.getFullName()) <= 0 ? person1 : person2;
                            }
                            return compare < 0 ? person1 : person2;
                        }
                ));

        System.out.println(peopleMappedByAge);
        System.out.println(collected);
        System.out.println(personMap);

    }
}

@ToString
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Person {
    String firstName;
    String lastName;
    int age;

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
