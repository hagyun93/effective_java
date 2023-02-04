package me.whiteship.chapter01.item02.illegalArgumentException;

import java.time.LocalDate;

public class Order {
    /*
        RuntimeException 임에도 Exception 을 throws 하는 경우
            - Client 에게 명시적으로 알려주고 싶을 경우

        다만, 너무 많은 unchecked Exception 이 발생하는 경우에는 모든 것들을 선언하는 것 자체가 코드의 가독성을 떨어트림
        그래서 보통 checked Exception 만을 명시적으로 표시한다.
     */
    public void updateDeliveryDate(LocalDate deliveryDate) throws IllegalArgumentException, NullPointerException {
        if (deliveryDate == null) {
            throw new NullPointerException("deliveryDate can`t be null");
        }

        if (deliveryDate.isBefore(LocalDate.now())) {
            // TODO 과거로 배송 해달라고??
            throw new IllegalArgumentException("deliveryDate can`t be earlier than " + LocalDate.now());
        }

        // 배송 날짜 업데이트
    }
}
