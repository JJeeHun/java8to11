package me.whiteship.java8to11;

public class Greeting {
    String name = "";

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }

    public String getName() {
        return this.name;
    }

    public int ignore(Greeting test) {
        return this.name.compareToIgnoreCase(test.getName());
    }
}
