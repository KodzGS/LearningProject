Feature: Search
  As a user
  I want to login into Gymshark
  So that i can access my account

  Scenario: Login to Gymshark account
    Given I access the Gymshark app
    When I accept cookies
    Then I should see the features on the site