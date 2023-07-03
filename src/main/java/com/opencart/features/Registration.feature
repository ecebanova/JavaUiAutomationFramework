Feature: Register Flow Feature Test Suite

  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And Register Page is accessed from Home Page Menu
    When the Registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "success" keyword

  Scenario: User remains on Register Page when continue button is not clicked during register flow
    Given Home Page is accessed
    And Register Page is accessed from Home Page Menu
    When the Registration form is completed with valid random data
    And the privacyToggle is enabled
    Then the new page url contains "register" keyword