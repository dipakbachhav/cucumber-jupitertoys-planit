Feature: Check mandatory errors and login functionality

  @contact
  Scenario: Mandatory fields error trigger and disappeared after entering mandatory fields.
    Given the Guest user is on the Jupiter toys contact page
    When the user submits the form without filling in mandatory data
    Then mandatory field required errors appear on the screen
    And errors should be disappeared after entering mandatory fields

  @contact
  Scenario: Guest user should be able to submit feedback information.
    Given the Guest user is on the Jupiter toys contact page
    When the user submits feedback form with the valid data
    Then feedback successfully submitted messages should be display

  @login
  Scenario: User should be able to login successfully.
    Given the Guest user is on the Jupiter toys login page
    When the user login with valid credentials
    Then the user should be login successfully