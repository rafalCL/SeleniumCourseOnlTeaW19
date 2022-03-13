package pl.coderslab.cucumberexample;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DuckDuckGoTextSearchSteps {
    private WebDriver driver;

    @Given("^Page (.*) opened in browser$")
    public void pageOpenedInBrowser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(pageUrl);
    }

    @When("^Search phrase: (.*) entered in search input box$")
    public void searchForPhrase(String phrase) {
        WebElement searchInputBox = driver.findElement(By.id("search_form_input_homepage"));
        searchInputBox.clear();
        searchInputBox.sendKeys(phrase);
    }

    @And("^Key Enter pressed$")
    public void pressEnterInSearchInput() {
        WebElement searchInputBox = driver.findElement(By.id("search_form_input_homepage"));
        searchInputBox.sendKeys(Keys.ENTER);
    }

    @Then("^First (.*) search results contain phrase: (.*)$")
    public void firstResultsContainPhrase(int count, String requiredPhrase) {
        List<WebElement> searchResultsLinks = driver.findElements(By.className("result__a"));
        for (int i = 0; i < count; i++) {
            String linkText = searchResultsLinks.get(i).getText();
            if (!linkText.toLowerCase()
                    .contains(requiredPhrase.toLowerCase())) {
                Assert.fail(String.format("Result should contain (case insensitive): %s, but was: %s", requiredPhrase, linkText));
            }
        }
    }
}
