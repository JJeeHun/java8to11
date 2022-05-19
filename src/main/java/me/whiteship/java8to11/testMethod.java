package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.function.Function;

public class testMethod {

    public String setGreetings(Greeting[] greetings, Function<Greeting,String> fn) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(Greeting greeting : greetings) {
            arrayList.add(fn.apply(greeting));
        }
        return arrayList.toString();
    }
}
