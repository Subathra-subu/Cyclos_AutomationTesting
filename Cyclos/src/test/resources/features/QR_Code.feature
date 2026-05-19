Feature: Krishnaprasath_14/05/2026_Error_Slayers_Cyclos_Receive QR Code Functionality

Background:
    Given User launches the Cyclos application
    And User logged in with valid credentials
    And the user navigates to the QR Code page


@requiresLogin @valid
Scenario Outline: Verify user can generate QR-code with valid amount
    When the user enters amount "<amount>"
    And the user clicks on the generate QR code button
    Then the QR code should be generated successfully

Examples:
    | amount |
    | 100    |
   


@requiresLogin @blank
Scenario Outline: Verify validation message for invalid or blank amount
    When the user enters amount "<amount>"
    And the user clicks on the generate QR code button
    Then a Field-level validation error message should be displayed

Examples:
    | amount |
    |        |
  


@requiresLogin @generate
Scenario Outline: Verify user can regenerate a new QR code successfully
    When the user enters amount "<amount>"
    And the user clicks on the generate QR code button
    And the user clicks on the Generate New QR Code button
    Then the user should be redirected to the Receive QR Code page

Examples:
    | amount |
    | 100    |