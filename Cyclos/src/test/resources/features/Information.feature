@SRIRAM
Feature: SRIRAM_K_23/06/2026_Information_ContactForm
  Description: Validate Information Contact Form Functionality

  Background:
    Given the user Login with the valid data
    When the user click the Information menu
    And the user clicks the Contact form

  @contactFormValid
  Scenario Outline: Verify Contact Form submission with valid details
    When the user fills the contact form with following details
      | from   | email             | subject         | message           |
      | <from> | <email>           | <subject>       | <message>         |
    And the user submits the contact form
    Then the user should see the contact form success message

    Examples:
      | from           | email                 | subject             | message                   |
      | Demo User      | demo@example.com      | Test Subject        | This is a test message    |
      | John Smith     | john@example.com      | Inquiry Question    | I would like to know more |

  @contactFormBlank
  Scenario: Verify validation when submitting blank contact form
    When the user fills the captcha
    And the user submits the contact form
    Then the user should see the required field error
