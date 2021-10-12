package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstanceTest {

    @Test
    @DisplayName("TestInstance 테스트")
    void create() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("create");
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}
