
Feature: Propondo lances ao leilao

  Scenario: Propondo um unico lance valido

    Given Dado um lance valido

    When Quando propoe o lance
    Then entao o lance eh aceito



  Scenario: Propondo varios lances validos

    Given um lance de 10.0 do "ciclano"
    And um lance de 100.0 do "Beltrano"

    When propoe varios lances ao leilao

    Then os lances sao aceito

