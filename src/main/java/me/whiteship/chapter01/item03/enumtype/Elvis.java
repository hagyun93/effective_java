package me.whiteship.chapter01.item03.enumtype;

import me.whiteship.chapter01.item03.field.IElvis;

/*
    enum 사용한 싱글턴 사용시 리플렉션과 직렬화 역직렬화에 안전하다.
 */
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() { System.out.println("SING"); }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
