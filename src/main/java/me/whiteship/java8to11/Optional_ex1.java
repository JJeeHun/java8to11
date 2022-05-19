package me.whiteship.java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Optional_ex1 {
    public static void main(String[] args) {
        List<OnlineClass_ex2> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass_ex2(1, "spring boot", true) );
        springClasses.add(new OnlineClass_ex2(2, "spring data jpa", true) );
        springClasses.add(new OnlineClass_ex2(3, "spring mvc", false) );
        springClasses.add(new OnlineClass_ex2(4, "spring core", false) );
        springClasses.add(new OnlineClass_ex2(5, "rest api development", false) );

        OnlineClass_ex2 spring_boot = new OnlineClass_ex2(1, "spring boot", true);
        Duration studyDuration = spring_boot.getProgress().getStudyDuration(); //TODO Progress 가 Null 이기 때문에 getStudyDuration 에서 NullPoint Exception 발생
        //TODO 그렇기 때문에 Null 체크 로직이 필요함. -> Null 체크를 깜빡 할 수 있다.
        System.out.println(studyDuration);

        /**
         * TODO 그래서 Optional 을 사용
         * TODO 주의 사항
         * TODO 1. 리턴값으로만 쓰기를 권장 ( 메소드 매개변수 타입(parameter), 맵의 키 타입, 인스턴스 필드 타입(ex - private Optional<Progress> pr)으로 쓰지 말자. )
         * TODO 2. Optional 을 return 하는 메소드에서 null 을 return 하지 말자.
         * TODO 3. 프리미티브 타입용 Optional 은 따로 있다. OptionalLong...
         * TODO 4. Contatier types ,including collections ,maps ,streams ,arrays ,and optionals should not be wrapped in optionals
         * TODO 5. Collection , Map ,Stream ,Array 는 optional 감싸지 말 것
         */
    }
}



