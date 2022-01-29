@homepage
Feature: Naviagate Different Module By Selecting Tab

Background:
Given user is already logged in to application
   |username|password|
   |admin|admin| 
   
   @smoke
   Scenario: User should select leads module
   Given user is on Home Page 
   Then user gets the title of the page
   And page title should be "Home"
   When User selecting module by name "Leads"
   Then user gets the title of the page
   And page title should be "Leads"
   
   @Regression @skip
   Scenario: Module Tab section count 
   Given user is on Home Page 
   Then user gets module tab section
   |Calendar|
   |Leads|
   |Organizations|
   |Contacts|
   |Opportunities|
   |Products|
   |Documents|
   |Email|
   |Trouble Tickets|
   |Dashboard|
   |More|
   And Module count should be 11
   
   
   
   
