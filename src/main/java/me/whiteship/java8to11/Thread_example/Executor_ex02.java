package me.whiteship.java8to11.Thread_example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor_ex02 {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        /* TODO ExecutorService 다음 작업을 계속기다림 서비스가 죽지 않음. 명시적으로 서비스를 종료시켜줘야함. */

        /* TODO Pattern 1 */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(getRunnable("Hello"));
        executorService.execute(getRunnable("Keesun"));
        executorService.execute(getRunnable("The"));
        executorService.execute(getRunnable("Java"));
        executorService.execute(getRunnable("Thread"));


        /* TODO 다른 Thread 와 상관없이 종료 */
        executorService.shutdown();

    }

    private static Runnable getRunnable(String message) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(message + " :: " + Thread.currentThread().getName());
            }
        };
    }
}
