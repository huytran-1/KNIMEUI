Feature: UI Testing for Knime

  Scenario: Testing create space function
    Given I launch knime webpage
    And I click on sign in button
    And I enter username "Username" and password "Password"
    And I go to Spaces
    And I create new public space
    And I delete the created space
    And I verify space is deleted