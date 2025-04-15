package com.tinubu.application.steps;

import com.tinubu.application.given.InsurancePolicy;
import com.tinubu.domain.service.InsurancePolicyServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsurancePolicySteps {
    private com.tinubu.domain.model.InsurancePolicy policyInput;
    private com.tinubu.domain.model.InsurancePolicy createdPolicy;
    @Autowired
    private InsurancePolicyServiceImpl insurancePolicyService;

    @DataTableType
    public InsurancePolicy convert(Map<String, String> entry) {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setId(Long.parseLong(entry.get("id")));
        policy.setName(entry.get("name"));
        policy.setStatus(entry.get("status"));
        policy.setCoverageStartDate(entry.get("coverageStartDate"));
        policy.setCoverageEndDate(entry.get("coverageEndDate"));
        return policy;
    }

    @Given("the following insurance policy data:")
    public void givenInsurancePolicyData(DataTable dataTable) {
        List<InsurancePolicy> policies = dataTable.asList(InsurancePolicy.class);
        var policy = policies.get(0);
        policyInput = new com.tinubu.domain.model.InsurancePolicy(policy.getId(), policy.getName(), policy.getStatus(),
                LocalDate.parse(policy.getCoverageStartDate()),LocalDate.parse(policy.getCoverageEndDate()), LocalDate.now(), LocalDate.now());
    }

    @When("I send a request to create the insurance policy")
    public void whenICreatePolicy() {
        createdPolicy = insurancePolicyService.create(policyInput);
    }

    @Then("the insurance policy should be created with the following data:")
    public void thenInsurancePolicyShouldBeCreated(DataTable expectedTable) {
        List<InsurancePolicy> expectedPolicies = expectedTable.asList(InsurancePolicy.class);
        InsurancePolicy expected = expectedPolicies.get(0);

        assertEquals(expected.getId(), createdPolicy.getId());
        assertEquals(expected.getName(), createdPolicy.getName());
        assertEquals(expected.getStatus(), createdPolicy.getStatus());
        assertEquals(LocalDate.parse(expected.getCoverageStartDate()), createdPolicy.getCoverageStartDate());
        assertEquals(LocalDate.parse(expected.getCoverageEndDate()), createdPolicy.getCoverageEndDate());
    }
}
