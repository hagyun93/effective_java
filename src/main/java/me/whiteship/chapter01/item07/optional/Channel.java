package me.whiteship.chapter01.item07.optional;

import java.util.Optional;

/**
 * Optional 사용시 주의 할 점
 *  - 리턴값으로만 쓰기를 권장한다. ( 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지 말자. )
 *      - null 로 넘길수 있으며, 어차피 null check 필요.
 *      - Optional 을 리턴하는 메소드에서 null 을 리턴하지 말자 ( optional.empty() )
 *      - 프리미티브 타입용 Optional 이 따로 있다. ( OptionalInt, OptionalLong, ... )
 *      - Collection, Map, Stream Array, Optional 은 Optional 로 감싸지 말자.ㄴ
 */
public class Channel {

    private int numOfSubscribers;

    // null 일 수도 있는 경우에는 return type 을 Optional 로 지정한다.
    public Optional<MemberShip> defaultMemberShip() {
        if (this.numOfSubscribers < 2000) {
//            return null;  // NullPointException 발생 원인이 될 수 있음.
//            throw new IllegalArgumentException();   // 에러를 넘길 수도 있음
            return Optional.empty();
        } else {
            return Optional.of(new MemberShip());
        }
    }
}
