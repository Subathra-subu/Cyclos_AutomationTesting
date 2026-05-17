Feature: Shobana_16/05/2026_Error_SlayersBusiness Directory Functionality

Background:
Given User logs into the cyclos application for business directory
When User navigates to business directory page

@KeywordSearch
Scenario Outline: Verify keyword search functionality

When User enters keyword "<keyword>"
Then Matching business records should be displayed

Examples:
| keyword |
| pool    |



@ListView
Scenario: Verify business directory list view functionality

When User clicks on list view option
Then Business records should display in list view

@TiledView
Scenario: Verify business directory tiled view functionality

When User clicks on tiled view option
Then Business records should display in tiled view

@AscendingOrder
Scenario: Verify ascending order functionality

When User selects ascending order from orders dropdown
Then Business records should display in ascending order

@DescendingOrder
Scenario: Verify descending order functionality

When User selects descending order from orders dropdown
Then Business records should display in descending order