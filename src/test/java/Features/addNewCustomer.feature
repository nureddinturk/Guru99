Feature: user can add a new customer

  Background:
    Given user is on landing page
    And login page is successfully uploaded


    @RegressionTest
  Scenario Outline: navigate to the customer entry page
    Given user enters <username> and <password>
    When user clicks on new customer button
    Then verify that user is on New Customer Entry Page

    Examples:
      | username   | password |
      | mngr469674 | AhYdUmA  |

  @RegressionTest
  Scenario Outline: enter new customer
    Given user enters <username> and <password>
    And user clicks on new customer button
    When user enters new customer info
    Then  new customer is added successfully

    Examples:
      | username   | password |
      | mngr469674 | AhYdUmA  |