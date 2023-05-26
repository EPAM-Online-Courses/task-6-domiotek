package efs.task.functional;

import java.util.*;
import java.util.stream.Collectors;

class PeopleProcessor {
    List<String> namesOfPeopleWhoseAgeIsGreaterThan(int age, Collection<Person> people) {
        return people.stream().filter(p -> p.getAge() > age).map(Person::getName).collect(Collectors.toList());
    }


    List<String> namesOfPeopleSortedByAgeLivingIn(String cityOfLiving, Collection<Person> people) {
        return people.stream().filter(p -> p.getCityOfLiving().equals(cityOfLiving))
                .sorted(Comparator.comparingInt(Person::getAge)).map(Person::getName).collect(Collectors.toList());
    }

    Map<String, Double> averageAgeByCityOfLiving(Collection<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getCityOfLiving, Collectors.averagingDouble(Person::getAge)));
    }
}
