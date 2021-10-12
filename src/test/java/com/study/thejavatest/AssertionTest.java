package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import com.study.thejavatest.domain.StudyStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    @Test
    @DisplayName("assert 테스트")
    void assertEachTest() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("create");

        assertEquals(StudyStatus.DRAFT, study.getStudyStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");

        assertEquals(StudyStatus.DRAFT, study.getStudyStatus(),
                () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");

        assertEquals(StudyStatus.DRAFT, study.getStudyStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "스터디를 처음 만들면 상태값이 DRAFT여야 한다.";
            }
        });

        assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야함", exception.getMessage());

        assertTimeout(Duration.ofSeconds(10), () -> new Study(10));

        assertTimeout(Duration.ofSeconds(10), () -> {
            new Study(10);
            Thread.sleep(1000);
        });

        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            new Study(10);
            Thread.sleep(1000);
        });
    }

    @Test
    @DisplayName("모든 테스트 코드 실행하기")
    void assertAllTest() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("create");

        assertAll(
            () -> assertEquals(StudyStatus.DRAFT, study.getStudyStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),
            () -> assertEquals(StudyStatus.DRAFT, study.getStudyStatus(),
                    () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다."),
            () -> assertEquals(StudyStatus.DRAFT, study.getStudyStatus(), new Supplier<String>() {
                @Override
                public String get() {
                    return "스터디를 처음 만들면 상태값이 DRAFT여야 한다.";
                }
            }),
            () -> assertTrue(study.getLimitCount() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }
}
