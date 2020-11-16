Feature: Lists of Articles and verify the success status

  @api
  Scenario: GET lists of Articles and verify the status
    Given I perform GET articles request


  @api
  Scenario: Perform POST request and verify the status
    Given I perform POST articles request

  @api
  Scenario: Perform DELETE request and verify the status
    Given I perform DELETE articles request