package me.whiteship.chapter01.item09.tryfinally;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 코드 9-1 try-finally - 더 이상 자원을 회수하는 최선의 방법이 아니다!
    static String firstLineOfFile(String path) throws IOException {
        // BufferedReade 의 상위 클래스인 Reader 가 Closeable 을 구현하고 있음으로 Close 를 하지 않아도 된다.
        // try 안에 리소스를 정의
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
