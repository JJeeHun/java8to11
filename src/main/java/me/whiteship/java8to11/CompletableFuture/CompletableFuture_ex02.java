package me.whiteship.java8to11.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuture_ex02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*TODO Thread 의 연결 및 예외 처리 */

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ::: " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World ::: " + Thread.currentThread().getName());
            return "World";
        });

        /**
         * TODO 기본 방식
         * TODO hello.get(); get 으로 먼저 실행 후
         * TODO world.get(); 다음 실행
         */

        //TODO hello 처리 후 처리
        CompletableFuture<String> future = hello.thenCompose(CompletableFuture_ex02::getWorld);

        System.out.println(future.get());

        System.out.println("================================================");

        //TODO 두가지의 값이 전부 존재 할 경우 처리
        //TODO parameter 1 = 같이 처리 할 객체, parameter 2 = BiFunction(처리할 2개의 인자를 넘겨주는 함수)
        CompletableFuture<String> future1 = hello.thenCombine(world, (hello_str, world_str) -> hello_str + world_str);
        System.out.println(future1.get());

        System.out.println("================================================");

        //TODO 모든 task 를 전부 담아서 처리 할 수도 있지만 모든 작업의 타입이 같은 타입이란 보장도 없고 에러가 났을 수도 있다.
        CompletableFuture<Void> future2 = CompletableFuture.allOf(hello,world)//TODO 추가로 더 넣을 수 있음.
                .thenAccept(System.out::println);//TODO 넘어온 argument = null 값을 가짐 타입의 보장이 없음.
        System.out.println(future2.get());

        System.out.println("================================================");

        //TODO 작업을 모은 List
        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture<String>[] futuresArray = futures.toArray(futures.toArray(new CompletableFuture[futures.size()]));//TODO ?? 해당 배열에 인스턴스 주입같음

        //TODO 작업 일괄 실행 - 좀 어렵군. -> CompletableFuture 의 제네릭 타입이 map 의 파라미터로 전달
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                                                .thenApply(v -> {//TODO v 로 넘어오는 값은 중요하지 않음. return 이 중요
                                                    //TODO thenApply 가 실행됬을 시점은 future 가 완료 된 시점이기 때문에 futures 를 사용 할 수 있다.
                                                    return futures.stream()//TODO futures 를 stream 으로 반환
                                                            .map(CompletableFuture::join) //TODO map 의 parameter 를 받아서 CompletableFuture::join 으로 처리 후 결과 값을 return 받음.
                                                            .collect(Collectors.toList());//TODO List 로 반환
                                                });

        System.out.println("CompletableFuture<List<String>>");
        results.get().forEach(System.out::println);

        System.out.println("================================================");

        //TODO 먼저 찾은 결과를 실행.
        CompletableFuture.anyOf(hello, world).thenApply((s) -> { //TODO parameter => Function interface
            System.out.println(s);
            return s;
        });//TODO Method Reference CompletableFuture.anyOf(hello, world).thenApply(System.out::println) 로 사용가능.

        System.out.println("===================== 에러 처리 ===========================");
        boolean throwError = false;

        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
                    if (throwError) throw new IllegalArgumentException();

                    System.out.println("Hello " + Thread.currentThread().getName());
                    return "Hello";
                })
                //Error 가 났을 경우 처리
                .exceptionally( ex -> {
                    System.out.println("ex : " + ex);
                    return "Hello";
                });

        System.out.println(hello1.get());//output -> Hello


        System.out.println("===================== 에러 처리 1 ===========================");

        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
                    if (throwError) throw new IllegalArgumentException();

                    System.out.println("Hello " + Thread.currentThread().getName());
                    return "Hello";
                })
                //TODO 성공했을 수도 있고 Exception 이 났을 수도 있다.
                .handle( ( result , ex ) -> {
                   if( ex != null) {
                       System.out.println("handle Error : " + ex);
                       return "ERROR!";
                   }
                    return result;
                });

        System.out.println(hello2.get());//TODO output -> Hello
        //TODO 1. ForkJoin FrameWork , 2. FLow -> 공부
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World ::: " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}