package com.study.thejavatest;

import org.junit.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

@EnableRuleMigrationSupport
public class StudyJunit4Test {

    @Test
    public void before() {
        System.out.println("before");
    }

    @Test
    public void createTest() {
        System.out.println("createTest");
    }

    @Test
    public void createTest2() {
        System.out.println("createTest2");
    }
}
