# new feature
# Tags: optional

Feature: Customer Deposit

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    When I login successfully with username as Ron Weasly

  Scenario Outline: Customer Deposit unSuccessfully
    When I click deposit tab
    And I type the depsit as <deposit>
    And I click deposit submit button
    Then I verify that customer deposit unsuccessfully

    Examples:
     | deposit |
     |         |


  Scenario Outline: Customer Deposit Successfully when the input valid
    When I click deposit tab
    And I type the depsit as <deposit>
    And I click deposit submit button
    Then I verify that customer deposit successfully as <deposit>

    Examples:
   | deposit | deposit |
   | 2000    |2000    |
   | 3000    |3000    |


