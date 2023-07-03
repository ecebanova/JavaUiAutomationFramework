Feature: Register Flow Feature Test Suite

  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And Register Page is accessed from Home Page Menu
    When the Registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the current url contains the following keyword: "account"

  Scenario: User remains on Register Page when continue button is not clicked during register flow
    Given Home Page is accessed
    And Register Page is accessed from Home Page Menu
    When the Registration form is completed with valid random data
    And the privacyToggle is enabled
    Then the current url contains the following keyword: "account"

  @Regression
  Scenario: User remains on Register Page when privacy conditions are not accepted during register flow
    Given Home Page is accessed
    And Register Page is accessed from Home Page Menu
    When the Registration form is completed with valid random data
    And continueButton is clicked
    Then the current url contains the following keyword: "account"

  @run
  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> data
    Given Home Page is accessed
    And Register Page is accessed from Home Page Menu
    And the registration form is completed with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | random      |
      | password  | Random      |
    When continueButton is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!   |
      | <attribute> must be between 1 and 32 characters! |
    Examples:
      | attribute  | firstName                                  | lastName                                   |
      | First Name | hsdbckhsdbchdsvchgsdvchsvbjhcvchsdvchsdvhj | random                                     |
      | Last Name  | random                                     | hsdbckhsdbchdsvchgsdvchsvbjhcvchsdvchsdvhj |