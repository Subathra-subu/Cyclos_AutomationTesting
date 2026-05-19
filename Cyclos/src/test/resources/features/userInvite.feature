@krishna
Feature: Krishnaprasath_13/05/2026_Error_Slayers_Cyclos_Invite Users Functionality

  Background:
    Given User loads the Cyclos application
    And user logs in to the application with valid credentials
@validInvite
 Scenario Outline: Verify user can invite with valid email
    When User navigates to Invite Users page
    And User enters valid email "<email>"
    And User clicks on submit invite button
    Then Invite should be sent successfully

Examples:
    | email                 |
    | testuser123@gmail.com |

  Scenario Outline: Verify user cannot invite with invalid email
    When User navigates to Invite Users page
    And User enters invalid email "<email>"
    And User clicks on submit invite button
    Then Proper validation message should be displayed

Examples:
    | email      |
    | abc        |
    | test@      |
    | @gmail.com |
    | test@gmail |
    | test.com   |