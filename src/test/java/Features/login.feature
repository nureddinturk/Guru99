Feature: User can login successfully with email

  @SmokeTest
  Scenario Outline: Positive Test for Login
    Given user is on landing page
    And login page is successfully uploaded
    When user enters <username> and <password>
    Then landing page is populated

    Examples:
      | username   | password |
      | mngr469674 | AhYdUmA  |


  @SmokeTest
  Scenario Outline: Negative Test for Login
    Given user is on landing page
    And login page is successfully uploaded
    When user enters <username> and <password>
    Then landing page is not populated

    Examples:
      | username   | password |
      | wronguser | wrongpass  |