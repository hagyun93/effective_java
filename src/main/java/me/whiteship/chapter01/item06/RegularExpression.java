package me.whiteship.chapter01.item06;

import java.util.regex.Pattern;

public class RegularExpression {

    // pattern 재사용
    private static final Pattern SPLIT_PATTERN = Pattern.compile(";;;");

    public static void main(String[] args) {
        long start = System.nanoTime();

        for (int j=0; j<10000; j++) {
            String name = "effective,java;;;spring";
            /* fastpath if the regex is a
             (1)one-char String and this character is not one of the
                RegEx's meta characters ".$|()[{^?*+\\", or
             (2)two-char String and the first char is the backslash and
                the second is not the ascii digit or ascii letter.
             */
            name.split(",");
            SPLIT_PATTERN.split(name);
            /*
                match, split, replaceAll, replaceFirst ..
                regex 를 인자로 받는 것들을 재사용 고려
             */
        }

        System.out.println(System.nanoTime() - start);
    }
}
