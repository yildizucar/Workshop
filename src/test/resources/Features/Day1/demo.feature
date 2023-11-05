@cucumber @hookless
Feature: Example of simple Pojo usage

  We use scenario outline, to run the same scenario multiple times with different sets of data

  Scenario Outline: I love cucumber
    Given there are <start> cucumbers
    When I eat <eat> cucumbers
    Then I should have <end> cucumbers left

    Examples:
      | start | eat | end |
      | 12    | 5   | 7   |
      | 20    | 5   | 15  |
      | 23    | 3   | 20  |
      | 15    | 15  | 0   |