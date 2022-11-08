package me.whiteship.chapter01.item01;

/*
    열거 타입
        - 상수 목록을 담을 수 있는 데이터 타입
        - Type-Safety를 보장
        - 싱글톤 패턴을 구현할 때 사용되기도 한다. ( 하나의 인스턴스만 생성된다. )
 */
public enum OrderStatus {
    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    private int number;

    OrderStatus(int number) {
        this.number = number;
    }

}
