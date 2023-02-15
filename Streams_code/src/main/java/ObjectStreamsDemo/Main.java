package ObjectStreamsDemo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List< Person> people = getPeople();

        List < Person> female = people.stream().filter(s-> s.getGender() == Gender.FEMALE).collect(Collectors.toList());
        female.forEach(f -> System.out.println(f));

        List< Person > sortedByAge = people.stream().sorted(Comparator.comparing(Person::getage).reversed()).collect(Collectors.toList());
        sortedByAge.forEach(person -> System.out.println(person));

        //find all people with age > 5

        boolean r = people.stream().noneMatch(p -> p.getName().equals("aashu"));
        System.out.println(r);

        people.stream().max(Comparator.comparing(Person::getage)).ifPresent(s -> System.out.println(s));

        //group

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((k, v) -> System.out.println(k + " " + v));

    }

    private static List< Person> getPeople(){

        return List.of(
                new Person("aadi", 27, Gender.MALE),
                new Person("tomar", 25, Gender.MALE),
                new Person("yes", 21, Gender.FEMALE),
                new Person("aashu", 12, Gender.MALE),
                new Person("ram", 67, Gender.FEMALE),
                new Person("rahim", 37, Gender.FEMALE)
        );

    }
}
