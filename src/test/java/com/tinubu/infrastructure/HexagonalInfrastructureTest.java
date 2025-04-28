package com.tinubu.infrastructure;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAnyPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class HexagonalInfrastructureTest {
    private static final String REGEX_INFRASTRUCTURE_PACKAGE =
            "com.tinubu.infrastructure..";
    private static final String REGEX_DOMAIN_PACKAGE = "com.tinubu.domain..";
    private static final String[] REGEX_AUTHORIZED_PACKAGE_INFRASTRUCTURE = new String[]{
            REGEX_INFRASTRUCTURE_PACKAGE,
            REGEX_DOMAIN_PACKAGE,
    };

    private static final String[] REGEX_AUTHORIZED_PACKAGE_LIB_LINK_TO_JAVA = new String[]{
            "java..",
            "javax..",
            "org.joda.time..",
            "com.google.common..",
            "org.mockito..",
            "org.junit..",
            //"com.github.tomakehurst.wiremock..",
            "com.google.inject..",
            "org.assertj..",
            "org.slf4j..",
            "org.springframework..",
            "jakarta..",
            "com.tngtech.archunit..",
            "org.apache.commons.lang3..",
            "org.apache.commons.collections..",
            "org.apache.http..",
            "com.fasterxml.jackson..",
            //"com.github.benmanes.caffeine.."
    };

    @Test
    void classes_in_infrastructure_should_depend_only_on_domain_and_infrastructure() {
        var importedClasses = new ClassFileImporter().importPackages(REGEX_INFRASTRUCTURE_PACKAGE);
        var packageResideDepend = Stream.of(
                        REGEX_AUTHORIZED_PACKAGE_INFRASTRUCTURE,
                        REGEX_AUTHORIZED_PACKAGE_LIB_LINK_TO_JAVA
                        )
                .flatMap(Stream::of)
                .toArray(String[]::new);

        classes()
                .that().resideInAPackage(REGEX_INFRASTRUCTURE_PACKAGE)
                .should().onlyDependOnClassesThat(
                        resideInAnyPackage(packageResideDepend)
                ).check(importedClasses);
    }
}
