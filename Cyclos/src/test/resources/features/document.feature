@SRIRAM
Feature: SRIRAM_Document_DownloadAndValidatePDF

  Background:
    Given the user Login with the valid data
    When the user click the personal menu

  Scenario: Download and validate Innovative Approaches to Development PDF
    And the user clicks the Documents menu
    And the user downloads the Innovative Approaches to Development PDF
    Then the PDF should contain the text Innovative Approaches to Development
