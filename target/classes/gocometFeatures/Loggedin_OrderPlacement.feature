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

Feature: Logged in order

Scenario: User Open website User is able to place order after logging inside website

Given User is logged in 
When Click on "Phone" Category and add "Nexus 6" to Cart
Then Product "Nexus 6" should be added to cart and Order must be placed


Scenario: User Open website User is able to place order after logging inside website
Given User is logged in 
When Click on "Laptops" Category and add "MacBook air" to Cart
Then Product "MacBook air" should be added to cart and Order must be placed


Scenario: User Open website User is able to place order after logging inside website for Monitor

Given User is logged in 
When Click on "Monitors" Category and add "ASUS Full HD" to Cart
Then Product "ASUS Full HD" should be added to cart and Order must be placed