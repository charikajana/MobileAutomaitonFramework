@Regression @sanityTest @TestcaseID22375
Feature: gmaillogin

  Scenario Outline: Verify login to application
    Given launch browser and open application
    And Enter username "<mailID>" and Enter password "<passowrd>"

    Examples: 
      | mailID                | passowrd   |
      | meetkvchssdi@gmail.com | 8971990162 |
