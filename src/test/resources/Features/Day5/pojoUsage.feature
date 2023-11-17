@day5
Feature: Shopping Cart Functionality

  Scenario Outline: Validate Checkout functionality USING POJO
    When user add following items to cart
      | <item1> |
      | <item2> |
    And user navigates to the shopping cart
    And clicks on "Checkout" button
    And user enters checkout information (pojo)
      | firstName | Ayfer |
      | lastName  | Dogan |
      | zipCode   | 33433 |
    And clicks on "Continue" button
    And verify customer information displayed in X page
    And clicks on "Finish" button
    Then verify user sees the "<warning>" message

    Examples:
      | item1                   | item2               | warning                   |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Thank you for your order! |