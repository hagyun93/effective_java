package me.whiteship.chapter01.item05.springioc;

import me.whiteship.chapter01.item05.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 스프링 IOC
 *
 * Inversion of Control - 뒤집힌 제어권
 *  - 자기 코드에 대한 제어권을 자기 자신이 가지고 있지 않고 외부에서 제거하는 경우
 *  - 제어권?
 *      - 인스턴스를 만들거나, 어떤 메소드를 실행하거나, 필요로하는 의존성을 주입 받는 등...
 *
 * 스프링 Ioc 컨테이너 사용 장점
 *  - 수많은 개발자에게 검증되었으며 자바 표준 스펙(@Inject)도 지원한다.
 *  - 손쉽게 싱글톤 Scope을 사용할 수 있다.
 *  - 객체 생성 (Bean) 관련 라이클사이클 인터페이스를 제공한다.
 */
@Component
public class SpellChecker {

    private Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isVaild(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
