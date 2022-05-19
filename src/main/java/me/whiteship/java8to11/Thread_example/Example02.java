package me.whiteship.java8to11.Thread_example;

public class Example02 {
    /* TODO Runnable 을 갖고 구현 함. */
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread :: " + Thread.currentThread().getName());
            }
        });

        /* TODO Lambda 로 구현 가능 */
        Thread thread1 = new Thread(() -> System.out.println("Thread :: " + Thread.currentThread().getName()));

        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
    }
}
