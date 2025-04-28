package com.tinubu.application;


import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAnyPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class HexagonalApplicationTest {
    private static final String REGEX_INFRASTRUCTURE_PACKAGE =
            "com.tinubu.infrastructure..";
    private static final String REGEX_DOMAIN_PACKAGE = "com.tinubu.domain..";
    private static final String REGEX_APPLICATION_PACKAGE = "com.tinubu.application..";
    //private static final String REGEX_ARCHITECTURE_ANNOTATION_PACKAGE = "com.tinubu.architecture..";
    @Test
    void classes_in_application_should_depend_only_on_domain_and_application() {
        var packageResideDepend = Stream.of(
                        new String[] {
                                REGEX_APPLICATION_PACKAGE,
                                REGEX_INFRASTRUCTURE_PACKAGE,
                                REGEX_DOMAIN_PACKAGE
                        },
                        new String[] {
                                "java..",
                                "javax..",
                                "com.google.common..",
                                "com.tngtech.archunit..",
                                "org.mockito..",
                                "org.springframework..",
                                "org.junit..",
                                "org.assertj..",
                                "com.fasterxml.jackson..",
                                "org.apache.commons.lang3..",
                                "org.joda.time..",
                        })
                .flatMap(Stream::of)
                .toArray(String[]::new);

        var importedClasses = new ClassFileImporter().importPackages(REGEX_APPLICATION_PACKAGE);
        classes()
                .that().resideInAPackage(REGEX_APPLICATION_PACKAGE)
                .should().onlyDependOnClassesThat(resideInAnyPackage(packageResideDepend))
                .check(importedClasses);
    }
}
