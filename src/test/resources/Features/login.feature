#@login @CYZ-1234 @regression
#Feature: Login functionality of SauceDemo.com
#
#  As a new user, I should be able to login with valid credentials
#
#  Background:
#    Given user is on main page
#
#  Scenario: Login With Valid Credentials
#    Given the user login to the application
#      | username | standard_user |
#      | password | secret_sauce  |
#    Then verify title is "Swag Labs"