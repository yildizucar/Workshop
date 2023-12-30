@day2
Feature: Shopping Cart Functionality

  #TETS CASE , Urunleri sec, 1 tanesini sil (remove) , add to cart 3 dogru sayi verify yap

  Scenario Outline: Validate shopping cart
  # Given user is on landing page
    Given user login as "standard_user"
    When user add "Sauce Labs Fleece Jacket" to shopping cart
    And user add "<item1>" to shopping cart
    And user add following items to cart
      | <item2>           |
      | <item3>           |
      | Sauce Labs Onesie |
    When user removes "<item3>" from shopping cart
    Then verify shopping cart contains 4 item

    Examples:
      | item1                   | item2               | item3                 |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Backpack | Sauce Labs Bike Light |