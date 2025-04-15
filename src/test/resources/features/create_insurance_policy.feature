Feature: Insurance Policy Creation

  Scenario: Create a new insurance policy
    Given the following insurance policy data:
      | id | name        | status | coverageStartDate | coverageEndDate |
      | 1  | Health Plan | ACTIVE | 2025-01-01        | 2025-12-31      |
    When I send a request to create the insurance policy
    Then the insurance policy should be created with the following data:
      | id | name        | status | coverageStartDate | coverageEndDate |
      | 1  | Health Plan | ACTIVE | 2025-01-01        | 2025-12-31      |
