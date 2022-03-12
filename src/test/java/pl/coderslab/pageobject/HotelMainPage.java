package pl.coderslab.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMainPage {
    @FindBy(id = "newsletter-input")
    private WebElement newsletterInput;
    @FindBy(name = "submitNewsletter")
    private WebElement submitNewsletter;
    @FindBy(css = ".alert.alert-success")
    WebElement successPanel;

    public HotelMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void subscribeToNotifications(String email) {
        newsletterInput.clear();
        newsletterInput.sendKeys(email);
        submitNewsletter.click();
    }

    public String getSuccessText() {
        return successPanel.getText();
    }
}
