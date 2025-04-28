Feature: Insurance Policy Creation

  Scenario: Create a new insurance policy
    Given the following insurance policy data:
      | id | name        | status | coverageStartDate | coverageEndDate |
      | 1  | Health Plan | ACTIVE | 2025-01-01        | 2025-12-31      |
    When I send a request to create the insurance policy
    Then the insurance policy should be created with the following data:
      | id | name        | status | coverageStartDate | coverageEndDate |
      | 1  | Health Plan | ACTIVE | 2025-01-01        | 2025-12-31      |


  Scenario: View a specific insurance policy by ID
    Given the following insurance policy data:
      | id | name      | status | coverageStartDate | coverageEndDate |
      | 1  | Life Plan | ACTIVE | 2022-01-01        | 2032-01-01      |
    When I send a request to create the insurance policy
    When the client retrieves the policy with id 1
    Then the response should be:
      | id | name      | status  | coverageStartDate | coverageEndDate |
      | 1  | Life Plan | ACTIVE  | 2022-01-01         | 2032-01-01       |


  Scenario: List all existing insurance policies
    Given the following insurance policy data:
      | id | name          | status  | coverageStartDate | coverageEndDate |
      | 1  | Car Policy    | ACTIVE  | 2024-01-01         | 2025-01-01       |
      | 2  | Home Policy   | INACTIVE| 2023-05-01         | 2024-05-01       |

    When I send a request to create the insurance policy
    When the client retrieves all insurance policies
    Then the response should contain the following policies:
      | id | name         | status   | coverageStartDate | coverageEndDate |
      | 1  | Car Policy   | ACTIVE   | 2024-01-01         | 2025-01-01       |
      | 2  | Home Policy  | INACTIVE | 2023-05-01         | 2024-05-01       |


  Scenario: Update an existing insurance policy
    Given the following insurance policy data:
      | id | name          | status  | coverageStartDate | coverageEndDate |
      | 1  | Car Policy    | ACTIVE  | 2024-01-01         | 2025-01-01       |

    When I send a request to create the insurance policy
    When the client updates the policy with id 1 with the following values:
      | name          | status   | coverageStartDate | coverageEndDate |
      | Updated Car   | INACTIVE | 2024-02-01         | 2025-02-01       |

    Then the policy with id 1 should be updated as follows:
      | id | name         | status   | coverageStartDate | coverageEndDate |
      | 1  | Updated Car  | INACTIVE | 2024-02-01         | 2025-02-01       |