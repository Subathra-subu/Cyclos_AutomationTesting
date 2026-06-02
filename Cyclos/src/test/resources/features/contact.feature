@SRIRAM
Feature: SRIRAM_K_1/06/2026_CONTACT
  Description: Validate Contact Functionality

  Background:
    Given the user login with valid credentials
    When the user click the person menu
    And the user clicks the contact button

  @requireFiled
  Scenario Outline: Validate Required Fields in Contact Form
    When the user clicks the Add new button
    And the user enters the contact "<search>"
    And the user submits the form
    Then the user should see the "<field>"

    Examples:
    
      | search | field                  |
      |        | This field is required |
      
   @listView
   Scenario: to verify the contact list view
     When the user clicks the contact list view button
     Then the user should see the contact list view page with a user message
     
     
