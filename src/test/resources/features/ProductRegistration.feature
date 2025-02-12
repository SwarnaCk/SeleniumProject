Feature: Project Registration with site id
  //@SCRUM-TC-219
  Scenario: Successful product registration with site id
    Given I am on the login page
    When I enter username
    And I enter password
    And I click the login button
    Then I should be logged in successfully