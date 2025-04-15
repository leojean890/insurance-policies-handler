package com.tinubu.domain.service;

import com.tinubu.domain.api.InsurancePolicyService;
import com.tinubu.domain.model.InsurancePolicy;
import com.tinubu.domain.spi.InsurancePoliciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private final InsurancePoliciesRepository repository;

    public InsurancePolicyServiceImpl(InsurancePoliciesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InsurancePolicy> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<InsurancePolicy> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public InsurancePolicy create(InsurancePolicy policy) {
        return repository.save(policy);
    }

    @Override
    public Optional<InsurancePolicy> update(long id, InsurancePolicy newPolicy) {
        return repository.findById(id).map(existing -> {
            InsurancePolicy updated = existing.update(
                    newPolicy.getName(),
                    newPolicy.getStatus(),
                    newPolicy.getCoverageStartDate(),
                    newPolicy.getCoverageEndDate()
            );
            return repository.save(updated);
        });
    }
}

