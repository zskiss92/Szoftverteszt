Feature: Purchase item test
  Scenario: Purchase item should be success
    Given Sign in to the site
    And Open the details page of the item
    And Add the item to cart
    And Open the cart page
    And Open the checkout page
    And Fill the necessary fields
    When The finish button clicked
    Then Purchase should be success