@PaymentToUser_Shobana
Feature: Shobana_14/05/2026_Error_Slayers_PaymentToUser_Functionality
Description:This feature file is used to verify the payment to user functionality

  Background:
    Given User should be logged into application and must on home page
    When User clicks the payment to user button

  @BlankUserValidation
  Scenario: Verify validation message for blank user field
    When User gives the empty user field ""
    Then User clicks the next button and should validate the error message is displayed

  @PaymentConfirmation
Scenario: Verify Payment Confirmation using pay now functionality
  When User enters payment details
    | username        | amount |
    | Active Walking  | 100    |
  Then User should successfully complete the payment

 @LimitValidation
Scenario Outline: Verify validation message when payment amount exceeds available limit
  And User enters valid user "<username>"
  And User enters amount "<amount>"
  Then User clicks the next button and should validate limit exceeded message "<message>"

Examples:
  | username        | amount | message                                      |
  | Active Walking  | 999999 | Amount must be less or equal to 500,00 IU's. |
  | The Bakery shop | 0.00     | Amount must be a positive number.            |

  @ScheduledPayment
  Scenario: Verify scheduled payment functionality
    When User enters scheduled payment details
      | username       | amount | type      | date       | description       |
      | Active Walking | 150    | Scheduled | 20-05-2026 | Scheduled payment |
    Then User should successfully schedule the payment

  @RecurringPayment
  Scenario: Verify recurring payment scheduling functionality
    When User enters recurring payment details
      | username       | amount | type               | description               |
      | Active Walking | 200    | Recurring payments | Recurring monthly payment |
    Then Recurring payment should be scheduled successfully

  @MonthlyInstallment
  Scenario: Verify user can schedule monthly installment payment
    When User enters monthly installment payment details
      | username       | amount | type                 | installments | description                 |
      | Active Walking | 200    | Monthly installments | 5            | Monthly installment payment |

    Then Monthly installment payment should be scheduled successfully

 