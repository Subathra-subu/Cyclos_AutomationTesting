Feature: Krishnaprasath_14/05/2026_Error_Slayers_Cyclos_Receivee Qr Code Functionality 

Background:
         Given the user launches the Cyclos application 
         And the user logs in with valid credentials
         And the user navigates to the QR Code page
         
 @valid
 Scenario: Verify user can generate QR-code with valid amount
         When the user enters a valid amount "100"
         And the user clicks on the generate QR code button
         Then the QR code should be generated successfully

         @blank
         Scenario:  Verify validation message for blank amount field
          When the user enters a valid amount empty
          And the user clicks on the generate QR code button          Then a Field-level validation error message should be displayed
          
     @generate
Scenario: Verify user can generate a new QR code successfully
    When the user enters a valid amount "100"
    And the user clicks on the generate QR code button
    And the user clicks on the Generate New QR Code button
    Then the user should be redirected to the Receive QR Code page


  