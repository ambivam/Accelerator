@DBTesting
Feature: New coach registration with the purchase of Shakeology HD (Monthly Shipment) on TBB site

  Scenario Outline: New coach registration with the purchase of Shakeology HD (Monthly Shipment) on TBB site
    Given I am on TBB home page
    When I click on become a coach from coach menu
    Then signup page should be displayed
    And I enter my information "<country>","<language>","<pswd>","<phone>","<month>","<day>","<year>","<govtid>","<sign>"
    When I click on Continue
    Then Coach registered sucessfully and navigated to challenge pack step
    And I click on No thanks button to navigate to shakeology step
    When I select Shakeology pack "<pack>"
    And I add to cart shakeology order with "<pack_size>","<ordere_type>" and "<qty>" options
    Then I click on No thanks buttons to navigate to offers page
    Then I skip offers to continue shopping
    Then I enter my shipping information "<address>","<city>","<state>","<zip>"
    And I validates the QAS address
    Then I select shipping option "<shipping>" and click on continue
    And I enter payment information "<ccfname>" , "<cclname>" , "<cardno>" , "<ccmonth>" , "<ccyear>" , "<cvv>"
    And I submit order
    Then I should be able to see a successful order placement with an Order ID

    Examples: Test data for the place shakeology order scenario
      | country | language | pswd        | phone      | month | day | year | govtid    | sign      | pack       | pack_size | ordere_type | qty | address              | city         | state | zip   | shipping | ccfname | cclname | cardno           | ccmonth | ccyear | cvv |
      | US      | en       | Coosign#123 | 3456789012 |    01 |  22 | 1993 | 567895432 | /s/SMAPLE | SHKCHVegan |        30 | Monthly     |   1 | 3301 Exposition Blvd | Santa Monica | CA    | 90404 |        1 | testing | test    | 4444444444444448 |      08 |   2024 | 123 |
