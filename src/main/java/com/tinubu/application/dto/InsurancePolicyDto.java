package com.tinubu.application.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;

@JsonDeserialize(builder = InsurancePolicyDto.Builder.class)
public class InsurancePolicyDto {
    private Long id;
    private String name;
    private String status;
    private LocalDate coverageStartDate;
    private LocalDate coverageEndDate;
    private LocalDate creationDate;
    private LocalDate updateDate;

    private InsurancePolicyDto(Builder builder) {
        id = builder.id;
        name = builder.name;
        status = builder.status;
        coverageStartDate = builder.coverageStartDate;
        coverageEndDate = builder.coverageEndDate;
        creationDate = builder.creationDate;
        updateDate = builder.updateDate;
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

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private Long id;
        private String name;
        private String status;
        private LocalDate coverageStartDate;
        private LocalDate coverageEndDate;
        private LocalDate creationDate;
        private LocalDate updateDate;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Builder coverageStartDate(LocalDate val) {
            coverageStartDate = val;
            return this;
        }

        public Builder coverageEndDate(LocalDate val) {
            coverageEndDate = val;
            return this;
        }

        public Builder creationDate(LocalDate val) {
            creationDate = val;
            return this;
        }

        public Builder updateDate(LocalDate val) {
            updateDate = val;
            return this;
        }

        public InsurancePolicyDto build() {
            return new InsurancePolicyDto(this);
        }
    }
}

