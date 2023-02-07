Feature: User should be able to generate new token

  Scenario: User should input the valid credentials
    Given input valid credentials
    Then verify tokenStatusCode