Feature: Shobana_14/05/2026_Error_Slayers_PaymentToUser_Functionality
Description:This feature file is used to verify the payment to user functionality
Background:
Given User should be logged into the application and must on home page
Scenario:  Verify validation message for blank user field
When User clicks the payment to user button
When User gives the empty user field ""
Then User clicks the next button and should validate the error message is displayed


