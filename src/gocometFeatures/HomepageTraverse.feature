#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: HomePage Traverse

Scenario: Verify User is able to Traverse to Home Page 

Given User Navigated to Website after browser initialisation
When Click on "Laptop" Category
Then Click on Home Page Button

Given User Navigated to Website after browser initialisation
When Click on "Monitors" Category
Then Click on Home Page Button

Given User Navigated to Website after browser initialisation
When Click on "Cart" Category
Then Click on Home Page Button
