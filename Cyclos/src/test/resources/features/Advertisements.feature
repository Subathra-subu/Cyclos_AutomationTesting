@AdvertisementsFeature
Feature: Advertisements

Description: This feature is used to verify features of MarketPlace's Advertisements

  Background:
    Given user is logged into the application
    And user navigates to advertisements page
@ValidKeywordSearch
  Scenario Outline: Verify keyword search functionality
    When user searches for "<keyword>"
    Then matching advertisements should be displayed

    Examples:
      | keyword   |
      | 5 star    |

  Scenario Outline: Verify no result message for invalid keyword search
    When user searches for "<invalidKeyword>"
    Then no results message should be displayed
    
    Examples:
      | keyword   |
      | mobile    |
      | laptop    |
    

  Scenario: Verify user can add product to favourites
    When user adds a product to favourites
    Then product should be added to favourites successfully

  Scenario: Verify user can list out the favourites
    Given user has added products to favourites
    When user navigates to favourites page
    Then favourite products should be displayed

  Scenario Outline: Verify product records sorted by lowest price
    When user sorts products by "<sortType>"
    Then products should be displayed in lowest to highest price order

    Examples:
      | sortType     |
      | Lowest Price |

  Scenario Outline: Verify product records sorted by highest price
    When user sorts products by "<sortType>"
    Then products should be displayed in highest to lowest price order

    Examples:
      | sortType      |
      | Highest Price |

  Scenario Outline: Verify product records sorted by latest published items
    When user sorts products by "<sortType>"
    Then latest products should be displayed first

    Examples:
      | sortType |
      | Latest   |