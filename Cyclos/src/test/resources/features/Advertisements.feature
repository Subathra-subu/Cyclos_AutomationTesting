@Akksheetha @AdvertisementsFeature
Feature: Marketplace Advertisements Feature

  Description:
  This feature validates Marketplace Advertisements functionality including search, favourites, sorting and listings.

  Background:
    Given user is logged into the application
    And user navigates to advertisements page


# 1. VALID SEARCH 
@ValidKeywordSearch
Scenario Outline: Verify keyword search functionality in advertisements

    When user searches for keyword "<keyword>"
    Then matching advertisements should be displayed

    Examples:
      | keyword |
      | 5 star  |
      | orange  |


# 2. INVALID SEARCH
@InvalidKeywordSearch
Scenario Outline: Verify no results message for invalid keyword search

    When user searches for keyword "<keyword>"
    Then no results message should be displayed

    Examples:
      | keyword |
      | red     |
      | xyz123  |


# 3. ADD TO FAVOURITES
@AddToFavourites
Scenario: Verify user can add product to favourites

    When user adds product to favourites using test data
    Then product should be added to favourites successfully


# 4. LIST FAVOURITES
@ListFavourites
Scenario: Verify user can list all favourite products

    Given user adds below products to favourites
      | product |
      | Laptop  |
      | Bike    |
      | Mobile  |

    When user navigates to favourites section
    Then all favourite products should be displayed


# 5. SORT - LOWEST PRICE
@LowestPriceSort
Scenario: Verify products sorted by lowest price

    When user sorts products by "Lowest Price"
    Then products should be displayed in ascending price order


# 6. SORT - HIGHEST PRICE
@HighestPriceSort
Scenario: Verify products sorted by highest price

    When user sorts products by "Highest Price"
    Then products should be displayed in descending price order


# 7. SORT - LATEST PRODUCTS
@LatestProducts
Scenario: Verify latest products are displayed first

    When user sorts products by "Latest"
    Then latest products should be displayed at the top