@Subathra
Feature:Subathra_17/05/2026_Error_Slayers_Cyclos_UserRegister

Background:
    Given that the user launches the application
    When the user clicks the Register link
<<<<<<< HEAD
    
=======
  	
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
  	@ExistRegister
  	Scenario: Register with Existing credentials
	When the user enters the already existing Login name
	| name    | loginName |
  	| sham    | Sham123   |
  	And the user clicks next button
  	Then the user should be able to see the "Login name must be unique." message under login name field
  	
  	@BlankRegister
  	Scenario: Register with Blank Field Validation
	When the user leaves the name,loginName and email input field blank
	| name    | loginName |email|
  	|		  |  		  |		|
  	And the user clicks next button
  	Then the user should be able to see the "This field is required" message under the blank fields
  	

  	@MandatoryFieldRegister
  	Scenario: Register with only Mandatory Fields
  	When the user upload profile image
	When the user enters the mandatory credentials and click next button
	| name    | loginName   | email          |password |
  	| Ram     | Ram_Kumar   | ram@yahoo.com  |ram@123 |
  	And the user clicks submit button
  	Then the user should be able to see the "Registration successful" message
  	
