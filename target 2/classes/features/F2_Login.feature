@smoke
  Feature: User Login to their account
    Background:
      Given User Navigate to Login Page


    # 1st Test Case
    Scenario: User Login with valid Data
      When user enter valid Email "Emma3@AutomationTest.com"
      And user enter valid Password "P@ssword1"
      And user click on Login Button

      Then User Login Successfully


    # 2nd Test Case
    Scenario: User Login with invalid Data
      When user enter invalid Email "invalid@AutomationTest.com"
      And user enter invalid Password "invalidPass"
      And user click on Login Button

      Then User CanNot Login and Fail Message is displayed