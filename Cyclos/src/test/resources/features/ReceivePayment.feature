@Akksheetha @ReceivePaymentFeature
Feature: Akksheetha_2026-05-13_Error_Slayers_ReceivePayment

Description : Testing the receive payment feature in Banking

Background:
    Given Registered user launches the Cyclos application
    When User navigates to the Receive Payment page


@ReceivePaymentWithValidDetails
Scenario Outline: Verify scheduled receive payment functionality with confirmation

    And User enters payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the Submit button and confirms the password "<Password>"
    Then Payment should be received successfully

Examples:
    | Name            | Amount | Description             | Password |
    | The Bakery shop | 1      | Monthly payment         | 1234     |
    | The Irish Pub   | 3      | Membership payment      | 1234     |


@ReceivePaymentWithInvalidName
Scenario: Verify error message for blank user field

    And User leaves name field blank and enter only amount detail
    And User clicks on the next button
    Then Appropriate error message for invalid user should be displayed


@ReceivePaymentWithInvalidAmount
Scenario Outline: Verify error message for invalid amount field

    And User enters invalid payment details with "<Name>", "<Amount>" and "<Description>"
    And User clicks on the next button
    Then Appropriate error message for amount should be displayed

Examples:
    | Name            | Amount | Description               |
    | The Bakery shop | 00     | Invalid zero amount       |
    | The Irish Pub   | -1     | Negative payment amount   |


@ReceivePaymentWithBlankDetails
Scenario: Verify error message when mandatory fields are blank

    And User leaves payment fields empty
    And User clicks on the next button
    Then Validation message for mandatory fields should be displayed


@ReceivePaymentExceedMaximumAmount
Scenario: Verify validation message when payment amount exceeds allowed limit

    And User enters exceeded payment details
        | Name            | Amount       | Description                     |
        | The Bakery shop | 999999999999 | Exceeding maximum payment limit |
    And User clicks on the next button
    Then Appropriate validation message for exceeded amount should be displayed