package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        List<OnlineClass_ex1> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass_ex1(1, "spring boot", true) );
        springClasses.add(new OnlineClass_ex1(2, "spring data jpa", true) );
        springClasses.add(new OnlineClass_ex1(3, "spring mvc", false) );
        springClasses.add(new OnlineClass_ex1(4, "spring core", false) );
        springClasses.add(new OnlineClass_ex1(5, "rest api development", false) );

        System.out.println("spring 으로 시작하는 수업");
        //TODO
        springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring")).forEach(oc -> System.out.println(oc.getTitle()));

        System.out.println("\nclose 되지 않은 수업");
        //TODO
        springClasses.stream().filter(oc -> !oc.isClosed()).forEach(oc -> System.out.println(oc.getTitle()));
        /* springClasses.stream().filter(Predicate.not(OnlineClass_ex1::isClosed)).forEach(oc -> System.out.println(oc.getTitle()));
         * Java10 이하는 Predicate의 not을 사용 할 수 없다. 10이상에서 사용가능.
         */

        System.out.println("\n수업 이름만 모아서 스트림 만들기_v1");
        //TODO
        List<String> titles = springClasses.stream().map(oc -> oc.getTitle()).collect(Collectors.toList());
        titles.forEach(System.out::println);

        System.out.println("\n수업 이름만 모아서 스트림 만들기_v2");
        //TODO
        List<String> titles1 = springClasses.stream().map(OnlineClass_ex1::getTitle).collect(Collectors.toList());
        titles1.forEach(System.out::println);

        List<OnlineClass_ex1> javaClasses = new ArrayList<>();
        javaClasses.add( new OnlineClass_ex1(6, "The Java, Test",true) );
        javaClasses.add( new OnlineClass_ex1(7, "The Java, Code manipulation",true) );
        javaClasses.add( new OnlineClass_ex1(8, "The Java, 8 to 11",false) );

        List<List<OnlineClass_ex1>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("\n두 수업 목록에 들어있는 모든 수업 아이디 출력");
        //TODO flatmap 은 안에 객체를 풀어서 stream 으로 반환 stream 으로 반환하기 위해 Collection.stream 을 사용
        keesunEvents.stream().flatMap(Collection::stream)
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("\n10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        //TODO
        Stream.iterate(10,i -> i+1)//TODO 무제한 스트림 생성 (중계형 오퍼레이터)
                .skip(10) //TODO 10개 skip
                .limit(10) //TODO 10까지
                .forEach(System.out::println);//TODO 종료형 오퍼레이터

        System.out.println("\n모든 수업중에 Test 가 들어잇는 수업이 있는지 확인");
        //TODO 모든 수업중에
        keesunEvents.stream().flatMap(Collection::stream)
                        .filter(oc -> oc.getTitle().contains("Test"))
                        .forEach(oc -> System.out.println(oc.getTitle()));

        System.out.println("\n자바 수업중에 Test 가 들어잇는 수업이 있는지 확인");
        //TODO 자바 수업중에
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));//TODO anyMatch (종료형 오퍼레이터?)
        System.out.println(test);

        System.out.println("\n스프링 수업 중에 제목에 spring 이 들어간 것만 모아서 List 로 만들기");
        //TODO filter 후 map 을 사용해도 되지만 가독성을 위해 map 을 먼저 사용
        List<String> spring = springClasses.stream().map(OnlineClass_ex1::getTitle)
                                                     .filter(title -> title.contains("spring"))
                                                     .collect(Collectors.toList());
        spring.forEach(System.out::println);


    }
}
