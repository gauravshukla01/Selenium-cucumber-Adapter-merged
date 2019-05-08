Feature: Cucumber Test Scenarios 


Background: 
	Given A workbook named "BookTicket" and sheet named "Sheet1" is read 
	
Scenario: TS_04 
	When Browser is launched and navigate to specified url 
	
	 Scenario Outline: TS_02
    Then Book a bus ticket from "<location1>" to "<location2>"

    Examples: 
      | location1 | location2 |
      | from      | to        |
      