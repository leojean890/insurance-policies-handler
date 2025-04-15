package com.tinubu.domain.api;

import com.tinubu.domain.model.InsurancePolicy;

import java.util.List;
import java.util.Optional;

public interface InsurancePolicyService {
    List<InsurancePolicy> getAll();
    Optional<InsurancePolicy> getById(long id);
    InsurancePolicy create(InsurancePolicy policy);
    Optional<InsurancePolicy> update(long id, InsurancePolicy policy);
}
