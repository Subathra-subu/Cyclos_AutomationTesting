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
       
      @validpaymentrequest  @06/07/2027
    Scenario:	Verify user can make a installment payment request
          When the user clicks the Send a new request button
          And the user selects the receiver from the contact list
          And the user enters the amount and date details
          And the user selects the installment option from sheduling dropdown and enters the installment count
          And the user clicks the form primary confirm button
          And the user clicks on the popup confirm button
          Then the user should see a success confirmation message 
          
    @negativeValidation @dateCheck
  Scenario: Verify system validation rule when leaving required payment field expiration date completely empty
    When the user clicks the Send a new request button
    And the user enters only the name and amount details leaving the date empty
    And clicks the form primary confirm button
    Then the date field should display an error indicator text message saying "This field is required"
    

