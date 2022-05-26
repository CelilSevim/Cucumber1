Feature: Pictures and price

  Scenario:  Pictures and price information of products

    Given go to site
    And  click to allproduct button
    And  click to all button
    When get information of products
    Then verify the requested information
