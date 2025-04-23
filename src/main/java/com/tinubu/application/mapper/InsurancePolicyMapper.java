package com.tinubu.application.mapper;

import com.tinubu.domain.model.InsurancePolicy;
import com.tinubu.application.dto.InsurancePolicyDto;

import java.time.LocalDate;

public class InsurancePolicyMapper {

    public static InsurancePolicyDto toDTO(InsurancePolicy policy) {
        return InsurancePolicyDto.builder()
                .id(policy.getId())
                .name(policy.getName())
                .status(policy.getStatus())
                .creationDate(policy.getCreationDate())
                .coverageStartDate(policy.getCoverageStartDate())
                .coverageEndDate(policy.getCoverageEndDate())
                .updateDate(policy.getUpdateDate())
                .build();
    }

    public static InsurancePolicy toDomain(InsurancePolicyDto dto) {
        return new InsurancePolicy(
                dto.getId(),
                dto.getName(),
                dto.getStatus(),
                dto.getCoverageStartDate(),
                dto.getCoverageEndDate(),
                dto.getCreationDate() != null ? dto.getCreationDate() : LocalDate.now(),
                dto.getUpdateDate() != null ? dto.getUpdateDate() : LocalDate.now()
        );
    }
}

