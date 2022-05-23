package me.whiteship.java8to11.CompletableFuture;

import java.util.concurrent.*;

public class CompletableFuture_ex01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* TODO Future 로 하기 어렵던 작업들 .
        *  TODO 1. Future 를 외부에서 완료 시킬 수 없다.
        *  TODO 2. 블로킹 코드 get 을 하지 않고서는 작업이 끝났을 때 콜백을 실행 할 수 없다.
        *  TODO 3. 여러 Future 와 조합 할 수 없다. ex) Event 정보 가져온 다음 Event 에 참석하는 회원 목록 가져오기
        *  TODO 4. 예외 처리용 API 를 제공하지 않는다. */

//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<String> future = executorService.submit(() -> "hello");
//
//        //TODO 블록킹 콜(Blocking call)이라서 후 처리 하기가 힘들다?
//        future.get();
        //TODO javascript 처럼 callback 으로 처리하기가 힘들다.?


        //TODO Pattern 1
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("keesun");//TODO 명시적으로 값을 주입.

        System.out.println(future.get());

        System.out.println(" ================================================ ");

        //TODO Pattern 2
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("keesun");//TODO static method 로 값 주입
        System.out.println(future1.get());

        System.out.println(" ================================================ ");

        //TODO return 이 없는 작업
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello :: " + Thread.currentThread().getName());
        });

        System.out.println(future2.get());

        System.out.println(" ================================================ ");

        //TODO return 이 있는 경우
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello :: " + Thread.currentThread().getName());
            return "Hello";
        });

        System.out.println(future3.get());

        System.out.println(" ================================================ ");

        //TODO CompletableFuture => callback 을 사용 할 수 있다.
        /* TODO thenApply(Function) = parameter 1 , return
        *  TODO thenAccept(Consumer) = parameter 1 (void)
        *  TODO thenRun(Runnable) = parameter x, return x 안에서 작업만 하고 끝낼 경우
        * */
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello :: " + Thread.currentThread().getName());
            return "Hello";
        })
        .thenApply((s) -> {//TODO Call back 으로 값을 대문자로 변경
            System.out.println("CALL BACK :: "+Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println(future4.get()); //TODO 종료 Operation?

        System.out.println(" ================================================ ");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        
        //TODO 기본적으로 ForkJoinPool 사용
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello :: " + Thread.currentThread().getName());
            return "Hello";
        }, executorService) //TODO 2번째 인자로 Executors 를 넘겨주면 해당 Thread pool을 사용
        .thenApply((s) -> {//TODO Call back 으로 값을 대문자로 변경
            System.out.println("CALL BACK :: "+Thread.currentThread().getName());
            return s.toUpperCase();
        });
        //TODO thenRunAsync(Runnable , Executors) Executors 를 넘겨주면 다른 Thread Pool 을 사용한다.

        System.out.println(future5.get()); //TODO 종료 Operation?

    }
}
