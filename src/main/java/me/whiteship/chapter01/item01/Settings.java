package me.whiteship.chapter01.item01;

import java.util.ArrayList;
import java.util.List;

/*
    1. 생성자 대신 정적 팩토리 메서드를 고려하라. ( 장점 )
        - 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다. ( 싱글톤(?) )
    1. 생성자 대신 정적 팩토리 메서드를 고려하라. ( 단점 )
        - 상속을 하기가 어렵다. ( 생성자를 private로 막아논 경우 )
*/

/**
 * 이 클래스이 인스턴스는 #getInstance()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;
    private boolean useABS;
    private Difficulty difficulty;

    // 생성자도 제공하면서 정적 팩토리 메서도도 제공할 수 있다.
    public Settings() {}

    private static final Settings SETTINGS = new Settings();

    public static Settings getInstance() {
        return SETTINGS;
    }

    public static void main(String[] args) {
        // 인스턴스 생성
        List<String> list = new ArrayList<>();
        // 정적 팩토리 메서드 사용
        List.of("hagyun", "whiteship");
    }
}
