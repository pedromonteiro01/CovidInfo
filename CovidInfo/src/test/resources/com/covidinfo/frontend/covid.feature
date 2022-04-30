Feature: Covid
    Scenario: Search for covid data in Spain
        When I navigate to 'http://localhost:8080/'
        And user searches for 'Spain' on the list bar
        And clicks on the search button
        Then Covid Data is presented at 'Select the country you want to search'