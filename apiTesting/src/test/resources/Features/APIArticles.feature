Feature: Perform HTTP requests on Articles and verify the success status

  @api
  Scenario: Perform GET request and verify the status
    Given I perform GET article request

  @api
  Scenario: Perform POST request and verify the status
    Given I perform POST article request

  @api
  Scenario: Perform DELETE request and verify the status
    Given I perform DELETE article request