@AdvertisementsFeature
Feature: Akksheetha_2026-05-13_Error_Slayers_Advertisements.feature

Description: This feature is used to verify features of Marketplace Advertisements

  Background:
    Given user is logged into the application
    And user navigates to advertisements page


# 1. SCENARIO OUTLINE
@ValidKeywordSearch
Scenario Outline: Verify keyword search functionality

    When user searches for a valid keyword "<keyword>"
    Then matching advertisements should be displayed

    Examples:
      | keyword |
      | 5 star  |
      | orange    |


# 2. SCENARIO OUTLINE
@InvalidKeywordSearch
Scenario Outline: Verify no result message for invalid keyword search

    When user searches for invalid keyword "<keyword>"
    Then no results message should be displayed

    Examples:
      | keyword |
      | red     |
      | xyz123  |


# 3. NORMAL SCENARIO + EXCEL
@AddToFavourites
Scenario: Verify user can add product to favourites

    When user adds a product to favourites using excel data
    Then product should be added to favourites successfully


# 4. DATATABLE
@ListFavourites
Scenario: Verify user can list out the favourites

    Given user has added below products to favourites
      | product |
      | Laptop  |
      | Bike    |
      | abc     |

    When user navigates to favourites page
    Then favourite products should be displayed


# 5. SCENARIO OUTLINE
@LowestPriceSort
Scenario Outline: Verify product records sorted by lowest price

    When user sorts products using csv data "<sortType>"
    Then products should be displayed in lowest to highest price order

    Examples:
      | sortType     |
      | Lowest Price |


# 6. SCENARIO OUTLINE
@HighestPriceSort
Scenario Outline: Verify product records sorted by highest price

    When user sorts products by "<sortType>"
    Then products should be displayed in highest to lowest price order

    Examples:
      | sortType      |
      | Highest Price |


# 7. SCENARIO OUTLINE
@LatestProducts
Scenario Outline: Verify product records sorted by latest published items

    When user sorts products by "<sortType>"
    Then latest products should be displayed first

    Examples:
      | sortType |
      | Latest   |