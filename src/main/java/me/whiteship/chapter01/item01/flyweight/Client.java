package me.whiteship.chapter01.item01.flyweight;

public class Client {

    /*
        Flyweight ( 가벼운 체급 )
        - 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴.
        - 자주 변하는 속성 ( 또는 외적인 속성 ) 과 변하지 않는 속성 ( 또는 내적인 속성 ) 을 분리하고 재사용하여 메모리 사용을 줄일 수 있다.
     */
    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));
    }
}
