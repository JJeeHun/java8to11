package me.whiteship.java8to11;

import java.util.function.Function;

public class main1 {
    public static void main(String[] args) {
        //class 생성
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(10));

        /** Interface ->
         * Function 객체를 1개의 객체를 인자(parameter)로 받아서 리턴을 함.
         * BiFunction 객체를 2개의 객체를 인자(parameter)로 받아서 리턴을 함. -> BiFunction<Integer, Integer, Integer>
         * Consumer 1개의 객체를 인자(parameter)로 받아서 실행하는 Interface
         * Supplier 인자(parameter)를 받지 않고 값을 리턴하는 Interface
         * Predicate 1개의 객체를 인자(parameter)로 받아서 true,false로 return -> 체인을 걸 수 있음.
         * UnaryOperator Function의 Generic을 줄일수 있따. -> Function<Integer, Integer> _plus10 = (i) -> i+10; -> UnaryOperator<Integer> _plus10 = (i) -> i+10;
         * BinaryOperator BiFunction의 객체타입이 전부 같다는 가정하에 존재하는 객체 -> BinaryOperator<Integer>
         */
        //바로 사용
        Function<Integer, Integer> _plus10 = (i) -> i+10;
        System.out.println(_plus10.apply(10));

        Function<Integer, Integer> multiply2 = (i) -> i*2;

        //인자로 받은 값을 먼저 계산 후 타겟을 실행 할 Function 객체를 return 받는다.
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println("multiply2AndPlus10 ::: " + multiply2AndPlus10.apply(2));//결과 -> n * 2 -> 2n + 10;

        //타켓을 먼저 계산 후 다음 인자를 계산 할 Function 객체를 return 함
        Function<Integer, Integer> plus10AndMultiply = plus10.andThen(multiply2);
        System.out.println("plus10AndMultiply ::: " + plus10AndMultiply.apply(2));//결과 -> n + 10 -> (n+10) * 2
    }
}
