package me.whiteship.java8to11.Thread_example;

public class Example01 {

    /* TODO Thread 는 순서를 보장하지 않는다. -> 흐름상 Thread 이름이 먼저 출력되고 Hello 가 출력되야 하지만
    *  TODO 순서를 보장하지 않기 때문에 Hello 가 먼저 출력 될 수 있다.
    *  TODO Thread 를 상속 받아서 사용 */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Trhead : " + Thread.currentThread().getName());
        }
    }
}
