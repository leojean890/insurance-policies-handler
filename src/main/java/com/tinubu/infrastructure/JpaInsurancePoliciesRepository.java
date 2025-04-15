package com.tinubu.infrastructure;

import com.tinubu.infrastructure.entity.InsurancePolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInsurancePoliciesRepository extends JpaRepository<InsurancePolicyEntity, Long> {
}
