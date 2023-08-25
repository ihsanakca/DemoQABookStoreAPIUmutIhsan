Feature: Add new book

  Scenario: User should be able to add new book to the collection
    Given User should add new book
    Then User should verify the addBookStatusCode