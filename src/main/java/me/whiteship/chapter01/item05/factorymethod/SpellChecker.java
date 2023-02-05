package me.whiteship.chapter01.item05.factorymethod;

import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;

public class SpellChecker {

    private Dictionary dictionary;

    /*
        팩토리 메서드 패턴
         - 구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다.
         - 새로운 Product를 제공하는 팩토리를 추가하더라도, 팩토리를 사용하는 클라이언트 코드는 변경할 필요가 없다.
     */
    public SpellChecker(DicrionaryFactory dicrionaryFactory) {
        this.dictionary = dicrionaryFactory.getDictonary();
    }

    public boolean isVaild(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
