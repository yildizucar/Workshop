Feature: Shopping Cart Functionality

  Background:
    Given I login as "standard_user"

  Scenario: Validate various elements
    Then verify 6 product are listed on Products Page
    And verify that sort dropdown has this options
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |
    And verify hamburger menu contains
      | All Items       |
      | About           |
      | Logout          |
      | Reset App State |
#  NOT: Bazen asagidaki formatta cikabiliyor karsimiza. Yapabildiginizi yapin
    And verify hamburger menu contains following submenus
      | All Items, About, Logout, Reset App State |


  Scenario: Validate sort options
    When user sort the items by "Name (A to Z)"
    Then verify that items are sorted by "name"








  #    When user sort the items by "Price (low to high)"
#    Then verify that the item with lowest price is displayed first
#    And verify that items are sorted by "price"