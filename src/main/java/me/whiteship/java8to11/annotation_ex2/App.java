package me.whiteship.java8to11.annotation_ex2;

import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘간장")
//TODO Annotation 의 변화
public class App {
    public static void main(String[] args) {
        //TODO type1
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach( c -> System.out.println(c.value()));

        System.out.println("===========================================================");
        //TODO type2
        ChickenContainer chickenContainers = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainers.value()).forEach( c -> System.out.println(c.value()));
    }
}
