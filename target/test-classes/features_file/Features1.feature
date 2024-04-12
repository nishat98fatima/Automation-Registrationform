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
@tag
Feature: Registration_form.
  

  #@TC_No.01
  #Scenario: Positive_Scenario.
    #Given Fill the details present in registration_form.
    #When Upload the file
    #Then Action on Submit button.
    #
  @TC_No_02
  Scenario Outline: Negative_Scenario required_field missing.
    Given Fill the details with required values "<keyword>"
    And Click on Submit button
    Then Verify the result "<result>"

    Examples: 
      #| First Name  | Last Name | Mobile     | Highest Qualification | Government ID |Govt. ID number | Email         |Date of Birth |Experience Range(years)|Preferred Role    |Certifications: |Upload resume|result|
      #|             | Fatima    | 9199693639 | Graduate              | AADHAR        |234568732146    | nish@gmail.com| 01-03-97     | 0-3                   |Automation Tester | NA             | path        | Fail |
      #

      |keyword|result|
      |Test_1| Fail|