@shopping @regression
Feature: Shopping Cart Functionality

  Scenario Outline: Validate shopping cart
    Given user is on landing page
    When user login as "standard_user"
    And user add "<item1>" to shopping cart
    And user add following items to cart
      | <item2>           |
      | <item3>           |
      | <item4>           |
      | Sauce Labs Onesie |
    When user removes "<item3>" from shopping cart
    Then verify shopping cart contains 4 item

    Examples:
      | item1                   | item2               | item3                 | item4                    |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Fleece Jacket |