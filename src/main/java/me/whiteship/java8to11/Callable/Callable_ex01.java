package me.whiteship.java8to11.Callable;

import java.util.concurrent.*;

public class Callable_ex01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /* TODO Callable = return type 이 있는 Runnable */
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);

        System.out.println(helloFuture.isDone());//TODO Thread 의 상태를 체크 끝났으면 true
        System.out.println("Started!");

        //TODO Thread 작업을 취소 한다. cancel 이 실행되고 나면 작업을 종료하지 않아도 get 을 해올 수 없다. CancellationException Error
        //TODO helloFuture.cancel(true);

        /* TODO get 을 만나기 전까지는 로직이 실행됨 -> get 을 만나면 Thread 의 작업이 완료 될 때까지 기다림
        *  TODO 작업이 완료되면 get 이후의 로직이 실행됨. */
        helloFuture.get(); //Blocking call

        System.out.println("========================================");

        //TODO isDone 은 get 을 할 수 있다는 의미는 아니다. 현재 Thread 의 작업 상태일 뿐
        System.out.println(helloFuture.isDone());//TODO Thread 의 상태를 체크 끝났으면 true
        System.out.println("End!!");

        executorService.shutdown();





    }
}
