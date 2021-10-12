package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomTagTest {

    @FastTest
    @DisplayName("커스텀 태그 테스트")
    void customTagTest() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("tagTest");
    }
}
