@day4
Feature: Shopping Cart Functionality

  Background:
    Given I login as "standard_user"

  Scenario Outline: Validate various elements
    When user add "<item1>" to shopping cart
    And user add "<item2>" to shopping cart
    And user add "<item3>" to shopping cart
    And user navigates to the shopping cart
    And wait for 2 seconds (for demo)
    Then verify that the added items are present in the cart
      | <item1> |
      | <item2> |
      | <item3> |

    Examples:
      | item1                   | item2               | item3                 |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Sauce Labs Bike Light |


  Scenario Outline: Validate Checkout functionality
    When user add following items to cart
      | <item1> |
      | <item2> |
      | <item3> |
      | <item4> |
    And user navigates to the shopping cart
    And clicks on "Checkout" button
    And user enters checkout information
      | firstName | random |
      | lastName  | random |
      | zipCode   | random |
    And wait for 2 seconds (for demo)
    And clicks on "Continue" button
    And clicks on "Finish" button
    And wait for 2 seconds (for demo)
    Then verify user sees the "Thank you for your order!" message

    Examples:
      | item1                   | item2               | item3                 | item4                    |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Fleece Jacket |
