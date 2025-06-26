Feature: Login
@regression
Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome browser
	When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	And User enters Email as "Admin" and Password as "admin123"
	And Click on Login
	Then Page Title should be "OrangeHRM"
	When User click on mendauser link
	When User click on Log out link
	Then Page Title should be "OrangeHRM"
	And close browser

	
	Examples:
|email|password|
|Admin|admin123|