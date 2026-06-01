@PayExternalUser_Shobana
Feature: Pay External User


Scenario: Verify external payment successfully

Given User should login successfully

When User clicks pay user option

And User clicks external payments option

And User clicks pay external user option

And User enters external payment details
| email         | amount | description |
| shi@gmail.com | 100    | hi          |

Then User should navigate to payment confirmation page

When User clicks confirm button

Then External payment should complete successfully



Scenario: Verify error message when email field is empty

Given User should login successfully

When User clicks pay user option

And User clicks external payments option

And User clicks pay external user option

And User leaves email field empty

And User enters amount and description
| amount | description |
| 100    | example         |

Then User should validate email error message "This field is required"