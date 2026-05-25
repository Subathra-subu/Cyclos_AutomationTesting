@SRIRAM
Feature: SRIRAM_K_15/05/2026_Advertisements
  Description: Validate Advertisement Functionality

  Background:
    Given the user login with valid credentials
    And the user click the Marketplace menu
    And the user clicks the Advertisement Interests button

  @delete
  Scenario: Delete an Advertisement Interest
    When the user clicks the Delete button
    And the user confirms the deletion popup
    Then the user should see the success message "The item was removed"

  @addNew
  Scenario: Add a New Advertisement Interest
    When the user clicks the Add New button

    And the user enters all required details "<name>" , "<keyWord>" , "<by>" , "min" , "max" and submit it.
    Then the user should see the popup message "The ad interest was created"

    And the user enters all required details "<name>" , "<keyWord>" , "<by>" , "<min>" , "<max>" and submit it.
    Then the user should see AddInterst text

  @withoutName
  Scenario: Add a New Advertisement without Name Fields
    When the user clicks the Add New button
    Then the user enters the details without name fields and should see the "This field is required" message
      | keyWord | By    | min price | max price |
      | test    | sriam | 1         | 12        |
      | ram     | titoo | 1         | 2         |
      | titooo  | ram   | 222       | 345       |
      | sriram  | tioo  | 4         | 66        |