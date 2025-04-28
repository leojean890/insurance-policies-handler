package com.tinubu.domain.given;

public class InsurancePolicy {
    private Long id;
    private String name;
    private String status;
    private String coverageStartDate;
    private String coverageEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverageStartDate() {
        return coverageStartDate;
    }

    public void setCoverageStartDate(String coverageStartDate) {
        this.coverageStartDate = coverageStartDate;
    }

    public String getCoverageEndDate() {
        return coverageEndDate;
    }

    public void setCoverageEndDate(String coverageEndDate) {
        this.coverageEndDate = coverageEndDate;
    }
}
