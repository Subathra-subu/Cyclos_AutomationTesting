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
<<<<<<< HEAD
<<<<<<< HEAD
    Then the user should see the success message "The item was removed"

  @addNew
=======
    Then the user should see the success message 

  @addNew @smoke
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
=======
    Then the user should see the success message 

  @addNew @smoke
=======
<<<<<<< HEAD
    Then the user should see the success message "The item was removed"

  @addNew
=======
    Then the user should see the success message 

  @addNew @smoke
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
>>>>>>> ac928fb0fd096f89c22c7e9a7034f81153e5c529
>>>>>>> cde08c1b288603da6135da7bfb22c1e334a31622
  Scenario: Add a New Advertisement Interest
    When the user clicks the Add New button
    And the user enters all required details "<name>" , "<keyWord>" , "<by>" , "<min>" , "<max>" and submit it.
    Then the user should see the popup message

  @withoutName
  Scenario: Add a New Advertisement without Name Fields
    When the user clicks the Add New button
    Then the user enters the details without name fields and should see the "This field is required" message
      | keyWord | By    | min price | max price |
      | test    | sriam | 1         | 12        |
      | ram     | titoo | 1         | 2         |
      | titooo  | ram   | 222       | 345       |
      | sriram  | tioo  | 4         | 66        |
