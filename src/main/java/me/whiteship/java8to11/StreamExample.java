package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        /* 번외.
         * 청크 기반 -> 토렌트에서 실시간으로 보는 기법
         *  -> 다운로드시 이전 시작 지점부터 읽어서 다시 쓰는 기법
         *  -> 청크 기반이 아니면 취소시 다시 처음부터 받아야 한다.
         * */


        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        //기존의 데이터를 건드리지 않고 새로운 Stream으로 반환
        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        names.forEach(System.out::println);
        stringStream.forEach(System.out::println);

        System.out.println("==================================================");

        /* 중계형 오퍼레이터는 실행을 하지 않는다. map은 중계형이기 때문에 종료형 오퍼레이터가 오기전까지 실행하지 않음.
        * 중계형 오퍼레이터들은 한번만 실행한다.(종료형이 실행됫을 경우 한번.)
        * 중계형 오퍼레이션은 근복적으로 lazy하다.
        * 종료형 operator는 Stream이 아닌 다른 객체를 return
        * ex) Stream에 담아서 forEach 돌릴경우 실행되는거 보니까 forEach는 종료형인듯?
        * 종료형 operator -> collect , */
        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });



        System.out.println("==================================================");

        /* 종료형 operator 실행 */
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);//출력시 해당하는 내용 바뀌기 전.
            return s.toUpperCase();
        }).collect(Collectors.toList());// 바뀐 후 출력은 list로 담겨있는 return 받은 객체에서 확인 가능.

        collect.forEach(System.out::println);

        System.out.println("==================================================");

        /* Stream 사용시 좋은 점.
        * 1. 병렬처리 가능. ( parallelStream 사용 JVM이 알아서 처리 해줌 -> Splitlator? 쪼개서 처리 후 다시 합쳐줌 )
        * */
        List<String> collect1 = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        /* 병렬처리 주의점
        * 병렬처리시 비용 발생이 많아짐.
        * 스위칭 비용 , 객체 사용 비용, 다시 합치기 위한 수집 비용등.....
        * 병렬처리를 해야 할 때 -> 데이터가 너무 많을 경우.(처리할 데이터가 많을 경우)
        * 직렬 , 병렬 둘다 적용 후 시간이 적은 경우를 측정 후 사용이 가장 좋다.
        * */
        List<String> collect2 = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName()); /* parallelStream -> 다른 쓰레드로 처리 */
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("==================================================");
    }


}
