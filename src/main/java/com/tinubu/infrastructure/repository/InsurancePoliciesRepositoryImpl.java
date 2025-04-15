package com.tinubu.infrastructure.repository;

import com.tinubu.domain.model.InsurancePolicy;
import com.tinubu.domain.spi.InsurancePoliciesRepository;
import com.tinubu.infrastructure.JpaInsurancePoliciesRepository;
import com.tinubu.domain.mapper.InsurancePolicyEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InsurancePoliciesRepositoryImpl implements InsurancePoliciesRepository {

    private final JpaInsurancePoliciesRepository jpaRepository;

    public InsurancePoliciesRepositoryImpl(JpaInsurancePoliciesRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<InsurancePolicy> findAll() {
        return jpaRepository.findAll().stream()
                .map(InsurancePolicyEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InsurancePolicy> findById(long id) {
        return jpaRepository.findById(id)
                .map(InsurancePolicyEntityMapper::toDomain);
    }

    @Override
    public InsurancePolicy save(InsurancePolicy policy) {
        return InsurancePolicyEntityMapper.toDomain(
                jpaRepository.save(InsurancePolicyEntityMapper.toEntity(policy))
        );
    }
}
