package pl.coderslab.cucumberexample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoTextSearchSteps {
    private WebDriver driver;

    @Given("^Page https://duckduckgo.com/ opened in browser$")
    public void pageOpenedInBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://duckduckgo.com/");
    }

//        searchInputBox.submit();

    @When("^Search phrase: \"W pustyni i w puszczy\" entered in search input box$")
    public void searchForPhrase() {
        WebElement searchInputBox = driver.findElement(By.id("search_form_input_homepage"));
        searchInputBox.clear();
        searchInputBox.sendKeys("w pustyni i w puszczy");
    }
    //    And Key Enter pressed
//    Then First 3 search results contain phrase: "W pustyni i w puszczy"
}
