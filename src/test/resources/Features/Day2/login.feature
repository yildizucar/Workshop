@login @SCD-1234 @regression
Feature: Login functionality of SauceDemo.com

  As a new user, I should be able to login with valid credentials

  Scenario: Login With Valid Credentials
    Given user login to the website
      | username | standard_user |
      | password | secret_sauce  |
    # options:
    Then verify login is successful
    And verify page header is "Products"
    And verify title is "Swag Labs"
    And verify title is "Swag Labs" in "Products" page
    And verify page header is "Product"


  Scenario Outline: Login With Invalid Credentials
    Given user login to the website
      | username | standard_user |
      | password | 1234          |
    Then verify the "Username and password do not match any user in this service" in login page
    * verify the "<error_message>" in login page
    * verify the "<error_message>" in "<page>" page

    Examples:
      | error_message                                               | page  |
      | Username and password do not match any user in this service | login |


  Scenario Outline: Login With Invalid Credentials
    Given user login to the website
      | username | "<username>" |
      | password | "<password>" |
    Then verify the "Username and password do not match any user in this service" in login page
    * verify the "<error_message>" in login page
    * verify the "<error_message>" in "<page>" page

    Examples:
      | username      | password     | error_message                                               | page  |
      | standard_user | 1234         | Username and password do not match any user in this service | login |
      | user123       | secret_sauce | Username and password do not match any user in this service | login |
      |               |              | Username and password do not match any user in this service | login |


  @loginPojo
  Example: Pojo usage sample with login
    Given user login to page
      | username | standard_user |
      | password | secret_sauce  |
    And verify page header is "Products"