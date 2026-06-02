@krishna
Feature: Krishnaprasath_30/05/2026_Error_Slayers_Cyclos_Payment to System Functionality
    Background: Given User launched the Cyclos application
    And User logged in with the  valid credential
    And the user navigates to the Payment to System page
@paynow
Scenario Outline: Verify user can make payment to system with pay now scheduling successfully

    When the user enters valid amount "<amount>"
    And clicks on the Next button
    And the user clicks on the Confirm button
    Then the user should see a confirmation message "The payment was successfully processed"

Examples:
    | amount |
    | 1      |
@invalidAmount
Scenario Outline: Verify validation message for invalid amount inputs

    When the user enters valid amount "<amount>"
    And clicks on the Next button
    Then the user should see a validation error message "<errorMessage>"

Examples:
    | amount | errorMessage        |
    |        | This field is required  |
    
  @scheduledpayment
  Scenario Outline: verify user can perform a scheduled payment
      When the user enters valid amount "<amount>"
      And the user selects the payment method and choose date
    And clicks on the Next button
    And the user clicks on the Confirm button
    Then the user should see a confirmation message "The payment was successfully processed"

Examples:
    | amount |
    | 1      |
     