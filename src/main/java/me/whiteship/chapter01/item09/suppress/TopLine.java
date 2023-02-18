package me.whiteship.chapter01.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 코드 9-1 try-finally - 더 이상 자원을 회수하는 최선의 방법이 아니다!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BadBufferedReader(new FileReader(path));

        try {
//            return br.readLine();
        } finally {
            br.close(); // 해당 Exception 만 보인다... 위의 readLine 에서 예외가 발생한 경우 해당 예외는 보이지 않음.
        }

        // try-with-resource 로만 바꾸면 코드도 간결해지며, 모든 Exception 이 보인다!!
        try (BufferedReader br2 = new BadBufferedReader(new FileReader(path))) {
            return br2.readLine();
        } catch (IOException e) {
            // catch block 도 사용 가능! ( finally 도 가능 )
            return path;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfFile("pom.xml"));
    }
}
