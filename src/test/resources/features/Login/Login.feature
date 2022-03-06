@regression @Login
Feature: Login feature

  Scenario Outline: (1)Validate Login with valid credentials
    Given User launch Flipkart site
    And User enters "<UserName>" for username
    And User enters "<Password>" for password
    When User clicks on Login button
    And User should be able to login
#    And User captures screen
    Then User logout from application
    Examples:
      | UserName   | Password      |
      | 9885675068 | Pahtarp**5068 |

  Scenario: (2) Validate user Login and Logout
    Given User login to website
    Then User logout from application