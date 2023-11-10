@hookless @ignore
Feature: Options

#  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: Navigation Options
    Given user navigates to "https://www.saucedemo.com/"
    Given user is on landing page
    Given I go to login page

#  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  @login1
  Scenario: Login With Valid Credentials
    Given user is on landing page
    When user login as "standard_user"

  @login2
  Scenario: Login With Valid Credentials
    Given I login as "standard_user"

  @login3
  Scenario: Login With Valid Credentials
    Given I login

  @login4
  Scenario: Login With Valid Credentials
    Given user is on landing page
    When user login to the website
      | username | standard_user |
      | password | secret_sauce  |

#  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  Scenario: Login With Valid Credentials
    Given user is on landing page
    When user login as "standard_user"
    Then verify login is successful
    Then verify title is "Swag Labs"
    Then verify title is "Swag Labs" in "Products" page
    Then verify page header is "Product"

    And user add "Sauce Labs Fleece Jacket" to shopping cart
    And user add "Sauce Labs Bolt T-Shirt" to shopping cart

#  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: Login With Invalid Credentials
    Given user is on landing page
    When user login to the website
      | username | standard_user |
      | password | 123           |
    Then verify the "Username and password do not match any user in this service" in login page
    Then verify the "<error_message>" in login page
    Then verify the "<error_message>" in "<page>" page

    Examples:
      | error_message                                               | page  |
      | Username and password do not match any user in this service | Login |

  #  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~







































#
## positive
#    Then verify login is successful
#    Then verify title is "Swag Labs"
#    Then verify title is "Swag Labs" in "Production" Page
#
#
## negative
#    Then verify the "Username and password do not match any user in this service" in login page
#    Then verify the "<error_message>" in login page
#    Then verify the "<error_message>" in "<page>" page
#
#    Examples:
#      | error_message                                               | page  |
#      | Username and password do not match any user in this service | login |