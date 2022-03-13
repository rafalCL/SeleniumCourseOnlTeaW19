package pl.coderslab.cucumberexample;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoMainPage {
    @FindBy(id = "search_form_input_homepage")
    private WebElement searchInputBox;
    @FindBy(className = "js-result-title-link")
    private List<WebElement> searchResultsLinks;

    public DuckDuckGoMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

        for (WebElement thisLink : searchResultsLinks) {
            result.add(thisLink.getText());
        }

        return result;
    }
}
