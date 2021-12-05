
Feature: Propondo lances

  Scenario: Propondo um unico lance valido

    Given Dado um lance valido

    When Quando propoe o lance
    Then entao o lance eh aceito

