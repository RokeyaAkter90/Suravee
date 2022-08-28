Feature: This is a validate user can see new homes

@BOFA
Scenario: Verify user can see new homes
Given Lauch BOFA application url
Then Click on Home Loans Link
When Click on Find a home Link 
Then Click on New Construction
Then Verify user can see new construction homes