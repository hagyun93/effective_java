package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

/*
    자원을 직접 명시하지 말고 의존 객체 주입을 사용하라
        - 의존 객체 주입이란 인스턴스를 생성할 때 필요한 자원을 넘겨주는 방식
        - 이 방식의 변형으로 생성자에 자원 팩터리를 넘겨줄 수 있다.
        - 의존 객체 주입을 사용하면 클래스의 유연성, 재사용성, 테스트 용이성을 개선할 수 있다.
 */
public class SpellChecker {

    private final Dictionary dictionary;

    /*
        Supplier<T> interface 는 팩터리를 표현한 완벽한 예
        한정적 와일드 타입을 사용해 팩터리의 타입 매개변수를 제한해야 한다.
     */
    public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isVaild(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
