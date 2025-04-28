package com.tinubu.domain;


import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAnyPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

class HexagonalDomainTest {
    @Test
    void classes_in_domain_should_depend_only_on_domain() {
        final String domainPackage = "com.tinubu.domain..";
        var importedClasses = new ClassFileImporter().importPackages(domainPackage);

        var rule = classes()
                .that().resideInAPackage(domainPackage)
                .should().onlyDependOnClassesThat(
                        resideInAnyPackage(domainPackage,
                                "java..",
                                "javax..",
                                "org.mockito..",
                                "com.google.common..",
                                "io.cucumber..",
                                "org.springframework..",
                                "org.apache.commons..",
                                domainPackage,
                                "com.tngtech.archunit..",
                                "org.apache.commons.lang3",
                                "org.junit..",
                                "org.assertj.."));

        rule.check(importedClasses);
    }
}







