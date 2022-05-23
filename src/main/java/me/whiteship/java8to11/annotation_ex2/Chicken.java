package me.whiteship.java8to11.annotation_ex2;

import java.lang.annotation.*;

//TODO Annotation -> JAVA5 의 기능.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
