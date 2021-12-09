
Feature: Propondo lances ao leilao

  Scenario: Propondo um unico lance valido

    Given Dado um lance valido

    When Quando propoe o lance
    Then entao o lance eh aceito



  Scenario: Propondo varios lances validos

    Given um lance de 10.0 do "ciclano"
    And um lance de 100.0 do "Beltrano"

    When propoe varios lances ao leilao

    Then os lances sao aceitos


  Scenario Template: Propondo lance invalido
    Given um lance invalido de <valor> reais do usuario '<nomeusuario>'
    When Quando propoe o lance
    Then o lacne nao eh aceito
    Examples:
        |valor|nomeusuario|
        | 0    |"fulano"  |
        | -1    |"beltrano"|




  Scenario: Propondo uma sequencia de lances
    Given um lance de 10.0 reais do usuario "fulano"
    And um lance de 15.0 reais do usuario "fulano"
    When propoe varios lances ao leilao
    Then o segundo lance nao eh aceito


  Scenario: Propondo uma sequencia de lances v2
    Given dois lances
      |valor|nomeusuario|
      | 10   |"fulano"  |
      | 15    |"fulano"|
    When propoe varios lances ao leilao
    Then o segundo lance nao eh aceito