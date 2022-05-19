package me.whiteship.java8to11;

public class PureFoo {

    public static void main(String[] args) {

        PureRunSomething pureRunSomething = number -> number+10;//함수형 interface

        //함수형 interface가 아니다 baseNumber를 참조하고 있기 때문
        PureRunSomething pureRunSomething1 = new PureRunSomething() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                baseNumber++;//인스턴스 안에 생성한 variable이기 때문에 값 변경 가능
                return number + baseNumber;
            }
        };
        
        //함수형 interface가 아니다 baseNumber를 참조하고 있기 때문
        int baseNumber = 10;
        PureRunSomething pureRunSomething2 = new PureRunSomething() {
            @Override
            public int doIt(int number) {
                //baseNumber++; 인스턴스 밖에서 생성된 variable이기 때문에 final이라고 가정함.
                return number + baseNumber;
            }
        };
        //baseNumber++; 값 변경시 오류

    }
}
