@krishna
Feature: Krishnaprasath_15/06/2026_Error_Slayers_Cyclos_Payment Request Functionality
    As a user I Should be able to make Payment Requests and Cancel Payment Requests
    
    Background: 
       Given the user has logged in with valid credentials
       And the user navigates to the Payment Request page
   
    @print
    Scenario: Verify print functionality in payment request details page
       When the user selects an existing payment request from the list
       And the user clicks on the print button
       Then a PDF of the payment request should be generated successfully