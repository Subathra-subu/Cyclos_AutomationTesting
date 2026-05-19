Feature: Krishnaprasath_15/06/2026_Error_Slayers_Cyclos_Payment Request Functionality
    As a user I Should be able to make Payment Requests and Cancel Payment Requests
    
    Background: 
       Given the user Login with valid credentials
       And the user navigates to the Payment Request page
   @validpayment
Scenario: Verify user can make a payment request with valid details
    When the user clicks on the Send a new request button
    And the user enters payment request details
    And the user clicks on the Confirm button
    Then the payment request should be created successfully
    
    @pastDate
Scenario: Verify validation message for past expiration date
    When the user clicks on the "Send a new request" button
    And the user enters payment request details
    And the user clicks on the Confirm button
    Then a validation message should be displayed for past expiration date
    
    @maxLimit
Scenario: Verify warning message when payment amount exceeds maximum limit
    When the user clicks on the "Send a new request" button
    And the user enters payment request details
    And the user clicks on the Confirm button
    Then a warning message should be displayed
    
    @cancel
Scenario: Verify cancel payment request functionality
    When the user selects an existing payment request
    And the user clicks on cancel payment request
    Then the payment request should be cancelled successfully
    
    @print
Scenario: Verify print functionality in payment request details page
    When the user selects an existing payment request
    And the user opens the payment request details page
    And the user clicks on the Print button
    Then the payment request PDF should be generated successfully