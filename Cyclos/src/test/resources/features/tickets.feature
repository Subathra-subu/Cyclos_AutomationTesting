@Tickets
Feature: Validate Ticket Status Filter Functionality

  Background:
    Given user navigates to the tickets page

  @Smoke @Regression @StatusFilter
  Scenario Outline: Verify ticket transactions for different status filters
    When user selects "<status>" from status dropdown
    And user clicks transaction id "<transactionId>"
    And user clicks the print button
    Then transaction pdf should contain "<transactionId>"
    And transaction status should be "<status>"

    Examples:
      | status      | transactionId   |
      | Not applied | DEM-1207961-NMR |
      | Canceled    | DEM-602535-NMR  |
      | Expired     | DEM-1207764-NMR |
      | Open        | DEM-1207961-NMR |
      | Processed   | DEM-924139-NMR  |
