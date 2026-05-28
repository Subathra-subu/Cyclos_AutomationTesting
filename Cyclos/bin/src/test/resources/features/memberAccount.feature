@SRIRAM
Feature: SRIRAM_K_125/05/2026_Validate the memeber account Functionality

  Background:
    Given the user Login with the valid data
    And the user click the Banking menu
    And the user click the Member Account button

  @pdf
  Scenario: Verify the member account details in PDF
    When user clicks the download button
    And the user clicks the pdf option
    Then the user should see the member account details in PDF format

  @excel
  Scenario: Verify the member account details in Excel
    When user clicks the download button
    And the user clicks the excel option
    Then the user should see the member account details in Excel file
