package me.whiteship.java8to11.Thread_example;

public class Example03 {
    public static void main(String[] args) {
        /* TODO Thread 가 sleep 에 들어가면 다른 Thread 가 돌아간다.
        *  TODO InterruptedException -> 누군가가 sleep 을 깨우면 InterruptedException 발생 */
        Thread thread = new Thread(() ->{
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread :: " + Thread.currentThread().getName());
        });

        thread.start();

        System.out.println("Hello :: " + Thread.currentThread().getName());
    }
}
