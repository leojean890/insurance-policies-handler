package com.tinubu.domain.model;

import java.time.LocalDate;

public class InsurancePolicy {
	private final Long id;
	private final String name;
	private final String status;
	private final LocalDate coverageStartDate;
	private final LocalDate coverageEndDate;
	private final LocalDate creationDate;
	private final LocalDate updateDate;

	public InsurancePolicy(Long id, String name, String status, LocalDate coverageStartDate, LocalDate coverageEndDate,
						   LocalDate creationDate, LocalDate updateDate) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.coverageStartDate = coverageStartDate;
		this.coverageEndDate = coverageEndDate;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
	}

	public InsurancePolicy update(String newName, String newStatus, LocalDate start, LocalDate end) {
		return new InsurancePolicy(
				this.id,
				newName,
				newStatus,
				start,
				end,
				this.creationDate,
				LocalDate.now()
		);
	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getStatus() { return status; }
	public LocalDate getCoverageStartDate() { return coverageStartDate; }
	public LocalDate getCoverageEndDate() { return coverageEndDate; }
	public LocalDate getCreationDate() { return creationDate; }
	public LocalDate getUpdateDate() { return updateDate; }
}
