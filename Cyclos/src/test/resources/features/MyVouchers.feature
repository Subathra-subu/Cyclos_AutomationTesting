Feature: SRIRAM_K_17_5_2026_MyVochers
   description : This feature tests the My Vouchers section, ensuring users can view and manage their vouchers correctly.

  Background:
    Given the user in the Marketplace place page
    And the user click the MyVochers

  @buyVouchers @cinema
  Scenario: To verify the Cinema voucher
    When the user clicks the Buy Voucher button
    And the user clicks the Cinema voucher in button
    And the user enter the Number of vochers "1" and enter amount "1"
    And the user click the next button
    And the user clicks the Confirm button
    Then the user should seen the "1,00 IU's"

  @buyVouchers @gift
  Scenario: To verify the gift voucher
    When the user clicks the Buy Voucher button
    And the user clicks the gift voucher in button
    And the user enter the Number of vochers "1" and enter amount "1"
    And the user click the next button
    And the user clicks the Confirm button
    Then the user should seen the "1,00 IU's"

  @buyVouchers @restaruant
  Scenario: To verify the restaruant voucher
    When the user clicks the Buy Voucher button
    And the user clicks the restaruant voucher in button
    And the user enter the Number of vochers "1" and enter amount "1"
    And the user click the next button
    And the user clicks the Confirm button
    Then the user should seen the "1,00 IU's"
