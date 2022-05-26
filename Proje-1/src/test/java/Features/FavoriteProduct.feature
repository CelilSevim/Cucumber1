Feature: Favorite Product

  Scenario: Adding Favorite Product

    Given go to site favorite
    And click to allproduct button favorite
    And click to all button favorite
    When Pick a random product
    And add product to favorites
    Then check if the product is in the favorite list