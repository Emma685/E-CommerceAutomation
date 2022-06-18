@smoke
  Feature: Guest user click on Slider to go to its product page

    Scenario: Guest user click on 1st slider
      When guest user click on slider "1"

      Then website go to Nokia page


    Scenario: Guest user click on 2nd slider
      When guest user click on slider "2"

      Then website go to iphone 6 page