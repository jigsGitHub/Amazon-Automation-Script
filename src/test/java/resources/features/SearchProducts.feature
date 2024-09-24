Feature: Search for products with specific attributes on Amazon UK

  Background: User is on Amazon UK homepage
    Given User navigates to Amazon UK website

  @regression
  Scenario Outline: List all Samsung phones with specified filters
    When User navigates to Electronics and Computers
    And User selects Phones and Accessories
    And User selects Mobile Phones
    When User filters by brand "<brand>"
    And User applies Camera Resolution filter to "<camera_resolution>"
    And User filters by Model Year "<model_year>"
    And User sets price range between "<min_price>" and "<max_price>"
    Then User should see a list of Samsung phones matching the applied filters

    Examples:
      | brand   | camera_resolution | model_year | min_price | max_price |
      | Samsung | 20 MP and above   | 2023       | 50        | 100       |