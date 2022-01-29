@login
Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "vtiger CRM 5 - Commercial Open Source CRM"

  Scenario: Forgot Password link
    Given user is on login page
    Then Read License link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "admin"
    And user enters password "admin"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "Home"
