package me.whiteship.java8to11.Callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Callable_ex02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //TODO ExecutorService executorService = Executors.newSingleThreadExecutor(); 싱글스레드
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /* TODO Callable = return type 이 있는 Runnable */
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "Keesun";
        };

        /* TODO invokeAll 은 작업시간에 상관없이 전체 작업이 끝날때까지 기다림. */
        // TODO List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, keesun));

        // TODO invokeAny 는 먼저 끝난 작업의 결과를 먼저 return 후 종료
        // TODO 작업결과는 스레드 갯수와 작업순서에 의해 변경될 수 있다.
        // TODO 싱글스레드일 경우 Hello 출력 1개의 스레드의 hello , java , keesun 순서로 들어가기 때문에 hello 출력함.
        // TODO 스레드가 3개일 경우 각각의 스레드의 순서대로 작업 객체가 들어가므로 제일 빨리 끝난 작업부터 return 함.
        String s = executorService.invokeAny(Arrays.asList(hello, java, keesun));
        System.out.println(s);
//        for (Future<String> f:  futures) {
//            System.out.println( f.get() );
//        }


        executorService.shutdown();





    }
}
