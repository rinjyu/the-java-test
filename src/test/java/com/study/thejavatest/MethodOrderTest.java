package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {

    @Order(2)
    @Test
    @DisplayName("create 테스트")
    void create() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("create");
    }

    @Order(1)
    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalREpetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/"
                + repetitionInfo.getTotalRepetitions());
    }

    @Order(4)
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @Order(3)
    @ParameterizedTest(name = "{index} {displayName} limit={0}")
    @ValueSource(ints = {10, 20, 40})
    void valueSource(Integer limit) {
        System.out.println(limit);
    }
}
