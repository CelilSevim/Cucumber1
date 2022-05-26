Feature: DropDown Menu

  Scenario: Does the drop down menu work?

    Given go to site
    And click to allproduct button
    When make a random selection from the menu
    Then check if the products match the criteria you selected