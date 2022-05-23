package me.whiteship.java8to11.metaspace;

//TODO JVM 의 여러 메모리 영역 중에 PermGen 메모리 영역이 없어지고 Metaspace 영역이 생겼다.

/**
 * TODO PermGen
 * TODO * permanent generation, 클래스 메타데이터를 담는 곳.
 * TODO * Heap 영역에 속함.
 * TODO * 기본값으로 제한된 크기를 가지고 있음.
 * TODO * -XX:PermSIze=N, PermGen 초기 사이즈 설정
 * TODO * -XX:MaxPermSiz=N, PermGen 최대 사이즈 설정
 */

/**
 * TODO Metaspace
 * TODO * 클래스 메타데이터를 담는곳.
 * TODO * Heap 영역이 아니라, **Native 메모리 영역이다.
 * TODO * 기본값으로 제한된 크기를 가지고 있지 않다. ( 필요한 만큼 계속 늘어난다. )
 * TODO * 자바 8부터는 PermGen 관련 java 옵션은 무시한다.
 * TODO * -XX:MetaspaceSize=N, Metaspace= 초기 사이즈 설정.
 * TODO * -XX:MaxMetaspaceSize=N, Metaspace 최대 사이즈 설정.
 */
public class App {
    public static void main(String[] args) {

    }
}
