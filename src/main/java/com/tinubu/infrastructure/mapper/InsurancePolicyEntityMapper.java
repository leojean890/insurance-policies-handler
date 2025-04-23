package com.tinubu.infrastructure.mapper;

import com.tinubu.domain.model.InsurancePolicy;
import com.tinubu.infrastructure.entity.InsurancePolicyEntity;

public class InsurancePolicyEntityMapper {

    public static InsurancePolicy toDomain(InsurancePolicyEntity entity) {
        return new InsurancePolicy(
                entity.getId(),
                entity.getName(),
                entity.getStatus(),
                entity.getCoverageStartDate(),
                entity.getCoverageEndDate(),
                entity.getCreationDate(),
                entity.getUpdateDate()
        );
    }

    public static InsurancePolicyEntity toEntity(InsurancePolicy policy) {
        return InsurancePolicyEntity.builder()
                .id(policy.getId())
                .name(policy.getName())
                .status(policy.getStatus())
                .coverageStartDate(policy.getCoverageStartDate())
                .coverageEndDate(policy.getCoverageEndDate())
                .creationDate(policy.getCreationDate())
                .updateDate(policy.getUpdateDate())
                .build();
    }
}

