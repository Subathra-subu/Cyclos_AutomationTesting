@Shobana
Feature: Shobana_16/05/2026_Error_SlayersBusiness Directory Functionality

  Background:
    Given User logs into the cyclos application for business directory
    When User navigates to business directory page

  Scenario: Verify keyword search functionality using excel
    When User enters keyword from excel
    Then Matching business records should be displayed


Scenario: Verify business directory list view functionality using csv
  When User selects list view option using csv
  Then Business records should display in list view


  Scenario: Verify business directory grid view functionality using data table
    When User selects tiled view option
      | view |
      | tile |
    Then Business records should display in tiled view

  Scenario: Verify ascending order functionality
    When User selects ascending order from orders dropdown
    Then Business records should display in ascending order

  Scenario: Verify descending order functionality
    When User selects descending order from orders dropdown
    Then Business records should display in descending order