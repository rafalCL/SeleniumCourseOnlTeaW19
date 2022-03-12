package pl.coderslab.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelMainPage {
    private WebDriver driver;

    public HotelMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void subscribeToNotifications(String email) {
        WebElement newsletterInput = driver.findElement(By.id("newsletter-input"));
        WebElement submitNewsletter = driver.findElement(By.name("submitNewsletter"));
        newsletterInput.clear();
        newsletterInput.sendKeys(email);
        submitNewsletter.click();
    }

    public String getSuccessText() {
        WebElement successPanel = driver.findElement(By.cssSelector(".alert.alert-success"));
        return successPanel.getText();
    }
}
