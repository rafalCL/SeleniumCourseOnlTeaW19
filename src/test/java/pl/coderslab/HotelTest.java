package pl.coderslab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

    @Test
    public void shouldSearchWithDuckDuckGo() {
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElementUtil.setText("Warsaw", hotelLocationInput);
        WebElement newsletterEmailInput = driver.findElement(By.id("newsletter-input"));
        WebElementUtil.setText("test@test.com", newsletterEmailInput);
//        driver.quit();
    }

    @Test
    public void shouldAddErrorBorderToEmptyFormElements() {
        // given
        final String pageUrl = "https://hotel-testlab.coderslab.pl/en/";
        driver.get(pageUrl);
        // when
        WebElement submitButton = driver.findElement(By.id("search_room_submit"));
        submitButton.click();
        // then
        assertEquals(pageUrl, driver.getCurrentUrl());
        List<WebElement> errorBorderElements = driver.findElements(By.cssSelector("#search_hotel_block_form .error_border"));
        assertEquals(4, errorBorderElements.size());
    }
}
