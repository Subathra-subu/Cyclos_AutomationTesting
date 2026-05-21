@Subathra
Feature: Subathra_18/05/2026_Error_Slayers_My Advertisements

This feature file is used to verify Advertisement functionality

  Background:
    Given User should be logged into cyclos application and must on home page
    When User clicks Marketplace menu
    And  User clicks Advertisement menu

  @AddAdvertisement
  Scenario: Verify user can add new Advertisement
    When User clicks add new button and enters advertisement details
      | title     | category | price | fromDate   | toDate     | description         |
      | race bike | Politics | 100   | 18-05-2026 | 18-05-2029 | Bike for sale offer |
    Then User should successfully add advertisement

  @EditAdvertisement
  Scenario: Verify user can Edit Advertisement
    When User searches advertisement mentioned in the CSV file
    When the user click the advertisement
    And User click the edit button and edits advertisement details
      | title          | category | price | description                |
      | race bike 		| Politics | 200   | Updated bike advertisement |
    Then User should successfully update advertisement

  @RemoveAdvertisement
  Scenario: Verify user can remove Advertisement
    When User searches advertisement mentioned in the CSV file
    When the user click the advertisement 
    And User clicks remove advertisement
    Then User validates remove confirmation popup
    And User confirms advertisement removal