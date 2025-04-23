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
        InsurancePolicyEntity entity = new InsurancePolicyEntity();
        entity.setId(policy.getId());
        entity.setName(policy.getName());
        entity.setStatus(policy.getStatus());
        entity.setCoverageStartDate(policy.getCoverageStartDate());
        entity.setCoverageEndDate(policy.getCoverageEndDate());
        entity.setCreationDate(policy.getCreationDate());
        entity.setUpdateDate(policy.getUpdateDate());
        return entity;
    }
}

