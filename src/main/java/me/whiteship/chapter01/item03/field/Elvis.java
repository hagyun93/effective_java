package me.whiteship.chapter01.item03.field;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴
public class Elvis implements IElvis, Serializable {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();

    private static boolean created;

    private Elvis() {
        if (created) {
            throw new UnsupportedOperationException("can`t be created by constructor");
        }
        created = true;
    }

    public void leaveTheBuilding() {
        System.out.println("WHoa baby, I`m outta here!");
    }

    public void sing() {
        System.out.println("I`ll have a blue~ Christmas without you~");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
        elvis.sing();
    }

    // @Override
    // 역직렬화시 해당 메소드가 사용된다. 오버라이딩은 아니지만 오버라이딩 처럼 동작..?
    private Object readResolve() {
        return INSTANCE;
    }
}
