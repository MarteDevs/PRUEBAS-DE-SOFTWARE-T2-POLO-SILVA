Feature: Shopping Cart

  Scenario: Add product to cart
    Given the user is on the OpenCart home page
    When the user adds the product "iPhone" to the cart
    Then the cart should show "1 item(s)"

  Scenario: Verify product in cart
    Given the user is on the OpenCart home page
    When the user adds the product "MacBook" to the cart
    And navigates to the cart
    Then the user should see the product "MacBook" in the cart list
