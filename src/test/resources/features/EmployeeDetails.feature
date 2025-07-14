Feature: Test employee endpoint api calls

  @zapScan
  Scenario: GET employee details using query parameter surname, verify status code
    Given I have a valid authentication token
    When I GET the "/employee?forename=Alice" endpoint
    Then I should receive "200" as response code

  @zapScan
  Scenario: GET all employee details, verify status code
    Given I have a valid authentication token
    When I GET the "employee" endpoint
    Then I should receive "200" as response code

  @zapScan
  Scenario: GET employee details by id, verify status code
    Given I have a valid authentication token
    When I GET the "employee/62c46f3b-7197-4401-8ec4-8b3ad5847ca4" endpoint
    Then I should receive "200" as response code
#    And I start the active scan using zap

#  @zapScan
#  Scenario: Post employee details using query parameter surname, verify status code and Response JSON.
#    Given I have the following employee data
#    When I send a POST request to the employee endpoint
#    Then I should receive "201" as response code