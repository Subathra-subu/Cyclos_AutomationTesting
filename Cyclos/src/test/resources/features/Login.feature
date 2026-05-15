Feature: Subathra_14/05/2026_Error_Slayers_Cyclos_UserLogin

  Background:
    Given that the user launches the application
    When the user clicks the Login link

  @Valid
  Scenario: Login with valid credentials
    When the user enters the valid userName and valid password
    And click submit button
    Then the user should be able to see the dashboard page

  @Invalid
  Scenario Outline: Login with Invalid Credentials
    When the user enters the invalid username as "<invalid userName>" and invalid password as "<invalid password>"
    And click submit button
    Then the user should see the "The given name / password are incorrect. Please, try again." alert meaasage

    Examples:
      | invalid userName | invalid password |
      | Subu             | 1234             |
      | Shobana          | 5678             |
      | Akkshee          | 9876             |

  @BlankUsername
  Scenario: Login with Blank Username
    When the user enters a valid password and leaves the username field blank
    And click submit button
    Then the user should be able to see the "The field is required" error message under username filed

  @BlankPassword
  Scenario: Login with Blank password
    When the user enter a valid userName and leaves the password field blank
    And click submit button
    Then the user should be able to see the "The field is required" message under password filed
