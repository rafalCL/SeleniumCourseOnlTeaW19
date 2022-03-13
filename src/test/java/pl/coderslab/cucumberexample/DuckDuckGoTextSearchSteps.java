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

    @Given("^Page https://duckduckgo.com/ opened in browser$")
    public void pageOpenedInBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://duckduckgo.com/");
    }

    @When("^Search phrase: \"W pustyni i w puszczy\" entered in search input box$")
    public void searchForPhrase() {
        WebElement searchInputBox = driver.findElement(By.id("search_form_input_homepage"));
        searchInputBox.clear();
        searchInputBox.sendKeys("w pustyni i w puszczy");
    }

    @And("^Key Enter pressed$")
    public void pressEnterInSearchInput() {
        WebElement searchInputBox = driver.findElement(By.id("search_form_input_homepage"));
        searchInputBox.sendKeys(Keys.ENTER);
    }

    @Then("^First 3 search results contain phrase: \"W pustyni i w puszczy\"$")
    public void firstResultsContainPhrase() {
        List<WebElement> searchResultsLinks = driver.findElements(By.className("result__a"));
        final String requiredPhrase = "W pustyni i w puszczy";
        for (int i = 0; i < 3; i++) {
            String linkText = searchResultsLinks.get(i).getText();
            if (!linkText.toLowerCase()
                    .contains(requiredPhrase.toLowerCase())) {
                Assert.fail(String.format("Result should contain (case insensitive): %s, but was: %s", requiredPhrase, linkText));
            }
        }
    }
}
