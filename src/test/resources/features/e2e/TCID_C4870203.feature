@AccountUpdate
Feature: My Account update - Account address and Shipping Address

  Scenario Outline: My Account update- validating Account address and Shipping Address in OIM, EBS, ByDesign and Coach office
    ##updating existing customer Billing and Shipping addresses in TBB
    Given I am on TBB home page
    When I click on MyAccount under Sign In link on the global header
    And I enter the existing customer email "<email>" and password "<password>"
    And I click on Sign in button
    When I click on edit link in Account Address
    And I change the Billing Address fileds "<billingAddress>", "<billingCity>" and "<billingZipCode>"
    And I click on update button
    Then I should validate "<message>" popup message  in ATG
    When I click on Shipping Address link
    And I change the Shipping Address fileds "<shippingAddress>","<shippingCity>" and "<shippingZipCode>"
    And I click on shipping address update button
    Then I should validate "<message>" popup message  in ATG
    ##validating account address in OIM
    Given I am on OIM Login Page
    When I search for user with email in OIM application
    Then I should validate Billing and Shipping adressess in OIM
    ###validate account address in ByDesign
    Given I am logged in to ByDesign
    When I search for customer with email in ByDesign application
    Then I should validate Billing and Shipping adressess in ByDesign
    ###validating account address in Coach office
    Given I am logged in to COO
    When I search for the order with order number in COO application
    Then I should validate Billing and Shipping addresses in Coach office

    Examples: 
      | email                    | password    | billingAddress     | billingCity | billingZipCode | message                                    | shippingAddress    | shippingCity | shippingZipCode |
      | username8973@yopmail.com | Testing1234 | 1313 Disneyland Dr | Anaheim     |          99999 | Your address has been successfully updated | Golden Gate Bridge | Anaheim      |           67357 |
