# new feature
# Tags: optional

Feature: Customer Login

  Scenario Outline: Customer Login Successfully
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    When  I select username as <username>
    Then  I verify that user can see login button appears
    When  I click login button
    Then  I verify that user as <customer> login successfully

      Examples:
        |   username      |   customer  |
        |   Ron Weasly    | Ron Weasly  |