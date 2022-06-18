@smoke
  Feature: Guest User can add to Wishlist

    Background:
      Given guest user click on heart to add to wishlist

    Scenario: Item added successfully signs in Home Page
      Then Success Message appears with Green Background
      And Wishlist item count in Home Page increased by one


    Scenario: Item added successfully signs in Wishlist Page
      When guest user navigate to Wishlist Page
      Then guest user can see item quantity number is greater than zero