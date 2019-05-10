Feature: Login to Comerica Site

  Background: 
    Given A workbook named "LoginDetails" and sheet named "Sheet1" is read

  Scenario Outline: TS_01
    When Browser is launched and navigate to the specified url
    Then Click on login link
    Then Enter login credentials "<id>" and "<pass>"
	Then Click on login button
	And validate login failure message
	
    Examples: 
      | id 		| pass		| 
      | userid 	| password	| 
