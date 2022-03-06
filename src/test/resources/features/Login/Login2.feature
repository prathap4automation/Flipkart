@regression @Login
Feature: Login feature 2

  Scenario Outline: (1)Validate Login with valid credentials
    Given User launch Flipkart site
    And User enters "<UserName>" for username
    And User enters "<Password>" for password
    When User clicks on Login button
    Then User should be able to login
    Then User logout from application
    Examples:
      | UserName   | Password      |
      | 9885675068 | Pahtarp**5068 |
