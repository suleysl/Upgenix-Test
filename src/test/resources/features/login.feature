Feature: Upgenix Login Feature
	User Story :
	As a user, I should be able to log in with different accounts, so that I can land on homepage.


	Background: For the scenarios in the feature file, user is expected to be on the login page

		Given user is on the Upgenix login page

	@BRT-288
	Scenario Outline: Users can log in with valid credentials[AutomationS3-Sule]
	Positive Login Scenario


		When User enters valid "<Username>" and valid "<Password>"
		And user clicks on the "login" button on the login page
		Then user should see the title is "#Inbox - Odoo"

		Examples:
			|Username                |Password    |
		    |posmanager100@info.com  |posmanager  |
		    |salesmanager100@info.com|salesmanager|


	@BRT-289
	Scenario Outline: Verify that 'Wrong login/password' is displayed for invalid credentials[AutomationS3-Sule]
	Negative Login Scenario

		When User enters "<Username>" and "<Password>"
		And user clicks on the "login" button on the login page
		Then user should see "Wrong login/password" notice message

		Examples:
			| Username                  | Password     |
			| salesmanager@info.com     | 456745       |
			| posmanager100@info.com    | sales        |
			| ashdyrh@info.com          | salesmanager |


	@BRT-290
	Scenario Outline: "Please fill out this field" message should be displayed if username or password empty [AutomationS3-Sule]
	Negative login scenario for empty username and valid password

		When User enters "<Username>" or "<Password>"
		And user clicks on the "login" button on the login page
		Then error message is displayed

		Examples:

			| Username                | Password     |
			| posmanager100@info.com  |              |
			|                         | salesmanager |



	@BRT-310
	Scenario: Land on the 'reset password' page after clicking on the 'reset password' link [AutomationS3-Sule]
	Scenario for "Reset password" link

		When user clicks "Reset password" link
		Then user should see the title is "Reset password | Best solution for startups"



	@BRT-311
	Scenario: Users should see password in bullets [AutomationS3-Sule]
		When user enters password, user should see the password in bullet signs by default



	@BRT-312
	Scenario Outline: Verify if the 'Enter' key of the keyboard is working [AutomationS3-Sule]
		When user enters valid "<Username>" and valid "<Password>" and press Enter key
		Then user should see the title is "Odoo"

		Examples:

			| Username                 | Password     |
			| posmanager100@info.com   | posmanager   |
			| salesmanager100@info.com | salesmanager |

































