@SRIRAM
Feature: SRIRAM_K_17_5_2026_MyVochers
   description : This feature tests the My Vouchers section, ensuring users can view and manage their vouchers correctly.

  Background:
    Given the user login with the valid data
    And the user navigate to the Marketplace place page
    And the user click the MyVochers

  @buyVouchers @cinema
  Scenario Outline: To verify the Cinema voucher
    When the user clicks the Buy Voucher button
    And the user clicks the Cinema voucher in button
    And the user enter the Number of vochers "<no>" and enter amount "<amount>"
    And the user click the next button
    And the user clicks the Confirm button
    Then the user should seen the "<assert>"

    Examples:
      | no | amount | assert                          |
      | 11 | 100    | The voucher(s) has been bought. |
      | 2  | 200    | The voucher(s) has been bought. |
      | 2  | 20     | The voucher(s) has been bought. |

  @buyVouchers @gift
  Scenario Outline: To verify the gift voucher
    When the user clicks the Buy Voucher button
    And the user clicks the gift voucher in button
    And the user enter the Number of vochers "<no>" and enter amount "<amount>"
    And the user click the next button
    And the user clicks the Confirm button
    Then the user should seen the "<assert>"

    Examples:
      | no | amount | assert                          |
      | 30 | 3      | The voucher(s) has been bought. |
      | 20 | 2      | The voucher(s) has been bought. |
      | 20 | 2      | The voucher(s) has been bought. |

  @buyVouchers @restaruant
  Scenario: To verify the restaruant voucher
    When the user clicks the Buy Voucher button
    And the user clicks the restaruant voucher in button
    And the user enter the Number of vochers "<no>" and enter amount "<amount>"
    And the user click the next button
    And the user clicks the Confirm button
    Then the user should seen the "<assert>"

    Examples:
      | no | amount | assert                          |
      | 2  | 2      | The voucher(s) has been bought. |

      
   @MyVoucher 
  	Scenario: To verify the Valid voucher code to search
  	When the user enter the valid voucher code in the voucher code field
  	And the user click the result 
  	Then the user should seen the same valid voucher code 
      | 3  | 5      | The voucher(s) has been bought. |

  @csv @smoke
  Scenario: Verify voucher code search using CSV data
    When the user enter the valid voucher code "<code>"
    And the user click the result
    Then the user should seen the Qr code code