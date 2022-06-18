@smoke
  Feature: Guest User Change Currency to Euro (€)

    Scenario: Guest User Change Currency to Euro
      When guest user change currency to "Euro"

      Then All Product prices will change to be with Euro
