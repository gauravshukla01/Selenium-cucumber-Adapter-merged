@APIAutomation1
Feature: WebAPI_Automation
  I want to use this template for my feature file to Automate a RestAPI

  Background: Datafile reading for the feature
    Given A workbook named "WebAPI_myTest" and sheet named "myTest" is read

     
  @postcall @addCar
  Scenario: Add car service1
    Given BaseUri is "https://jsonplaceholder.typicode.com/users"
    When User performs "Get" operation with "" with correct values as par ""
    Then Verify the "200" status code for the Response
    And Verify response matches scheme "json-schema2.json"



      
