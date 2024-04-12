Feature: Webpage_login.

@TC_No._01
#Scenario: Registration page.
#Given  User Login the URL 'https://parabank.parasoft.com/parabank/index.htm'
#When URL open successfully.
#Then Click on Register link.
#Then Provide Customer details.
#Then Count the number of textfield.
#Then Click on RegisterButton.
#Then Print Welcome message.

@TC_No._02
Scenario: Login Page.
Given  User Login the URL 'https://parabank.parasoft.com/parabank/index.htm'
When URL open successfully.
Then Provide User Name and Password.
Then click on login button.
 
@TC_No.03
Scenario: Account Overview.
Given Click on Account_Overview Link.
When Link get clicked successfully get account_details.
Then Click on Account_Number.

@TC_No.04
Scenario: Dropdown Selection.
Given Select Dropdown.
When Dropdown get click.

