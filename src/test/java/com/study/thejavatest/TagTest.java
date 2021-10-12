package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TagTest {

    @Test
    @DisplayName("Tag 테스트")
    @Tag("fast")
    void tagTest() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("tagTest");
    }
}
