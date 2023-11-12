@cart
Feature: Shopping Cart Functionality

  Background:
    Given I login as "standard_user"

  Scenario Outline: Validate various elements
    When user add "<item1>" to shopping cart
    And user add "<item2>" to shopping cart
    And user add "<item3>" to shopping cart
    And user navigates to the shopping cart
    Then verify that the added items are present in the cart
      | <item1> |
      | <item2> |
      | <item3> |

    Examples:
      | item1                   | item2               | item3                 |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Sauce Labs Bike Light |

