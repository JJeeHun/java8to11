package me.whiteship.java8to11.Thread_example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor_ex01 {
    public static void main(String[] args) {
        /* TODO ExecutorService 다음 작업을 계속기다림 서비스가 죽지 않음. 명시적으로 서비스를 종료시켜줘야함. */

        /* TODO Pattern 1 */
        ExecutorService executorService = Executors.newSingleThreadExecutor();//TODO single Thread
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread :: " + Thread.currentThread().getName());
            }
        });

        /* TODO Pattern 2 */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();//TODO single Thread
        executorService1.submit(() -> System.out.println("Thread :: " + Thread.currentThread().getName()));

        /* TODO graceful shutdown(끝까지 마치고 종료) => 아름답게 죽인다.!ㅋ */
        //executorService.shutdown();
        //executorService1.shutdown();

        /* TODO 다른 Thread 와 상관없이 종료 */
        executorService.shutdownNow();
        executorService1.shutdownNow();
    }
}
