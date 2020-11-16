Feature: Perform HTTP requests on Single Article and verify the status code

  @api
  Scenario: Perform GET request and verify the status
    Given I perform GET article request

  @api
  Scenario: Perform POST request and verify the status
    Given I perform POST article request

  @api
  Scenario: Perform DELETE request and verify the status
    Given I perform DELETE article request