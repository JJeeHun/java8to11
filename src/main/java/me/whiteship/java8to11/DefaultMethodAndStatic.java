package me.whiteship.java8to11;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DefaultMethodAndStatic {
    public static void main(String[] args) {
        /* Collection의 하위 타입은 forEach를 들고 있다. */
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        names.forEach(System.out::println);

        System.out.println("=======================================");

        /* tryAdvance가 돌고나면 객체는 비어있다. -> trySplit = 한개의 객체를 분할한다. */
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));

        System.out.println("=======================================");

        while (spliterator1.tryAdvance(System.out::println));

        /* Collection 하위타입은 Stream을 갖는다. */
        Set<String> set = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toSet());

        System.out.println(set.toString());
        System.out.println("=======================================");

        names.removeIf(s -> s.startsWith("k"));
        names.forEach(System.out::println);

        System.out.println("=======================================");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());//order by 변경

        System.out.println(names);
    }
}
