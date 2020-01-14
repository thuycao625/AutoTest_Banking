# new feature
# Tags: optional

Feature: Customer withdraw

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    When I login successfully with username as Ron Weasly

  Scenario Outline: Customer Withdrawl Successfully
    And I type deposit successfully with deposit as <deposit>
    When I open withdrawl tab
    When I type withdrawl as <withdrawl>
    And  I click withdrawl submit button
    Then I verify that customer withdrawl successfully as <withdrawl>

    Examples:
     | deposit | withdrawl |
     | 2000    | 1000      |


  Scenario Outline: Customer Withdrawl unSuccessfully
    And I type deposit successfully with deposit as <deposit>
    When I open withdrawl tab
    When I type withdrawl as <withdrawl>
    And  I click withdrawl submit button
    Then I verify that customer withdrawl unsuccessfully

    Examples:
    | deposit | withdrawl |
    | 1000    | 2000      |