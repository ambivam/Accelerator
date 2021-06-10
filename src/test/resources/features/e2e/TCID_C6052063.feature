Feature: Validate coach can send an email to Customers

  Scenario Outline: Validate coach can send an email to Customers using Beachbody Coach Email
    Given I am logged in to COO
    Then I verify Coach Office home page is displayed
    When I click on Grow My Business header
    Then I verify Grow My Business menu options displayed
    When I click on Send an Email link in Grow My Business section
    Then I verify Send an Email page is displayed
    When I select from email address as "<email_from>" and recipiants as "<recipient>"
    Then I select couple of test customers and click on Compose button
    And I enter email address "<emailId>" and subject "<emailsub>" and body of the email "<emailbody>" and click on SEND button
    Then I verify snackbar sucess message
    And I verify the emails are received by the test customers

    Examples: 
      | email_from | recipient | emailId                 | emailsub | emailbody |
      | bb-email   | customers | username182@yopmail.com | testing   | testemail  |
