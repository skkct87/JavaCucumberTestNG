Feature: Basic serach on Google

 Scenario: Want to search a company
 Given I have chrome browser
 When i search insert company name in search box
 Then it will start search with keyword
 And Get the title of website