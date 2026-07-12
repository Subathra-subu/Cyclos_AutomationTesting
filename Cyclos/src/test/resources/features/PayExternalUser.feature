@Shobana
Feature: Shobana_25/05/2026_Error_Slayers_Pay External User


Scenario: Verify external payment successfully

Given User should login successfully

When User clicks pay user option

And User clicks external payments option

And User clicks pay external user option

And User enters external payment details
| email         | amount | description |
| shobs@gmail.com | 10    | hi          |

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

Scenario: Verify external payment creation and cancellation

Given User should login successfully
When User clicks pay user option
And User clicks external payments option
And User clicks pay external user option
And User enters external payment details
  | email           | amount | description |
  | shobs@gmail.com | 10     | Cancel Test |
Then User should navigate to payment confirmation page

When User clicks confirm button
Then External payment should complete successfully

When User opens the payment with description "Cancel Test"
And User clicks "Cancel this external payment"
And User enters cancellation comment "Cancelled by automation"
And User clicks Confirm
Then External payment should be cancelled successfully
