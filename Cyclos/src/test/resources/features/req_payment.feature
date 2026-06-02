@krishna
Feature: Krishnaprasath_15/05/2026_Error_Slayers_Cyclos_Payment Request Functionality
    As a user I Should be able to make Payment Requests and Cancel Payment Requests
    
    Background: 
       Given the user has logged in with valid credentials
       And the user navigates to the Payment Request page
   
    @print
    Scenario: Verify print functionality in payment request details page
       When the user selects an existing payment request from the list
       And the user clicks on the print button
       Then a PDF of the payment request should be generated successfully
       
    
    
    @negativeValidation @dateCheck
  Scenario: Verify system validation rule when leaving required payment field expiration date completely empty via Excel
    When the user clicks the Send a new request button
    And the user enters only the name and amount details from excel leaving the date empty
    And clicks the form primary confirm button
    Then the date field should display an error indicator text message saying "This field is required"
    
    @validpaymentrequest @28/06/2026
    Scenario: verify  the user can make a valid payment request
    When the user clicks the Send a new request button
    And the user enters the  