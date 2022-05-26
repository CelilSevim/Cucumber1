Feature: Sorting Process Menu

  Scenario: Sorting Process

    Given go to site_sort
    And click to allproduct button_sort
    And click to all button_sort
    When select to by average
    Then check that the order is correct