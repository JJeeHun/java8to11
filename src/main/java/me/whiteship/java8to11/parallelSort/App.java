package me.whiteship.java8to11.parallelSort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers);
        System.out.println( "serial sorting took : " + (System.nanoTime() - start) );

        System.out.println("===============================================================");

        IntStream.range(0, size).forEach( i -> numbers[i] = random.nextInt() );
        start = System.nanoTime();
        Arrays.parallelSort(numbers);//TODO 자원에 따라 달라짐. -> 데이터가 많을 수록 유리
        System.out.println("parallel sorting took : " + (System.nanoTime() - start) );
    }
}
