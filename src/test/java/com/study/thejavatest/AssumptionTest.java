package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTest {

    @Test
    @DisplayName("assumeTest")
    void assumeTest() {
        String testEnv = System.getenv("TEST_ENV");
        System.out.println(testEnv);
        assumeTrue("LOCAL".equals(testEnv));

        assumingThat("LOCAL".equalsIgnoreCase(testEnv), () -> {
            Study study = new Study(100);
            assertThat(study.getLimitCount()).isGreaterThan(0);
        });
    }

    @Test
    @DisplayName("enabledOnOSTest")
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    void enabledOnOSTest() {
        String testEnv = System.getenv("TEST_ENV");
        System.out.println(testEnv);
        assumeTrue("LOCAL".equals(testEnv));
    }

    @Test
    @DisplayName("enabledOnJreTest")
    @EnabledOnJre({JRE.JAVA_9, JRE.JAVA_11})
    void enabledOnJreTest() {
        String testEnv = System.getenv("TEST_ENV");
        System.out.println(testEnv);
        assumeTrue("LOCAL".equals(testEnv));
    }

    @Test
    @DisplayName("enabledSystemPropertyTest")
    @EnabledIfSystemProperty(named = "TEST_ENV", matches = "LOCAL")
    void enabledSystemPropertyTest() {
        String testEnv = System.getenv("TEST_ENV");
        System.out.println(testEnv);
        assumeTrue("LOCAL".equals(testEnv));
    }

    @Test
    @DisplayName("enabledEnvVariableTest")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void enabledEnvVariableTest() {
        String testEnv = System.getenv("TEST_ENV");
        System.out.println(testEnv);
        assumeTrue("LOCAL".equals(testEnv));
    }
}
