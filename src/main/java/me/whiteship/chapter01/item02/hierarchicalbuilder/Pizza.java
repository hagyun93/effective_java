package me.whiteship.chapter01.item02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/*
    계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴
 */
public abstract class Pizza {

    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            // self를 사용하여 형변환을 최소화할 수 있으며, 상속 받은 하위클래스의 메소드를 사용할 수 있다.
            return self();
        }
        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding) 하여
        // "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }

    Pizza(Builder<?> builder) { toppings = builder.toppings.clone(); };
}
