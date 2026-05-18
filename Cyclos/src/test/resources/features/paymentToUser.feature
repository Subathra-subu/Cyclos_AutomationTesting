Feature: Shobana_14/05/2026_Error_Slayers_PaymentToUser_Functionality
Description:This feature file is used to verify the payment to user functionality

  Background:
    Given User should be logged into the application and must on home page
    When User clicks the payment to user button
@BlankUserValidation
  Scenario: Verify validation message for blank user field
    When User gives the empty user field ""
    Then User clicks the next button and should validate the error message is displayed
@PaymentConfirmation
Scenario Outline: Verify Payment Confirmation using pay now functionality
And User enters valid user "<username>"
And User enters amount "<amount>"
Then User should successfully complete the payment

Examples:
| username    | amount |
| Active Walking | 100 |
|The Bakery shop | 6,40|

@LimitValidation
Scenario Outline: Verify validation message when payment amount exceeds available limit
And User enters valid user "<username>"
And User enters amount "<amount>"
Then User clicks the next button and should validate limit exceeded message

Examples:
| username    | amount |
| Active Walking  | 999999 |
|The Bakery shop   |  999  |

@ScheduledPayment
Scenario: Verify scheduled payment functionality
When User enters scheduled payment details
| username       | amount | type      | date       | description        |
| Active Walking | 150    | Scheduled | 20-05-2026 | Scheduled payment  |
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