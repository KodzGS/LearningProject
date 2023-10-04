Feature: Search
  As a user
  I want to login into Gymshark
  So that i can access my account

  Scenario: Login to Gymshark account
    Given I have access the site and login page
    When I key in my username and password
    Then I should my see account