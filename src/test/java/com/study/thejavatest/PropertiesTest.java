package com.study.thejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PropertiesTest {

    int value = 1;

    @Order(2)
    @Test
    @DisplayName("첫번째 properties 테스트")
    void propertiesTest1() {
        System.out.println(value++);
    }

    @Order(1)
    @Test
    @DisplayName("두번째 properties 테스트")
    void propertiesTest2() {
        System.out.println(value++);
    }
}
