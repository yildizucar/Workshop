@shopping @DIM-23421 @regression
Feature: Shopping Cart Functionality

  Background:
    Given user is on main page
    And user login as "standard_user"

  @menu
  Scenario: Verify dropdown content
    Then verify 6 product are listed on Products Page
    And verify that sort dropdown has this options
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |
    When user sort the items by "Price (low to high)"
    Then verify that the item with lowest price is displayed first
    And verify hamburger menu contains following submenus
      | All Items, About, Logout, Reset App State |
    And verify hamburger menu contains
      | All Items       |
      | About           |
      | Logout          |
      | Reset App State |

  Rule: Samples for usage of expressions
    Scenario: Verify user can add/remove items (1)
      When I add item number 1 to shopping cart
      And I add item number 3 to shopping cart
      And I remove item number 3 to shopping cart
      Then verify shopping cart contains 1 item

    Scenario: Verify user can add/remove items (2)
      When user adds 1st item to shopping cart
      And user adds 3rd item to shopping cart
      And user removes 1st item from shopping cart
      Then verify shopping cart contains 1 item

    Scenario: Verify user can add/remove items (3)
      And I add 2nd item to shopping cart
      And I add 4th item to shopping cart
      And I remove 2nd item from shopping cart
      Then verify shopping cart contains 1 item

  Rule: How to parameterize tests
    Scenario Outline: Verify user can add/remove items (3)
      And user adds "Sauce Labs Backpack" to shopping cart
      And user adds "<item1>" to shopping cart
      When user removes "<item2>" from shopping cart
      Then verify shopping cart contains 1 item

      Examples:
        | item1                   | item2               |
        | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack |