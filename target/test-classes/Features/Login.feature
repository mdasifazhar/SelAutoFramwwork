Feature: Login functionality

  Scenario: login to the application
    Given: open the url "https://www.amazon.com"
    When: User login to the applcation using credential "mdasifazhar@yopmail.com" and "test@123".
    Then: Login successfully.
    And: Validate the home page.


  Scenario Outline: login with invalid credential
    Given: open the url "https://www.amazon.com"
    When: User login to the applcation using credential <userName> and <password>.
    Then:	User not able to login.
    Examples:
    |userName|passwod|

