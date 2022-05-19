package me.whiteship.java8to11;

public class Foo {

    public static void main(String[] args) {
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt()  {
                System.out.println("Hello");
            }
        };
        runSomething.doIt();

        RunSomething runSomething1 = () -> { System.out.println("Ramda"); };
        runSomething1.doIt();

        RunSomething runSomething2 = () -> System.out.println("Ramda2");
        runSomething2.doIt();
    }
}
