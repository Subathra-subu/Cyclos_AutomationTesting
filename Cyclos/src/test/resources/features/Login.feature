Feature: Subathra_14/05/2026_Error_Slayers_Cyclos_UserLogin

Background:
Given that the user launches the application

@Valid
Scenario: Login with valid credentials

When the user clicks the Login link
When the user enters the valid userName and valid password
And click submit button
Then the user should be able to see the dashboard page
