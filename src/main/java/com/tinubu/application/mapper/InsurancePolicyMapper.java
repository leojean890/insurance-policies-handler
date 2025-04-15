package com.tinubu.application.mapper;

import com.tinubu.domain.model.InsurancePolicy;
import com.tinubu.application.dto.InsurancePolicyDto;

import java.time.LocalDate;

public class InsurancePolicyMapper {

    public static InsurancePolicyDto toDTO(InsurancePolicy policy) {
        return new InsurancePolicyDto(
                policy.getId(),
                policy.getName(),
                policy.getStatus(),
                policy.getCoverageStartDate(),
                policy.getCoverageEndDate(),
                policy.getCreationDate(),
                policy.getUpdateDate()
        );
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

