package pl.coderslab;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelTest {
    @Test
    public void shouldSearchWithDuckDuckGo() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElementUtil.setText("Warsaw", hotelLocationInput);
        WebElement newsletterEmailInput = driver.findElement(By.id("newsletter-input"));
        WebElementUtil.setText("test@test.com", newsletterEmailInput);
//        driver.quit();
    }
}
