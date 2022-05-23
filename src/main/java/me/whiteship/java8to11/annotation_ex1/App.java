package me.whiteship.java8to11.annotation_ex1;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws @Chicken RuntimeException{
        //TODO @Chicken 를 사용한 모든 곳 -> type_use 를 사용했기 때문에 가능.
        List<@Chicken String> names = Arrays.asList("keesun");
    }

    //TODO Generic class < T, R > type variable -> JAVA5
    static class  FeelsLikeChicken<@Chicken T> {

        //TODO 접근 지시자와 return type 정의 사이에 Generic 선언
        public static <C> void print(C c) { //TODO <C> = type Parameter, C = type

        }
    }
}
