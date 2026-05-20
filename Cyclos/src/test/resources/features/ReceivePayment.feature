@Akksheetha @RecievePaymentFeature
Feature: Akksheetha_2026-05-13_Error_Slayers_ReceivePayment.feature

Description : Testing the receive payment feature in Banking

Background:
    Given Registered user launches the Cyclos application
    When User navigates to the Receive Payment page

@ReceivePaymentWithValidDetails
  Scenario Outline: Verify scheduled receive payment functionality with Confirmation

    And User enters payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the Submit button and confirms the password "<Password>"
    Then Payment should be received successfully

    Examples:
      | Name               | Amount | Description            | Password  |
      | The Bakery shop    | 1      | Making a valid Payment | 1234      |
      | The Irish Pub      | 3      | Checking a payment     | 1234      |
      
@ReceivePaymentWithInvalidName
 Scenario: Verify failure message for blank user field
 
    And User leaves name field blank and enter only amount detail 
    And User clicks on the next button
    Then Appropriate error message for invalid user should be displayed

@ReceivePaymentWithInvalidAmount
  Scenario Outline: Verify failure message for blank amount field

    And User enters invalid payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the next button
    Then Appropriate error message for amount should be displayed

    Examples:
      | Name             | Amount | Description               |   
      | The Bakery shop  | 00     | Making an Invalid Payment |
      | The Irish Pub    | 3      | Checking a payment        |


 @ReceivePaymentWithBlankDetails
  Scenario: Verify failure message when both user and amount fields are blank

    And User leaves payment fields empty
    And User clicks on the next button
    Then Validation message for mandatory fields should be displayed

 @ReceivePaymentExceedLimit
  Scenario Outline: Verify  alert message when receive payment amount exceeds maximum limit
    
    And User enters payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the Submit button and confirms the password "<Password>"
    Then the alert message for exceeding limit should be displayed
    
    Examples:
      | Name               | Amount | Description            | Password  |
      | The Bakery shop    | 1      | Making a valid Payment | 1234      |
      | The Irish Pub      | 3      | Checking a payment     | 1234      |
 