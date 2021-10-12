package com.study.thejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FindSlowExtendWithTestExtension.class)
public class ExtensionWithTest {

    int value = 1;

    @FastTest
    @DisplayName("fastTest")
    void fastTest() {
        System.out.println(this);
        System.out.println("fastTest" + value++);
    }

    @SlowTest
    @DisplayName("slowTest")
    void slowTest() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println(this);
        System.out.println("slowTest" + value++);
    }

    @Test
    @DisplayName("test")
    void test() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println(this);
        System.out.println("slowTest" + value++);
    }
}
