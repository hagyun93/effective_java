package me.whiteship.chapter01.item01;

import java.util.Optional;
import java.util.ServiceLoader;

/*
    1. 생성자 대신 정적 팩토리 메서드를 고려하라. ( 장점 )
        - 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다. ( 서비스 제공자 프레임워크 )
*/
public class HelloServiceFactory {

    public static void main(String[] args) {
        // DB Driver 선택 등과 같이 유연하게 사용해야될 경우
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });
    }
}
