package me.whiteship.java8to11.annotation_ex2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO 범위가 더 넓어야함.
@Retention(RetentionPolicy.RUNTIME)//TODO 언제까지 유지 할 것인가.
@Target(ElementType.TYPE_USE)//TODO 어디에 위치 할 것인가.
public @interface ChickenContainer {

    Chicken[] value();
}
