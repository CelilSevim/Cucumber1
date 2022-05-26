@SearchAll
Feature: Search Functionality
  @Search @ProductSearch
  Scenario: Search a product
    Given user goes to homepage
    When user search for "mac"
    Then product's name should contain "mac"
