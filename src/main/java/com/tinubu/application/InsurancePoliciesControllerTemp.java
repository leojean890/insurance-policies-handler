package com.tinubu.application;


import com.tinubu.application.dto.InsurancePolicyDto;
import com.tinubu.application.usecase.InsurancePolicyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurancePolicies")
public class InsurancePoliciesControllerTemp {

	private final InsurancePolicyUseCase useCase;

	@Autowired
	public InsurancePoliciesControllerTemp(InsurancePolicyUseCase useCase) {
		this.useCase = useCase;
	}

	/*@GetMapping
	public ResponseEntity<List<InsurancePolicyDto>> getAll() {
		// 0-29 30-59 start=0, delta=30 .must() .should()
		try {
			List<InsurancePolicyDto> policies = useCase.getAll();
			if (policies.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(policies);
		} catch () {
			return ResponseEntity.internalServerError();
		}
	}*/

	@GetMapping("/{id}")
	public ResponseEntity<InsurancePolicyDto> getById(@PathVariable long id) {
		return useCase.getById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<InsurancePolicyDto> create(@RequestBody InsurancePolicyDto dto) {
		InsurancePolicyDto created = useCase.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@PutMapping("/{id}")
	public ResponseEntity<InsurancePolicyDto> update(@PathVariable long id, @RequestBody InsurancePolicyDto dto) {
		return useCase.update(id, dto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}


