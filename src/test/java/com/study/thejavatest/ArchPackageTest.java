package com.study.thejavatest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class ArchPackageTest {

    @Test
    void packageDependencyTest() {
        JavaClasses javaClass = new ClassFileImporter().importPackages("com.study.thejavatest");

        // ..domain.. 패키지에 있는 클래스는 ..study.., ..member.., ..domain에서 참조 가능
        ArchRule domainPackageRule = classes().that().resideInAnyPackage("..domain..")
                .should().onlyBeAccessed().byClassesThat()
                .resideInAnyPackage("..study..", "..member..", "..domain..");
        domainPackageRule.check(javaClass);

        // ..member.. 패키지에 있는 클래스는 ..study..와 ..member..에서만 참조 가능
        ArchRule memberPackageRule1 = classes().that().resideInAnyPackage("..member..")
                .should().onlyBeAccessed().byClassesThat()
                .resideInAnyPackage("..study..", "..member..");
        memberPackageRule1.check(javaClass);

        // (반대로) ..domain.. 패키지는 ..member.. 패키지를 참조하지 못함
        ArchRule memberPackageRule2 = noClasses().that().resideInAPackage("..domain..")
                .should().accessClassesThat().resideInAPackage("..member..");
        memberPackageRule2.check(javaClass);

        // ..study.. 패키지에 있는 클래스는 ..study.. 에서만 참조 가능
        ArchRule studyPackageRule = noClasses().that().resideOutsideOfPackage("..study..")
                .should().accessClassesThat().resideInAPackage("..study..");
        studyPackageRule.check(javaClass);

        // 순환 참조 없어야 함
        ArchRule freeOfCycles = slices().matching("..inflearnthejavatest.(*)..")
                .should().beFreeOfCycles();
        freeOfCycles.check(javaClass);
    }
}
