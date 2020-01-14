# new feature
# Tags: optional

Feature: Customer Transaction

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    When I login successfully with username as Ron Weasly

  Scenario Outline: Customer Transaction Successfully
    When I type deposit successfully with deposit as <deposit>
    When I type deposit successfully with withdrawl as <withdrawl>
    When I click transaction tab
    Then I verify the data at transaction correct as <deposit> and <withdrawl>
    When I click reset button
    Then I verify the data transaction reseted
    When I click back button
    Then I verify page transaction backed

    Examples:
    | deposit | withdrawl |
    | 2000    | 1000      |

