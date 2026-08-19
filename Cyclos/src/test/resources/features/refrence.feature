@titoo @SRIRAM
Feature: 6/07/2023_SRIRAM_K_reference

	Background:
    Given the user Login with the valid data
    When the user click the personal menu
    And the user clicks the References menu
    
    Scenario: To delete the recived reference
    When the user clicks the received reference
    And the user clicks the delete button
    And the user confirms the deletion
    Then the user should see the reference deleted successfully message