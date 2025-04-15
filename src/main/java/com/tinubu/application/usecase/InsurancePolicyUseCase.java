package com.tinubu.application.usecase;

import com.tinubu.application.dto.InsurancePolicyDto;
import com.tinubu.application.mapper.InsurancePolicyMapper;
import com.tinubu.domain.api.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class InsurancePolicyUseCase {

    private final InsurancePolicyService service;

    @Autowired
    public InsurancePolicyUseCase(InsurancePolicyService service) {
        this.service = service;
    }

    public List<InsurancePolicyDto> getAll() {
        return service.getAll().stream()
                .map(InsurancePolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<InsurancePolicyDto> getById(long id) {
        return service.getById(id).map(InsurancePolicyMapper::toDTO);
    }

    public InsurancePolicyDto create(InsurancePolicyDto dto) {
        return InsurancePolicyMapper.toDTO(service.create(InsurancePolicyMapper.toDomain(dto)));
    }

    public Optional<InsurancePolicyDto> update(long id, InsurancePolicyDto dto) {
        return service.update(id, InsurancePolicyMapper.toDomain(dto))
                .map(InsurancePolicyMapper::toDTO);
    }
}

