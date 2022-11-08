package me.whiteship.chapter01.item01;

/*
    1. 생성자 대신 정적 팩토리 메서드를 고려하라.
        - 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다. ( 인터페이스 기반 프레임 워크, 인터페이스에 정적 메소드 )
        - 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다. ( EnumSet )
*/
public interface HelloService {
    String hello();

    // Java 8 이상부터 인터페이스에 static method를 선언할 수 있다.
    static HelloService of (String lang) {
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    // Java 9 이상부터 인터페이스에서 private static method를 선언할 수 있다.
    static private void prepareMessage() {
    }

    static String hi(){
        prepareMessage();
        return "hi";
    }
}
