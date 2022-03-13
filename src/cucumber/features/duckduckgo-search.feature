Feature: Search text with DuckDuckGo.com

  Scenario: Search with https://duckduckgo.com/
    Given Page https://duckduckgo.com/ opened in browser
    When Search phrase: W pustyni i w puszczy entered in search input box
    And Key Enter pressed
    Then First 3 search results contain phrase: W pustyni i w puszczy
