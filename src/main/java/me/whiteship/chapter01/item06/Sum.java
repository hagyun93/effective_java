package me.whiteship.chapter01.item06;

/*
    autoBoxing
        - 원시 타입의 값을 해당하는 wrapper 클래스의 객체로 바꾸는 과정을 의미
        - 자바 컴파일러는 원시 타입이 아래 두 가지 경우에 해당될 때 autoBoxing을 적용한다.
            - 원시타입이 Wrapper 클래스의 타입의 파라미터를 받는 메서드를 통과할 때
            - 원시 타입이 Wrapper 클래스의 변수로 할당될 떼

    unBoxing
        - Wrapper 클래스 타입을 원시 타입으로 변환하는 과정의 의미
            - ex) Integer -> int
        - 자바 컴파일러는 원시타입이 아래 두 가지 경우에 해당될 때 unBoxing을 적용한다.
            - Wrapper 클래스 타입이 원시 타입의 파라미터를 받는 메서드를 통과할 때
            - Wrapper 클래스 타입이 원시 타입의 변수로 할당될 떼
 */
public class Sum {

    private static long sum() {
        Long sum = 0L;
        // autoBoxing 이 반복해서 일어난다. ( 인스턴스가 계속 생김... )
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        long x = sum();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000. + " ms.");
        System.out.println(x);
    }
}
