Feature: Create new address after login

  Scenario Outline: User can add new address
    Given User is logged in to  MyStore shop
    When User goes to addresses
    Then User goes to create new address
    And User fills in the form with <alias>, <address>, <city>, <zip/postal code>, <country>, <phone>
    And Save progress
    Then User sees "Address successfully added!"
    Examples:
      | alias | address | city | zip/postal code | country | phone |

