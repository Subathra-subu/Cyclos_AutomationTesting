Feature: Akksheetha_2026-05-13_Error_Slayers_ReceivePayment.feature

Background:
    Given Registered user launches the Cyclos application
    When User logs in with valid credentials
    And User navigates to the Receive Payment page

@ReceivePaymentWithValidDetails
  Scenario Outline: Verify successful payment reception with valid details

    And User enters payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the Submit button and confirms the password "<Password>"
    Then Payment should be received successfully

    Examples:
      | Name               | Amount | Description            | Password  |
      | The Bakery shop    | 1      | Making a valid Payment | 1234      |

  Scenario Outline: Verify payment reception with invalid details

    And User enters invalid payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the Submit button
    Then Appropriate error message should be displayed

    Examples:
      | Name             | Amount | Description               |   
      | The Bakery shop  | -100   | Making an Invalid Payment |


  @Regression @Validation
  Scenario Outline: Verify validation messages for mandatory fields

    And User leaves payment fields empty
    And User clicks on the Submit button
    Then Validation message for mandatory fields should be displayed