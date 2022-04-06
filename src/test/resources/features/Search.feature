Feature: As a user I want to get ability to search articles

  @smoke
  Scenario: Article should match the search query
    Given the user opens Cucumber website
    When the user clicks on the search icon
    And the user enters "Announces" in the opened search bar
    And the user filter search results by "Blog"
    And the user opens first link in the format Section|Article name
    Then page with selected article is displayed