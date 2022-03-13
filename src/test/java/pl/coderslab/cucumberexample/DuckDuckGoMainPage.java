package pl.coderslab.cucumberexample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoMainPage {
    private WebDriver driver;
    @FindBy(id = "search_form_input_homepage")
    private WebElement searchInputBox;

    public DuckDuckGoMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterSearchPhrase(String phrase) {
        searchInputBox.clear();
        searchInputBox.sendKeys(phrase);
    }

    public void submitSearchPhrase() {
        searchInputBox.sendKeys(Keys.ENTER);
    }

    public List<String> getSearchResultsLinksTexts() {
        List<String> result = new ArrayList<>();
        List<WebElement> searchResultsLinks = driver.findElements(By.className("js-result-title-link"));

        for (WebElement thisLink : searchResultsLinks) {
            result.add(thisLink.getText());
        }

        return result;
    }
}
