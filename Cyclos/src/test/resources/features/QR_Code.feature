Feature: Krishnaprasath_15/06/2026_Error_Slayers_Cyclos_Payment Request Functionality
    As a user,
    I want to be able to make, view, and cancel payment requests
    So that I can manage my pending transactions efficiently

    Background: 
        Given the user has logged in with valid credentials
        And the user navigates to the Payment Request page

    @print
    Scenario: Verify print functionality in the payment request details page
        When the user selects an existing payment request from the list
        And the user views the details of the selected payment request
        And the user clicks on the print button
        Then a PDF of the payment request should be generated successfully