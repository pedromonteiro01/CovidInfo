Feature: Covid
    Scenario: Search for covid data in Spain
        When I navigate to 'http://localhost:8080/'
        And I search for 'Spain' on the list bar
        And click on the search button
        Then Covid Data is presented at 'Select the country you want to search' section

    Scenario: Search for covid data for a country not available
        When I navigate to 'http://localhost:8080/'
        And I search for 'X', that is not available, on the search bar
        And click on the search button
        Then I can see that nothing is shown at 'Write the country you want to search' section