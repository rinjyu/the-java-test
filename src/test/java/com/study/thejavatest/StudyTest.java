package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void create() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("create");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
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