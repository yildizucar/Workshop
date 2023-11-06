@login @SCD-1234 @regression
Feature: Login functionality of SauceDemo.com

  As a new user, I should be able to login with valid credentials

  @demo
  Scenario: Login With Valid Credentials
    Given user login to the website
      | username | standard_user |
      | password | secret_sauce  |
    Then verify login is successful
    And verify page header is "Products"


  Scenario Outline: Login With Invalid Credentials
    Given user login to the website
      | username | standard_user |
      | password | 1234          |
    Then verify the "<error_message>" in "<page>" page

    Examples:
      | error_message                                               | page  |
      | Username and password do not match any user in this service | login |