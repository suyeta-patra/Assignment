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

Feature: Order Placement 

Scenario: User Open website Click On Category , Add product to cart and Place Order for Same

Given User Navigated to Website
When Click on "Phones" Category and add "Samsung galaxy s6" to Cart
Then Product "Samsung galaxy s6" should be added to cart and Order must be placed


Scenario: User Open website Click On Category , Add product to cart and Laptop Order for Same

Given User Navigated to Website
When Click on "Laptops" Category and add "Sony vaio i5" to Cart
Then Product "Sony vaio i5" should be added to cart and Order must be placed


Scenario: User Open website Click On Category , Add product to cart and Laptop Order for Same

Given User Navigated to Website
When Click on "Monitors" Category and add "Apple monitor 24" to Cart
Then Product "Apple monitor 24" should be added to cart and Order must be placed










