Feature: Akksheetha_2026-05-13_Error_Slayers_Advertisement.feature

  Description:
  Validate advertisement search functionality in Marketplace.

  Background:
    Given the user login to the cyclos website
    And the user navigates to Marketplace Advertisement module

  @AdvertisementSearch
  Scenario: Search advertisements with valid keywords
    When the user searches advertisements using the following details
      | keyword |
      | orange  |
    Then relevant advertisements should be displayed
    
  @InvalidAdvertisementSearch
Scenario: Verify invalid advertisement keyword search

  When user searches for keyword "xyz123"
  Then no matching advertisements should be displayed
  
  @AddAdvertisementFavourites
  Scenario: Add advertisements to favourites

  When user adds advertisements to favourites using excel data
  Then selected advertisements should be added to favourites
  
  @AdvertisementPriceFilter
Scenario: Verify advertisement filter by price range

  When user filters advertisements with minimum price "10" and maximum price "500"
  Then filtered advertisements should be displayed
  
  @AdvertisementImageFilter
Scenario: Verify advertisements with images filter

  When user filters advertisements with images
  Then advertisements containing images should be displayed
  
  
  @AdvertisementFavouriteFilter
  Scenario: Verify favourite advertisements filter
  When user filters favourite advertisements
  Then only favourite advertisements should be displayed