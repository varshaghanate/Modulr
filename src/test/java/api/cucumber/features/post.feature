Feature:Test login functionality
  This will test the functionality of user

  Background: This is for common steps
    Given browser is open
    And user is on the login page

  Scenario: username and password fields are not empty
    When user missing enter username field and  password
    Then Error message should be displayed

  Scenario: Incorrect username or password
    When user enters incorrect username
    Then Warning will be displayed incorrect username
    When user enters correct username and incorrect password
    Then Warning will be displayed incorrect password


  Scenario: Correct username and password
    When User enters correct username and correct password
    And Click on Sign in button
    Then User is navigated to the homepage

  Scenario: Signin button should be disabled
  to prevent duplicate requests being triggered
    Given user is logged in
    When user is logged in another webpage
    Then Sign in button should be disabled

  Scenario: Reset password
    When User click on reset password button
    When User is navigated to the request a reset password page
    Then Allows user to request a reset password email