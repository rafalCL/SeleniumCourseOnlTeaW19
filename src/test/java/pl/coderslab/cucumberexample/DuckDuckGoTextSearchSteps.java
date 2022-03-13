package pl.coderslab.cucumberexample;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DuckDuckGoTextSearchSteps {
    private WebDriver driver;
    private DuckDuckGoMainPage ddgMainPage;

    @Given("^Page (.*) opened in browser$")
    public void pageOpenedInBrowser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(pageUrl);
        this.ddgMainPage = new DuckDuckGoMainPage(driver);
    }

    @When("^Search phrase: (.*) entered in search input box$")
    public void searchForPhrase(String phrase) {
        ddgMainPage.enterSearchPhrase(phrase);
    }

    @And("^Key Enter pressed$")
    public void pressEnterInSearchInput() {
        ddgMainPage.submitSearchPhrase();
    }

    @Then("^First (.*) search results contain phrase: (.*)$")
    public void firstResultsContainPhrase(int count, String requiredPhrase) {
        List<String> searchResultsLinksTexts = ddgMainPage.getSearchResultsLinksTexts();

        for (int i = 0; i < count; i++) {
            String linkText = searchResultsLinksTexts.get(i);
            if (!linkText.toLowerCase()
                    .contains(requiredPhrase.toLowerCase())) {
                Assert.fail(String.format("Result should contain (case insensitive): %s, but was: %s", requiredPhrase, linkText));
            }
        }
    }
}
