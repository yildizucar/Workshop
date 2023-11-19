@todo @ignore
Feature: ToDo List Functionality

  BUNU AUTOMATE ETMEYI DENEYEBILIRSINIZ. FEEDBACK ICIN TEMASA GECEBILIRSINIZ.

  Background: User is on the todo home page
    Given user navigates to "http://todomvc4tasj.herokuapp.com/"

  Scenario: Adding and deleting all tasks
    When I add the following tasks
      | Task 1 |
      | Task 2 |
      | Task 3 |
    Then all tasks should be displayed on the list
    When I mark "Task 2" as done
    Then I verify "Task 2" is displayed as completed
    When I click on delete button for "Task 3"
    Then I verify "Task 3" is deleted
    When delete all tasks
    Then verify all tasks are deleted


  Scenario: ToDo List functionality
    When I add the following tasks
      | Task 1 |
      | Task 2 |
      | Task 3 |
    And I click on "Completed" button on footer
    Then 0 completed tasks should be displayed
    When I click on "All" button on footer
    And I change "Task 3" name to "New Task"
    And delete all tasks
    Then verify all tasks are deleted

