@Tickets
Feature: SRIRAM_K_13/05/2026_Validate Ticket Status Filter Functionality

  Background:
    Given user navigates to the tickets page

  @ticketStatus
  Scenario Outline: Verify ticket transactions for different status filters
    When user selects "<status>" from status dropdown
    And user clicks first row of the transactions table
    And user clicks the print button
    Then the user should seen the transaction status "<status>"

    Examples:
      | status      |
      | Not applied |
      | Open        |
      | Canceled    |
      | Processed   |
      
      
	