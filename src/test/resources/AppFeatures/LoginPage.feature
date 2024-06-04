Feature: Login Page feature

  Scenario: Login Page Title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "NASA SEWP Internal Tools"

  Scenario: Login with Correct Credentials
    Given user is on login page
    When user enters username "QATesters"
    And user enters password "wgPR8tH3tfAkLEb"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "NASA SEWP Internal Tools"

  Scenario: Forgot Password Link
    Given user is on login page
    Then forgot password link should be displayed

  Scenario: Login with Incorrect Credentials
    Given user is on login page
    When user enters wrong username "QATesters12"
    And user enters wrong password "wgPR8tH3tfAkLEb"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "NASA SEWP Internal Tools"
    And the user gets the error message "Username/Password does not match for QATesters12"
