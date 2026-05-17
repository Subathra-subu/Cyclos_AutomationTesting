@Tickets
Feature: SRIRAM_K_13/05/2026_Validate Ticket Status Filter Functionality

  Background:
    Given user in the Tickets Page

  @ticketStatus
  Scenario Outline: Verify ticket transactions for different status filters
    When user selects "<status>" from status dropdown
    And user clicks first row of the transactions table
    And user clicks the print button
    Then the user should seen the transaction status "<status>"

    Examples:
      | status      |
      | Approved    |
      | Open        |
      | Expired     |
      | Processed   |
      | Not applied |
      | Canceled    |

  @Filter
  Scenario: Verify ticket transactions filter options works properly
    When user clicks on the filter link
    And user clicks on the status filter dropdown
    And user select the Open in the status
    Then the user should see the transactions with "Open" status
