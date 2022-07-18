package com.pch;

import com.pch.component.StringTrimmedComponent;
import com.pch.homework.config.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class StringTrimmingTest {

    static AnnotationConfigApplicationContext context;

    @BeforeAll
    static void beforeAll() {
        context = new AnnotationConfigApplicationContext("com.pch");
    }

    @Test
    void methodWithOneStringArgument() {
        StringTrimmedComponent bean = context.getBean(StringTrimmedComponent.class);
        String hello = bean.hello(" Hello ");
        assertEquals("Hello", hello);
    }


    @Test
    void methodWithTwoStringArguments() {
        StringTrimmedComponent bean = context.getBean(StringTrimmedComponent.class);
        String hello = bean.hello2(" Good ", " Morning ");
        assertEquals("GoodMorning", hello);
    }


    @Test
    void methodWithoutArgumentReturnString() {
        StringTrimmedComponent bean = context.getBean(StringTrimmedComponent.class);
        String bye = bean.bye();
        assertEquals("Good Bye!", bye);
    }

    @Test
    void methodWithoutArgumentReturnStringBuilder() {
        StringTrimmedComponent bean = context.getBean(StringTrimmedComponent.class);
        StringBuilder countStars = bean.countStars();
        assertNotEquals("5", countStars.toString());
        assertEquals("   5   ", countStars.toString());
    }


}
