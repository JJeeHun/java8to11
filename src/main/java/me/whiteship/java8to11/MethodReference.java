package me.whiteship.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {
    public static void main(String[] args) {
        /**
         * Method Reference
         * ex) UnaryOperator<String> hi = Greeting::hi; = UnaryOperator<String> hi1 = (name) -> "hi " + name;
         * 이미 구현하고자 하는 기능이 존재 할 경우 구현하지 않고 참조 가능.
         */
        //static 메소드 사용
        UnaryOperator<String> hi = Greeting::hi;

        //생성자 메소드 사용
        UnaryOperator<String> hello = new Greeting()::hello;

        //생성자 메소드 사용 1
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello1 = greeting::hello;

        //생서자를 사용
        Supplier<Greeting> getGreeting = Greeting::new; //기본생성자 Supplier는 인자(parameter)가 없음
        Greeting newGreeting = getGreeting.get();

        //String parameter를 전달하면서 return으로 Greeting을 반환
        Function<String, Greeting> functionGreeting = Greeting::new;
        Greeting nameGreeting = functionGreeting.apply("JeeHun");// 1개의 parameter를 전달하고 String 타입인 생성자를 호출

        System.out.println("Greeting : "+nameGreeting.getName());


        /**
         * 임의 객체의 인스턴스 메소드 참조
         * target으로 넘어오는 타입의 메소드를 임의로 참조 할 수 있다.
         */
        String[] names = {"keesun","whiteship","toby"};
        Arrays.sort(names, String::compareToIgnoreCase);//String 두개의 인자중 첫번째의 타입의 compareToIgnoreCase 메소드의 parameter두가지의 타입이 일치
        System.out.println(Arrays.toString(names));

        System.out.println("keesun".compareToIgnoreCase("whiteship"));
        System.out.println("whiteship".compareToIgnoreCase("keesun"));

        Greeting[] greetings = {new Greeting("test3"), new Greeting("test1"), new Greeting("test2")};
        Arrays.sort(greetings, Greeting::ignore);
        List<Greeting> list = Arrays.asList(greetings);
        list.forEach((gree) -> System.out.println(gree.getName()));
        List<String> greetingNames = list.stream().map(Greeting::getName).collect(Collectors.toList());

        System.out.println("greetingNames :: "+greetingNames.toString());

        //타입으로도 사용가능? 설명하기가 애매하네
        testMethod testMethod = new testMethod();
        System.out.println("testMethod :: " + testMethod.setGreetings(greetings,Greeting::getName));
    }
}
