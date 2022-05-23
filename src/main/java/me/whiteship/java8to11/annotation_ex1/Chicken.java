package me.whiteship.java8to11.annotation_ex1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO Annotation -> JAVA5 의 기능.
@Retention(RetentionPolicy.RUNTIME)//TODO ( Retention 전략. ) 이 Annotation 을 사용한 곳의? 기능을? 언제까지 사용할것인가
@Target(ElementType.TYPE_USE)
//TODO ElementType.TYPE_PARAMETER
//TODO Annotation 을 사용할 곳. -> ElementType.TYPE_PARAMETER -> class 의 type 정의에  붙있 수 있게 하는 Annotation
//TODO public class < @Chicken T > -> Generic type 에 사용가능.

//TODO ElementType.TYPE_USE
//TODO TYPE 을 선언하는 모든 곳에서 사용가능
//TODO Method type 선언부 클래스 정의부 등.
public @interface Chicken {
}
