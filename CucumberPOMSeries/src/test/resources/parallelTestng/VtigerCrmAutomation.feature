Feature: Add Lead with help of Excel data

Background:
   Given user is already logged in to application
   |username|password|
   |admin|admin| 
   Given user is on Home Page 
   Then user gets the title of the page
   And page title should be "Home"
   When User selecting module by name "Leads"
   Then user gets the title of the page
   And page title should be "Leads"
    
   
   
   Scenario Outline: User Should select add lead
   Then user should click on add button
   And user should be see "Creating New Lead" form
   When user should fill form with given sheetname "<SheetName>" and rownumber <RowNumber>
   And user should click on save button
   Then it show lead information by getting first name
   
   Examples:
   |SheetName|RowNumber|
   |leads|0|
   |leads|1|
   
   