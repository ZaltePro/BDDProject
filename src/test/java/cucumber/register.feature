@tag
Feature: Register the user in application
  i want to create the user using register

	Background:
	Given i want to open the Ecomerce site
	
  @tag2
  Scenario Outline: Create account with valid data
    Given I enter "<FirstName>" and "<Email>"
    When I want to enter Account information: "<Title>" , "<password>", "<dateofbirth>"
    And I want to enter Addresss information: "<FirstName>" , "<Lastname>", "<CompanyName>", "<address1>", "<address2>", "<Country>", "<State>", "<City>", "<zipcode>", "<mobileNumber>"
    Then  I want to verify the account is created

    Examples: 
    | Title | FirstName    | Lastname | Email                       | password   | dateofbirth | CompanyName | address1 | address2 | Country | State   | City      | zipcode | mobileNumber |
    | Mr    | Himanshu 		 |  Zalte   | zaltehimanshu2007@gmail.com  | Satva1213  | 31/12/1993  | Satva       | address1 | address2 | India   | Gujarat | Ahmedabad | 380016  | 9595959595   |

	Scenario: i want to delete the account
		Given Click the Delete account button on header bar
		When Varify the information messsage
		And Click the Okay button
		Then Check the deshboard 

	