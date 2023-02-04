package me.whiteship.chapter01.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    LocalDate birthday;

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982,7,15)));
        people.add(new Person(LocalDate.of(2011,7,15)));
        people.add(new Person(LocalDate.of(2013,7,15)));

        // JAVA 8 이전 익명 내부클래스 사용하는 방법
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.birthday.compareTo(o2.birthday);
            }
        });

        // JAVA 8 이후 lamda 사용
        people.sort((p1, p2) -> p1.birthday.compareTo(p2.birthday));
        people.sort((p1, p2) -> Person.compareByAge(p1, p2));
        // static method reference
        people.sort(Person::compareByAge);

        // LocalDate 를 가지고 Person 객체로 변경
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1942,4,5));
        dates.add(LocalDate.of(1943,4,5));
        dates.add(LocalDate.of(1944,4,5));

        dates.stream().map(Person::new).collect(Collectors.toList());
    }
}
