@Subathra
Feature: Subathra_25/05/2026_Error_Slayers_Messages
This feature file is used to verify Messages functionality

  Background:
    Given User should be logged into cyclos application and must on home page
    
    
  @MessagesNavigation
  Scenario: Verify user can navigate to Messages page
    When User clicks Message icon
    Then Messages page should be displayed

  @AddNewMessage
  Scenario: Verify user can create new message
  	When User clicks Message icon
    When User clicks on New Message link
    And User enters the required details
    And User clicks on Send button
    Then User should see popup message "The message was successfully sent"

  @SentMessages
  Scenario: Verify user can view Sent messages
  	When User clicks Message icon
    When User clicks on Sent button
    Then User should see Sent messages

  @TrashMessages
  Scenario: Verify user can view Trash messages
  	When User clicks Message icon
    When User clicks on Trash button
    Then User should see Trash messages

