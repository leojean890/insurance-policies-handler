package com.tinubu.domain.spi;

import com.tinubu.domain.model.InsurancePolicy;

import java.util.List;
import java.util.Optional;

public interface InsurancePoliciesRepository {
    List<InsurancePolicy> findAll();
    Optional<InsurancePolicy> findById(long id);
    InsurancePolicy save(InsurancePolicy insurancePolicy);
}
