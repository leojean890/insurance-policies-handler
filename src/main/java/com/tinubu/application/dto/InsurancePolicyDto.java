package com.tinubu.application.dto;

import java.time.LocalDate;

public class InsurancePolicyDto {
    private Long id;
    private String name;
    private String status;
    private LocalDate coverageStartDate;
    private LocalDate coverageEndDate;
    private LocalDate creationDate;
    private LocalDate updateDate;

    public InsurancePolicyDto(Long id, String name, String status, LocalDate coverageStartDate, LocalDate coverageEndDate,
                              LocalDate creationDate, LocalDate updateDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.coverageStartDate = coverageStartDate;
        this.coverageEndDate = coverageEndDate;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getCoverageStartDate() {
        return coverageStartDate;
    }

    public LocalDate getCoverageEndDate() {
        return coverageEndDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }
}

