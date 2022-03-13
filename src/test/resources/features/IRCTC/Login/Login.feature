Feature: Login Amazon

  Scenario Outline: 1) Launch IRCTC site
    Given user launch IRCTC site using "<URL>"
    And User clears all notifications
    And User click on banner menu
    And User click on Login button
    And User fills username
    And User fills password
    And User enters captcha
    And User click SignIn button
    Examples:
      | URL      |
      | irctcUrl |