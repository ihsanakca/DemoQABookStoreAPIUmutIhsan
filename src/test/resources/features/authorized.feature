Feature: Authorized

  Scenario: User should be able to authorized
    Given User should be authorized with valid credentials
    Then verify authorizedStatusCode
