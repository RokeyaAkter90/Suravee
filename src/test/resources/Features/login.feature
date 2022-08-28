Feature: This is a login functionality
 
Scenario: Verify user login
Given Lauch application1 url
Then Click on demologinlink
Then Enter demousername
Then Enter demopassword
When Click on demoLogin button
Then Verify demouserlogin sucessfully