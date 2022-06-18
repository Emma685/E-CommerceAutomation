@smoke
  Feature: Search Products

    # 1st Test Case
    Scenario Outline: Guest user Search by Product KeyWord
      When guest user type product "<keyword>" in searh box
      And guest user click on Search Button

      Then Website goes to Search Page
      And List of relevant "<keyword>" products appears

      Examples:
      |keyword|
      |Apple|
      |Nike|
      |Necklace|


      # 2nd Test Case
      Scenario Outline: Guest user search by product SKU
        When guest user type product "<SKU>" in search box
        And guest user click on Search Button
        And guest user click on te product in search result

        Then product page appear with the same "<SKU>" in product details

        Examples:
        |SKU|
        |EG_GEM_NL|
        |APPLE_CAM|
        |CS_TSHIRT|

