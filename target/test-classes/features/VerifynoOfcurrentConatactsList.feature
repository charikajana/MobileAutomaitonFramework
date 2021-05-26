@Regression @sanityTest @TestcaseID22374
Feature: WhatsUP

  Scenario Outline: Verify no of Current Contact List existed in Whats Up
  	Given login to gmail application

    Examples: 
      | name  | integerswith | status |
      | chari |            3 | true   |
