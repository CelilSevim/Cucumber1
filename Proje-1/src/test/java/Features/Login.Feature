Feature: Login

  Scenario: Login with correct username and password
    Given Go to site
    And click to login button
    When enter usurnsme
    And enter password
    And click to submit button
    Then Verify that Mein Konto appears