package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Optional_ex2 {
    public static void main(String[] args) {
        List<OnlineClass_ex2> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass_ex2(1, "spring boot", true) );
        springClasses.add(new OnlineClass_ex2(5, "rest api development", false) );

        Optional<OnlineClass_ex2> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println(present);

        System.out.println("==============================================");

        Optional<OnlineClass_ex2> spring1 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa")) //TODO 중계형 오퍼레이터
                .findFirst();//TODO 찾은 첫번째 데이터 (종료형 오퍼레이터)

        boolean present1 = spring1.isPresent();
        System.out.println(present1);

        System.out.println("==============================================");

        //TODO 값이 있는 경우는 문제가 없다.
        Optional<OnlineClass_ex2> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass_ex2 onlineClass_ex2 = optional.get();
        System.out.println(onlineClass_ex2.getTitle());

        System.out.println("==============================================");

        //TODO 값이 존재 하지 않을 경우 -> NoSuchElementException 에러 발생
        //TODO Optional 에서 Functional 을 이용해 처리
        Optional<OnlineClass_ex2> optional1 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        //TODO jpa로 시작하는 문자가 없기 때문에 get 요청시 ERROR 발생
        /*OnlineClass_ex2 onlineClass_ex2_1 = optional1.get();
        System.out.println(onlineClass_ex2.getTitle());*/

        System.out.println("==============================================");
        optional1.ifPresent(oc -> oc.getTitle());//TODO Consumer 타입이기 때문에 Parameter 만 존재 ( void )

        //TODO 값이 있을 경우는 있는 값을 가져오고 값이 없을 경우는 새로운 인스턴스를 넘겨줌.
        OnlineClass_ex2 onlineClass_ex2_2 = optional1.orElse(createNewClass());//TODO Optional 의 객체 타입의 인스턴스를 넘겨줘야함.
        System.out.println(onlineClass_ex2_2.getTitle());//TODO 새로운 인스턴스 TITLE 출력 - New class

        System.out.println("==============================================");

        /*TODO orElse를 사용할때 메소드로 실행해서 넘겨주면 메소드자체를 실행 후 인스턴스를 반환하기 때문에 불필요한 자원을 사용한다.  */
        OnlineClass_ex2 onlineClass_ex2_3 = optional.orElse(createNewClass());//TODO Optional 의 객체 타입의 인스턴스를 넘겨줘야함.
        System.out.println(onlineClass_ex2_3.getTitle());//TODO 값이 존재하기 때문에 해당 객체의 title 이 출력 -> spring boot

        System.out.println("==============================================");

        /*TODO Functional Interface 를 사용하기 때문에 불필요한 연산을 하지 않는다. Lazying 처리 */
        OnlineClass_ex2 onlineClass_ex2_4 = optional.orElseGet(Optional_ex2::createNewClass);//TODO Supplier Functional Interface 를 넘겨줌.
        System.out.println(onlineClass_ex2_4.getTitle());

        System.out.println("==============================================");

        /*TODO 값이 없을 경우 ERROR 처리 -> 무조건 있어야 할 경우 */
        //OnlineClass_ex2 onlineClass_ex2_5 = optional1.orElseThrow(IllegalStateException::new);//TODO 값이 없을 경우 ERROR 를 던진다. 메소드 레퍼런스 사용
        //System.out.println(onlineClass_ex2_5.getTitle());

        System.out.println("==============================================");

        Optional<OnlineClass_ex2> onlineClass_ex2_6 = optional.filter(oc -> oc.isClosed());
        System.out.println( onlineClass_ex2_6.isPresent() ); //TODO isPresent 있으면 true, isEmpty() 비어잇으면 true



    }

    private static OnlineClass_ex2 createNewClass() {
        System.out.println("인스턴스 생성 메소드");
        return  new OnlineClass_ex2(10, "New class",false);
    }
}
