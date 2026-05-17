Feature:Subathra_14/05/2026_Error_Slayers_Cyclos_UserRegister

Background:
    Given that the user launches the application
    When the user clicks the Register link
    
	@ValidRegister
	Scenario: Register with valid credentials
	When the user enters the valid credentials
    And click submit button
    Then the user should be able to see the dashboard page