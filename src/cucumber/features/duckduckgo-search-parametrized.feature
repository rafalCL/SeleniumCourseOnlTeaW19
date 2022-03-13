Feature: Search text with DuckDuckGo.com

  Scenario Outline: Search with https://duckduckgo.com/
    Given Page https://duckduckgo.com/ opened in browser
    When Search phrase: <searchPhrase> entered in search input box
    And Key Enter pressed
    And Save Screenshot
    Then First <count> search results contain phrase: <expectedResultSubstring>
    And Quit WebDriver

    Examples:
    |searchPhrase          | expectedResultSubstring | count |
    |W pustyni i w puszczy | W pustyni i w puszczy   | 4     |
    |Faraon film           | Faraon                  | 3     |
    |Henryk Sienkiewicz    | Henryk Sienkiewicz      | 3     |
