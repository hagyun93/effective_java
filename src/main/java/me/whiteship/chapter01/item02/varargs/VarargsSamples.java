package me.whiteship.chapter01.item02.varargs;

import java.util.Arrays;

public class VarargsSamples {

    /*
        가변 인수는 하나만 사용 가능
        여러 파라미터가 있을 경우 가장 마지막에 정의
        빌더 패턴을 사용하면 가변인수를 여러개 사용할 수 있다. ( 각 메소드 별로 가변인수를 정의 )
     */
    public void printNumbers(int... numbers) {
        System.out.println(numbers.getClass().getCanonicalName());
        System.out.println(numbers.getClass().getComponentType());
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void main(String[] args) {
        VarargsSamples samples = new VarargsSamples();
        samples.printNumbers(5, 10);
    }
}
