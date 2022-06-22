Feature: Google Test
  This is example of using Cucumber-JVM with TestNG and Selenium

  Scenario: search google.com
  to verify google search is working
    Given I go to google
    When I query for "cucumber spring selenium"
    And click search
    Then google page title should become "cucumber spring selenium - Buscar con Google"


  Scenario: check search suggestion
  to verify suggestion appeared as the user type the query
    Given I go to google
    When I query for "cucumber spring selenium"
    Then i should see "cucumber selenium spring" as 1 of the suggested search