package com.pch.component;

import com.pch.homework.annotation.Trimmed;
import org.springframework.stereotype.Component;


@Trimmed
@Component
public class StringTrimmedComponent {

    private static final String BLANK_SPACE = "   ";

    public String hello(String s) {
        System.out.println("s =" + s);

        return BLANK_SPACE + s + BLANK_SPACE;
    }


    public String hello2(String s, String s2) {
        System.out.println("s =" + s);
        System.out.println("s2 =" + s2);

        return BLANK_SPACE + s + s2 + BLANK_SPACE;
    }

    public String bye() {
        String goodBye = "  Good Bye!  ";

        System.out.println("Bye =" + goodBye);

        return goodBye;
    }

    public StringBuilder countStars() {
        int count = 5;

        System.out.println("Count stars =" + count);

        StringBuilder builder = new StringBuilder();
        return builder.append(BLANK_SPACE).append(5).append(BLANK_SPACE);
    }

}
