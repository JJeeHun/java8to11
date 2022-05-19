package me.whiteship.java8to11;

//추상메소드가 한개만 있으면 함수형 인터페이스다. -> abstact 함수의 갯수가 1개이어야 한다.
@FunctionalInterface
public interface RunSomething {

    void doIt();

//    static void printName() {
//        System.out.println("Keesun");
//    }
//
//    default void printAge() {
//        System.out.println("40");
//    }
}
