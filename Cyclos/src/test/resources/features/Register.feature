<<<<<<< HEAD
@Register_Subathra
=======
@Subathra
>>>>>>> 3845aa8a9d87ed016a2cd6300ed0b14c1b6c7a5f
Feature:Subathra_17/05/2026_Error_Slayers_Cyclos_UserRegister

Background:
    Given that the user launches the application
    When the user clicks the Register link
    
<<<<<<< HEAD
	@ValidRegister
	Scenario: Register with valid credentials
	When the user upload profile image
	When the user enters the valid credentials and click next button
	| name    | loginName | email          | website     | mobile         | landline       | address   | zip   | city    | region    | password |
  	| John    | John_Doe  | john@yahoo.com | www.test.com| +91 9876543219 | (201)555-0123  | Chennai   | 636001| Chennai | TamilNadu | john@123 |
  	And the user clicks submit button
  	Then the user should be able to see the "Registration successful" message
  	
=======
>>>>>>> 3845aa8a9d87ed016a2cd6300ed0b14c1b6c7a5f
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
  	
