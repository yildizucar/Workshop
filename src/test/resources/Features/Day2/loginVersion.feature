Feature: Login functionality of SauceDemo.com

  As a new user, I should be able to login with valid credentials


  Scenario: Login With Valid Credentials
    #Data table olarak yazilabilir
    Given user login to the website
      | username | standard_user |
      | password | secret_sauce  |

    # options  ben actim bu classi:

  Scenario: Login With Valid Credentials
    Given user is on landing page
    When user login as 'standard_user'

  Scenario: Login With Valid Credentials
    Given  I login as 'standard_user'

  Scenario: Login With Valid Credentials
    Given  I login
