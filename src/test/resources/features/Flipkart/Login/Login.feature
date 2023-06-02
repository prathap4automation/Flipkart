@regression @Login
Feature: Login feature

  Scenario Outline: (1)Validate Login with valid credentials
    Given User launch site
    Examples:
      | UserName   | Password |
      | 9885675068 | test     |

#  Scenario: (2) Validate user Login and Logout
#    Given User login to website
#    Then User logout from application