Feature: Product Search

  Scenario: Successful search for existing product
    Given the user is on the OpenCart home page
    When the user searches for the product "MacBook"
    Then the user should see at least one result with the name "MacBook"

  Scenario: Search for non-existent product
    Given the user is on the OpenCart home page
    When the user searches for the product "ProductoXYZ123"
    Then the user should see the message "There is no product that matches the search criteria."
