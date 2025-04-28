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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsurancePolicySteps {
    private List<com.tinubu.domain.model.InsurancePolicy> policyInput = new ArrayList<>();
    private List<com.tinubu.domain.model.InsurancePolicy> createdPolicy;
    private com.tinubu.domain.model.InsurancePolicy updatedPolicy;
    private List<com.tinubu.domain.model.InsurancePolicy> retrievedPolicies;
    private com.tinubu.domain.model.InsurancePolicy retrievedSinglePolicy;

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
        policyInput = policies.stream()
                .map(policy -> new com.tinubu.domain.model.InsurancePolicy(
                        policy.getId(), policy.getName(), policy.getStatus(),
                        LocalDate.parse(policy.getCoverageStartDate()),
                        LocalDate.parse(policy.getCoverageEndDate()),
                        LocalDate.now(), LocalDate.now()))
                .collect(Collectors.toList());
    }

    @When("I send a request to create the insurance policy")
    public void whenICreatePolicy() {
        createdPolicy = policyInput.stream().map(policy -> insurancePolicyService.create(policy))
                .collect(Collectors.toList());
    }

    @Then("the insurance policy should be created with the following data:")
    public void thenInsurancePolicyShouldBeCreated(DataTable expectedTable) {
        List<InsurancePolicy> expectedPolicies = expectedTable.asList(InsurancePolicy.class);
        InsurancePolicy expected = expectedPolicies.get(0);
        var created = createdPolicy.get(0);

        assertEquals(expected.getId(), created.getId());
        assertEquals(expected.getName(), created.getName());
        assertEquals(expected.getStatus(), created.getStatus());
        assertEquals(LocalDate.parse(expected.getCoverageStartDate()), created.getCoverageStartDate());
        assertEquals(LocalDate.parse(expected.getCoverageEndDate()), created.getCoverageEndDate());
    }

    // 🔁 Update
    @When("the client updates the policy with id {long} with the following values:")
    public void theClientUpdatesPolicy(Long id, DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps().get(0);
        com.tinubu.domain.model.InsurancePolicy toUpdate = new com.tinubu.domain.model.InsurancePolicy(
                id,
                row.get("name"),
                row.get("status"),
                LocalDate.parse(row.get("coverageStartDate")),
                LocalDate.parse(row.get("coverageEndDate")),
                LocalDate.now(),
                LocalDate.now()
        );
        updatedPolicy = insurancePolicyService.update(id, toUpdate).orElse(null);
    }

    @Then("the policy with id {long} should be updated as follows:")
    public void thenPolicyShouldBeUpdated(Long id, DataTable expectedTable) {
        InsurancePolicy expected = expectedTable.asList(InsurancePolicy.class).get(0);

        assertEquals(expected.getId(), updatedPolicy.getId());
        assertEquals(expected.getName(), updatedPolicy.getName());
        assertEquals(expected.getStatus(), updatedPolicy.getStatus());
        assertEquals(LocalDate.parse(expected.getCoverageStartDate()), updatedPolicy.getCoverageStartDate());
        assertEquals(LocalDate.parse(expected.getCoverageEndDate()), updatedPolicy.getCoverageEndDate());
    }

    // 📋 List
    @When("the client retrieves all insurance policies")
    public void clientRetrievesAllPolicies() {
        retrievedPolicies = insurancePolicyService.getAll();
    }

    @Then("the response should contain the following policies:")
    public void thenResponseShouldContainPolicies(DataTable expectedTable) {
        List<InsurancePolicy> expectedPolicies = expectedTable.asList(InsurancePolicy.class);

        for (InsurancePolicy expected : expectedPolicies) {
            boolean found = retrievedPolicies.stream().anyMatch(actual ->
                    actual.getId().equals(expected.getId()) &&
                            actual.getName().equals(expected.getName()) &&
                            actual.getStatus().equals(expected.getStatus()) &&
                            actual.getCoverageStartDate().equals(LocalDate.parse(expected.getCoverageStartDate())) &&
                            actual.getCoverageEndDate().equals(LocalDate.parse(expected.getCoverageEndDate()))
            );
            assertTrue(found, "Expected policy not found: " + expected.getId());
        }
    }

    // 🔍 Single read
    @When("the client retrieves the policy with id {long}")
    public void clientRetrievesSinglePolicy(Long id) {
        retrievedSinglePolicy = insurancePolicyService.getById(id).orElse(null);
    }

    @Then("the response should be:")
    public void thenSingleResponseShouldBe(DataTable expectedTable) {
        InsurancePolicy expected = expectedTable.asList(InsurancePolicy.class).get(0);

        assertEquals(expected.getId(), retrievedSinglePolicy.getId());
        assertEquals(expected.getName(), retrievedSinglePolicy.getName());
        assertEquals(expected.getStatus(), retrievedSinglePolicy.getStatus());
        assertEquals(LocalDate.parse(expected.getCoverageStartDate()), retrievedSinglePolicy.getCoverageStartDate());
        assertEquals(LocalDate.parse(expected.getCoverageEndDate()), retrievedSinglePolicy.getCoverageEndDate());
    }
}
