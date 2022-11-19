package me.whiteship.chapter01.item01;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/*
    1. 생성자 대신 정적 팩토리 메서드를 고려하라. ( 장점 )
        - 이름을 가질 수 있다. ( 동일한 시그니처의 생성자를 두개 가질 수 없다. )
        - 이름을 통해 다양한 표현이 가능하다.
*/
public class Order {
    private boolean prime;
    private boolean urgent;
    private Product product;

    private OrderStatus orderStatus;

    // primeOrder Static Factory Method
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    // urgentOrder Static Factory Method
    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {
        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);

        /*
            EnumMap
                - Enum 타입만 Key로 사용 가능한 Map ( Key를 제한할 수 있다. )
                - Array를 이용하기 때문에 성능적으로 우수 ( 시간 복잡도 O(1) )
                    - enum의 선언순서를 인덱스로 사용해 배열에 저장하는 방식으로 동작
                - HashTable을 사용하지 않기 때문에 Hashing 과정이 필요 없음 ( 충돌 가능성이 없다. )
                - Null을 키로 넣는 경우 NullPointerException 발생
                - thread-safe 하지 않음
         */
        EnumMap<OrderStatus, String> orderMap = new EnumMap<>(OrderStatus.class);
        orderMap.put(OrderStatus.PREPARING, "PREPARING");
        orderMap.get(OrderStatus.PREPARING);
    }
}
