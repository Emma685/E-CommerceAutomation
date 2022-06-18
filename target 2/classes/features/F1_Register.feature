@smoke
Feature: Guest User Register new account Successfully

  Scenario: Guest User Sign Up New account

  Given Guest User Navigate to Register Page
    When User choose Gender "Female"
    And user enter first name "Automation" and last name "Testing"
    And user enter Date of Birth "15"-"May"-"1990"
    And user enter Email "Emma3@AutomationTest.com"
    And user enter password "P@ssword1"
    And User Confirm password "P@ssword1"
    And user click on Register Button

    Then Success Message is displayed

